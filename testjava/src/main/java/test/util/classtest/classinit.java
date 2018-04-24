package test.util.classtest;

/**
 * Created by lb on 2018/4/23.
 */
public class classinit {
    public static void main(String[] args) {
        Byte[] b = new Byte[]{48,48,48,49};
        String a = ""+b;
        System.out.println(a);
        constclass aaa = new constclass();
        System.out.println(aaa);
        System.out.println(a.getClass());
    }
}
class constclass{
    static {
        System.out.println("111");
    }
    public static final String HELLOWORLD = "hello world";
}
