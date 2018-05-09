package test.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by lb on 2018/5/4.
 */
public class BeanLifeTest implements DisposableBean ,InitializingBean{
    public void destroybean(){
        System.out.println("this is a bean destory info -----------------------");
    }
    public void init(){
        System.out.println("this is a bean init info  -----------------------");
    }
    public BeanLifeTest(){
        System.out.println("this is a bean initialization-------------------");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("this is a bean destory from DisposableBean info -----------------------");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("thisi is a implements InitalizingBean info");
    }
}
