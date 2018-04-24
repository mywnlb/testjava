package test.util.Spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Created by lb on 2018/3/1.
 */
@Component("springUtils")
@Lazy(false)
public final class SpringUtils implements ApplicationContextAware,DisposableBean{

    private static  ApplicationContext applicationContext;

    private SpringUtils(){}



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){return applicationContext;}

    public static Object getBean(String name){
        Assert.hasText(name);
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(String name,Class<T> type){
        Assert.hasText(name);
        Assert.notNull(type);
        return applicationContext.getBean(name,type);
    }

    @Override
    public void destroy() throws Exception {
        applicationContext = null;
        System.out.println("-------------------web环境被销毁-------------------------------------------");
    }
}
