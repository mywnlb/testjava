package springlife;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.entity.BeanLifeTest;
import test.entity.SpringLifeBean;

/**
 * Created by lb on 2018/5/7.
 */
public class SpringlIfe {
    @Test
    public void testBenaLife(){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-test.xml");
        BeanLifeTest beanLifeTest = (BeanLifeTest) context.getBean("beanLifeTest");
        System.out.println(beanLifeTest);
        context.close();
    }

    @Test
    public void testAnnotion(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-test.xml");
        SpringLifeBean springLifeBean = (SpringLifeBean)classPathXmlApplicationContext.getBean("annolife");
        classPathXmlApplicationContext.destroy();
    }
}
