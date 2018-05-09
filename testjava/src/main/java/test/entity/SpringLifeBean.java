package test.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by lb on 2018/5/7.
 */
public class SpringLifeBean {
    public SpringLifeBean() {
        System.out.println("this is a bean init info ----------------");
    }

    @PostConstruct
    public void init(){
        System.out.println("this is a init annotion methos");
    }

    @PreDestroy
    public void destory(){
        System.out.println("this is a destory annotion method");
    }
}
