package TestSpringMvc.LbAnnot;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LbRequestMapping {
    String value() default "";
}
