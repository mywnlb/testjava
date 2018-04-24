package aop;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by lb on 2018/3/2.
 */
public class Test01 {
    @Test
    public void testInstall()throws IOException{
    Greeting get = new JdkProxy(new GreetingImpl()).getProxy();
    get.sayHello("ccccc");
    }

}
