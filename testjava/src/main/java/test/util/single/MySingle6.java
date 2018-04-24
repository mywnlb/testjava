package test.util.single;

/**
 * Created by lb on 2018/4/3.
 */
public class MySingle6 {
    private volatile static MySingle6 mySingle6 =null;
    private MySingle6(){}
    public static MySingle6 getMySingle6(){
        if(mySingle6 == null){
            synchronized (MySingle6.class){
                if(mySingle6 == null){
                    mySingle6 = new MySingle6();
                }
            }
        }
        return mySingle6;
    }
}
