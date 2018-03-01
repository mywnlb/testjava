package test.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import test.util.ftlutil.Ftlfirsttest;
import test.util.spring.SpringUtils;

import java.util.*;

/**
 * Created by lb on 2018/2/8.
 */
@Controller
@RequestMapping("admin")
public class testindex {

    @RequestMapping("index")
    public String index() throws Exception{

        Ftlfirsttest ftlfirsttest = (Ftlfirsttest)SpringUtils.getBean("ftlfirsttest");
        String message = (String) ftlfirsttest.exec(Arrays.asList("2222222"));
        System.out.println(message);

        return  "/view/index";
    }

    @RequestMapping("testftl")
    public ModelAndView testftl(String id){
        ModelAndView mav  = new ModelAndView();
        mav.setViewName( "/view/index");
        mav.addObject("name","this is a test ftl");
        return mav;
    }

}
