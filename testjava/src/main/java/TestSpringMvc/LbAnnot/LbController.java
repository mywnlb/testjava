package TestSpringMvc.LbAnnot;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LbController {
    String value() default "";
}
