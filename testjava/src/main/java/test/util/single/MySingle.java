package test.util.single;

/**
 * Created by lb on 2018/3/30. 懒汉式 需要用到时才实例化对象，以时间换空间
 */
public class MySingle {
    private static MySingle mySingle = null;
    private MySingle(){
        System.out.println("-->懒汉式调用构造函数");
    }
    public static MySingle getMySingle(){
        System.out.println("-->懒汉式开始调用共有方法返回实例");
        if(mySingle == null){
            System.out.println("-->懒汉式没有创建");
            mySingle = new MySingle();
        }
        System.out.println("-->方法调用结束，返回单例");
        return mySingle;
    }
}
