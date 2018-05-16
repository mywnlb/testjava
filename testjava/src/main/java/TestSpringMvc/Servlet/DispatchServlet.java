package TestSpringMvc.Servlet;

import TestSpringMvc.LbAnnot.LbAutired;
import TestSpringMvc.LbAnnot.LbController;
import TestSpringMvc.LbAnnot.LbParameter;
import TestSpringMvc.LbAnnot.LbService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by lb on 2018/5/9. 测试mvc中转servlet
 */
public class DispatchServlet extends HttpServlet {
    private Properties contextconfig = new Properties();
    private List<String> classnames = new ArrayList<String>();
    private HashMap<String,Object> ioc = new HashMap<String,Object>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //读取配置文件
        doLoadConfin(config.getInitParameter("contextConfigLocation"));
        //解析配置中的内容。扫描出所有相关内让你跟
        doScanner(contextconfig.getProperty("scanpackage"));
        //实例化扫苗的bean
        doInstace();
        //循环依赖
        doAutowired();
        //mappingp
        initHaderMapping();
    }

    private void initHaderMapping() {
        
    }

    private void doAutowired() {
        if(ioc.isEmpty()){return;}
        for(Map.Entry<String,Object> entry:ioc.entrySet()){
            Field[] fields =entry.getValue().getClass().getDeclaredFields();
            for(Field field:fields){
                if(field.isAnnotationPresent(LbAutired.class)){
                    LbAutired lbAutired = field.getAnnotation(LbAutired.class);
                    String beanname = lbAutired.value().trim();
                    if("".equals(beanname)){
                        beanname = field.getType().getName();
                    }

                    field.setAccessible(true);

                    try {
                        field.set(entry.getValue(),ioc.get(beanname));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    private void doInstace() {
        if(classnames.isEmpty()){return;}
        for(String classname:classnames){
            try {
                Class<?> clazz = Class.forName(classname);
                if(clazz.isAnnotationPresent(LbController.class)){
                    ioc.put(lowerFirstCase(clazz.getSimpleName()),clazz.newInstance());
                }else if(clazz.isAnnotationPresent(LbService.class)){
                    //默认首字母小写
                    //如果自己定义了beanname，则利用beanname
                    //根据类型和类型传入实现类
                    LbService lbService = clazz.getAnnotation(LbService.class);
                    String beanName = lbService.value();
                    if("".equals(beanName.trim())){
                        beanName = lowerFirstCase(beanName);
                    }

                    Object instace = clazz.newInstance();
                    ioc.put(beanName,instace);

                    Class<?>[] instfaces = clazz.getInterfaces();
                    for(Class<?> i :instfaces){
                        ioc.put(i.getName(),instace);
                    }

                }else {
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void doScanner(String packagename) {
        URL url = this.getClass().getClassLoader().getResource(File.separator+packagename.replaceAll("\\.",File.separator));

        File classDir = new File(url.getFile());
        for(File file:classDir.listFiles()){
            if(file.isDirectory()){
                doScanner(packagename+"."+file.getName());
            }else {
                classnames.add(packagename+"."+file.getName().replaceAll("class",""));
            }
        }
    }

    private void doLoadConfin(String location) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(location);
        try {
            contextconfig.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String lowerFirstCase(String str){
        char[] chars = str.toCharArray();
        chars[0] +=32;
        return String.valueOf(chars);
    }

    private class Handler{
        private Object instace;
        private Method method;
        private Pattern pattern;
        private Map<String,Integer> paranINdexMapping;

        public Handler(Object instace, Method method, Pattern pattern) {
            this.instace = instace;
            this.method = method;
            this.pattern = pattern;

            paranINdexMapping = new HashMap<String, Integer>();

            putParanIndexMapping(method);
        }

        private void putParanIndexMapping(Method method) {
            Annotation[][] pa = method.getParameterAnnotations();
            for(int i=0;i<pa.length;i++){
                for(Annotation a:pa[i]){
                    if(a instanceof LbParameter){
                        String paranName = ((LbParameter)a).value();
                        if("".equals(paranName)){
                            paranINdexMapping.put(paranName,i);
                        }
                    }
                }
            }
            Class<?>[] paramTypes = method.getParameterTypes();
            for(int i=0;i<paramTypes.length;i++){
                Class<?> type= paramTypes[i];
                if(type == HttpServletRequest.class
                        || type==HttpServletResponse.class){
                    paranINdexMapping.put(type.getName(),i);
                }
            }

        }

        private Object convert(Class<?> type,String value){
            if(Integer.class== type){
                return Integer.valueOf(value);
            }
            return value;
        }
    }
}
