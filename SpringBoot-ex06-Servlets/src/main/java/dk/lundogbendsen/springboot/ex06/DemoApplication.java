package dk.lundogbendsen.springboot.ex06;

import dk.lundogbendsen.springboot.ex06.filters.MyFilter;
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
		FilterRegistrationBean bean = new FilterRegistrationBean(new MyFilter());
		//map to path /*, i.e. all requests
		bean.setUrlPatterns(Arrays.asList("/*"));


		/*
		// Mapping filter to a Servlet
		bean.addServletRegistrationBeans(new ServletRegistrationBean[] {
				servletRegistrationBean()
		});

		 */
		return bean;
	}
}
