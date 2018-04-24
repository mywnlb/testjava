package test.util.single;

/**
 * Created by lb on 2018/4/2.
 */
public class MySingle3 {
    private static MySingle3 mySingle3 = null;
    private MySingle3(){}
    public static synchronized MySingle3 getMySingle3(){
        if(mySingle3 == null){
            mySingle3 = new MySingle3();
        }
        return mySingle3;
    }
}
