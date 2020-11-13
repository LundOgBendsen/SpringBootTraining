package dk.lundogbendsen.springboot.ex.springbootex15exceptionhandling;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringbootEx15ExceptionhandlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEx15ExceptionhandlingApplication.class, args);
    }

//    @Bean
//    public BasicErrorController basicErrorController(ErrorAttributes errorAttributes,
//                                                     ObjectProvider<ErrorViewResolver> errorViewResolvers) {
//        final ErrorProperties errorProperties = new ErrorProperties();
//        errorProperties.setIncludeMessage(ErrorProperties.IncludeAttribute.ALWAYS);
//        return new BasicErrorController(errorAttributes, errorProperties,
//                errorViewResolvers.orderedStream().collect(Collectors.toList()));
//    }
//
//

}
