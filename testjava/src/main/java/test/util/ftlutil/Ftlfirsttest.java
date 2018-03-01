package test.util.ftlutil;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lb on 2018/3/1.   freemarker自定义指令测试
 */
@Component("ftlfirsttest")
public class Ftlfirsttest implements TemplateMethodModelEx{

    @Override
    public Object exec(List arguments) throws TemplateModelException {
        return "this is a instruction ftl"+arguments.get(0).toString();
    }
}
