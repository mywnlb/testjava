package test.util.annotation;

/**
 * Created by lb on 2018/5/8.
 */
public class Anno {
    @FiledMeta(name = "this is a test annotion")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
