package test.util.annotation;

import org.junit.Test;

import java.util.List;

/**
 * Created by lb on 2018/5/8.
 */
public class AnnoTest {

    @SuppressWarnings({"unchecked","rawtypes"})
    public static void main(String[] args) {
        Parent c = new Child();
        List<SortableFiled> list= c.init();

    }
}
