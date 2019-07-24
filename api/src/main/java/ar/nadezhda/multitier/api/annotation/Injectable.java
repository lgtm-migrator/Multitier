package ar.nadezhda.multitier.api.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Bean;

@Bean
@Documented
@Retention(RUNTIME)
@Target({ANNOTATION_TYPE, METHOD})
public @interface Injectable {
}
