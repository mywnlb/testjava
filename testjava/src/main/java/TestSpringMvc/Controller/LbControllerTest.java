package TestSpringMvc.Controller;

import TestSpringMvc.LbAnnot.LbAutired;
import TestSpringMvc.LbAnnot.LbController;
import TestSpringMvc.LbAnnot.LbRequestMapping;
import TestSpringMvc.Service.LbServiceTest;

/**
 * Created by lb on 2018/5/9.
 */
@LbController
@LbRequestMapping("/lbweb")
public class LbControllerTest {
    @LbAutired
    LbServiceTest lbServiceTest;

    @LbRequestMapping("/test.json")
    public void test(){
        System.out.println("this is a test springmvc");
    }
}
