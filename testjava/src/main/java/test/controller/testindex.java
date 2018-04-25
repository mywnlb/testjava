package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lb on 2018/2/8.
 */
@Controller
@RequestMapping("/admin")
public class testindex {

    @RequestMapping("/index")
    public String index() throws Exception{
        return  "/view/index";
    }

    @RequestMapping("/testftl")
    public ModelAndView testftl(String id) throws SQLException {



        ModelAndView mav  = new ModelAndView();
        mav.setViewName( "/view/index");
        mav.addObject("name","this is a test ftl");
        return mav;
    }

    @RequestMapping("/throexce")
    @ResponseBody
    public Map<String,String> throexce(Integer a,String bbb) {
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("1","22222");
        map.put(a+"",bbb);
        return map;
    }
    @RequestMapping("/testjson")
    @ResponseBody
    public Map<String,String> testjson() throws SQLException {
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("1","22222");
        return map;
    }

}
