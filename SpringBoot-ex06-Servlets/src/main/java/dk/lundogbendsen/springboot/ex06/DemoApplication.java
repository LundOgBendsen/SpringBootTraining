package dk.lundogbendsen.springboot.ex06;

import dk.lundogbendsen.springboot.ex06.filters.TracingFilter;
import dk.lundogbendsen.springboot.ex06.servlets.HelloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean bean = new ServletRegistrationBean(
				new HelloServlet(), "/servlet");
		return bean;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean(new TracingFilter());
		//map to path /*, i.e. all requests
//		bean.addServletNames("helloServlet");
		return bean;
	}
}
