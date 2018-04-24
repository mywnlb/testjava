package test.util.single;

/**
 * Created by lb on 2018/4/2.
 */
public class Mysingle4 {
    private static Mysingle4 mysingle4 = null;
    private Mysingle4(){}
    public static Mysingle4 getMysingle4(){
        if(mysingle4 == null){
            synchronized (Mysingle4.class){
                mysingle4 = new Mysingle4();
            }
        }
        return mysingle4;
    }
}
