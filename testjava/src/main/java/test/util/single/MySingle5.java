package test.util.single;

/**
 * Created by lb on 2018/4/2.
 */
public class MySingle5 {
    private static  MySingle5 mySingle5 = null;
    private MySingle5(){}
    public static MySingle5 getMySingle5(){
        if(mySingle5 == null){
            synchronized (MySingle5.class){
                if(mySingle5 == null){
                    mySingle5 = new MySingle5();
                }
            }
        }
        return mySingle5;
    }
}
