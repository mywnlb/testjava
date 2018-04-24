package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lb on 2018/3/26.
 */
public class JdkProxy implements InvocationHandler {
    private Object target;
    public JdkProxy(Object tt){
        target =tt;
    }

    public <T> T getProxy(){
    return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target,args);
        after();
        return result;
    }
    private void before(){
        System.out.println("before");
    }
    private void after(){
        System.out.println("after");
    }
}
