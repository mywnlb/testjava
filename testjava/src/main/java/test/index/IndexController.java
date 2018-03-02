package test.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lb on 2018/3/2.
 */

@Controller

public class IndexController {

    @RequestMapping(value = "/index")
    public String index() {

        return "/view/index1";

    }

}
