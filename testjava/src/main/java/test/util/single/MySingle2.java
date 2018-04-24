package test.util.single;

/**
 * Created by lb on 2018/3/30. 线程安全
 */
public class MySingle2 {
    private volatile static MySingle2 mySingle2 = null;
    private MySingle2(){}
    public static MySingle2 getSingle(){
        if(mySingle2 == null){
            synchronized (MySingle2.class){
                if(mySingle2 == null){
                    mySingle2 = new MySingle2();
                }
            }
        }
        return mySingle2;
    }
}








