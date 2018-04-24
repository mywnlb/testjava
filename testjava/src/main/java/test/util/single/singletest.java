package test.util.single;

/**
 * Created by lb on 2018/3/30.
 */
public class singletest {
    public static void mypring(){
        System.out.println("---------------懒汉式单例-----");
        System.out.println("第一次取得实例");
        MySingle s1 = MySingle.getMySingle();
        System.out.println("第二次取得实例");
        MySingle s2 = MySingle.getMySingle();
        if(s1 == s2){
            System.out.println("s1和s2为同一实例");
        }
    }
    public static void mypring1(){
        System.out.println("----------饿汉试----------");
        System.out.println("第一次获取实例");
        MySingle1 mySingle1 = MySingle1.getMySingle1();
        System.out.println("第二次获取实例");
        MySingle1 mySingle11 = MySingle1.getMySingle1();
        if(mySingle1 == mySingle11){
            System.out.println("两者相同");
        }

    }
    public static void main(String[] args) {
        //mypring();
        mypring1();
    }
}
