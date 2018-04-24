package aop;

/**
 * Created by lb on 2018/3/26.
 */
public class GreetingImpl extends JdkProxyVo implements Greeting {

    @Override
    public void sayHello(String name) {
        System.out.println("aaaaa"+name);
    }

}
