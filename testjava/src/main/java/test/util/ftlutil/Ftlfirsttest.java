package test.util.ftlutil;

import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by lb on 2018/3/1.   freemarker自定义指令测试
 */
@Component("ftlfirsttest")
public class Ftlfirsttest implements TemplateDirectiveModel{


    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {

        System.out.println(params);

    }
}
