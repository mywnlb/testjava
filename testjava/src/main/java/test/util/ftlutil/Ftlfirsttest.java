package test.util.ftlutil;

import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lb on 2018/3/1.   freemarker自定义指令测试
 */
@Component("ftlfirsttest")
public class Ftlfirsttest extends BaseDirective{

    private static final String CURRENT_USER_NAME = "username";
    private static final String CURRENT_PERMISSION_STR = "pers";
    private static final String CURRENT_MODULE_STR = "module";
    private static final String PERMISSION_ARR = "p_arr";


    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String username = FreemarkerUtils.getParameter(CURRENT_USER_NAME, String.class, params);
        String pers = FreemarkerUtils.getParameter(CURRENT_PERMISSION_STR, String.class, params);
        String module = FreemarkerUtils.getParameter(CURRENT_MODULE_STR, String.class, params);
        System.out.println(params);
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put(PERMISSION_ARR, new String[]{"1","2","3"});

    }
}
