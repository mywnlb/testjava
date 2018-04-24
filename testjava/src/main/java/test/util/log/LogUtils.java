package test.util.log;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.util.ip.IpUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;


/**
 * Created by lb on 2018/3/21.
 */
public class LogUtils {
    public static  final Logger ERROR_LOG = LoggerFactory.getLogger("es-error");
    public static  final Logger ACCESS_LOG = LoggerFactory.getLogger("es-access");

    public LogUtils(){}

    public static void logAccess(HttpServletRequest request){
        String username = getUsername();
        String jsessionId = request.getRequestedSessionId();
        String ip = IpUtils.getIpAddr(request);
        String accept = request.getHeader("accept");
        String userAgent = request.getHeader("User-Agent");
        String url = request.getRequestURI();
        String params = getParams(request);
        String headers = getHeader(request);
        StringBuilder s = new StringBuilder();
        s.append(getBlock(username));
        s.append(getBlock(jsessionId));
        s.append(getBlock(ip));
        s.append(getBlock(accept));
        s.append(getBlock(userAgent));
        s.append(getBlock(url));
        s.append(getBlock(params));
        s.append(getBlock(headers));
        s.append(getBlock(request.getHeader("Referer")));
        getAccessLog().info(s.toString());
    }
    public static void logError(String message,Throwable e){
        String username = getUsername();
        StringBuilder s = new StringBuilder();
        s.append(getBlock("exception"));
        s.append(getBlock(username));
        s.append(getBlock(message));
        ERROR_LOG.error(s.toString(),e);
    }

    public static void logPageError(HttpServletRequest request) {
        String username = getUsername();
        Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
        String message = (String)request.getAttribute("javax.servlet.error.message");
        String uri = (String)request.getAttribute("javax.servlet.error.request_uri");
        Throwable t = (Throwable)request.getAttribute("javax.servlet.error.exception");
        if (statusCode == null) {
            statusCode = Integer.valueOf(0);
        }

        StringBuilder s = new StringBuilder();
        s.append(getBlock(t == null ? "page" : "exception"));
        s.append(getBlock(username));
        s.append(getBlock(statusCode));
        s.append(getBlock(message));
        s.append(getBlock(IpUtils.getIpAddr(request)));
        s.append(getBlock(uri));
        s.append(getBlock(request.getHeader("Referer")));

        StringWriter sw;
        for(sw = new StringWriter(); t != null; t = t.getCause()) {
            t.printStackTrace(new PrintWriter(sw));
        }

        s.append(getBlock(sw.toString()));
        getErrorLog().error(s.toString());
    }

    protected static String getUsername(){
        return (String) SecurityUtils.getSubject().getPrincipal();
    }
    public static Logger getErrorLog() {
        return ERROR_LOG;
    }

    public static Logger getAccessLog() {
        return ACCESS_LOG;
    }

    protected static String getParams(HttpServletRequest request){
        Map<String,String[]> params = request.getParameterMap();
        return JSON.toJSONString(params);
    }
    private static String getHeader(HttpServletRequest request){
        Map<String,List<String>> headers = Maps.newHashMap();
        Enumeration namesEnumeration = request.getHeaderNames();

        while (namesEnumeration.hasMoreElements()){
            String name = (String) namesEnumeration.nextElement();
            Enumeration<String> valueEnumeration = request.getHeaders(name);
            ArrayList values = Lists.newArrayList();

            while (valueEnumeration.hasMoreElements()){
                values.add(valueEnumeration.nextElement());
            }

            headers.put(name,values);
        }

        return JSON.toJSONString(headers);
    }

    public static String getBlock(Object msg){
        if(msg == null){
            msg = "";
        }
        return "["+msg.toString()+"]";
    }
}
