package test.util.single;

/**
 * Created by lb on 2018/3/30.饿汉试单例模式
 */
public class MySingle1 {
    private static MySingle1 mySingle1 = new MySingle1();
    private MySingle1(){
        System.out.println("饿汉试单例模式开始调用构造模式");
    }
    public static MySingle1 getMySingle1(){
        System.out.println("饿汉试公共方法返回实例");
        return  mySingle1;
    }
}
