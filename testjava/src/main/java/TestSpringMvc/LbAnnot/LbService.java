package TestSpringMvc.LbAnnot;

import java.lang.annotation.*;

/**
 * Created by LB on 2018/5/13.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LbService {
    String value() default "";
}
