package dk.lundogbendsen.springboot.ex.springbootex12autoconftimerfilters.filter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
@ConfigurationProperties(prefix = "filters")
public class FiltersAutoConfiguration {

    private boolean enableTimingFilter;

    @Bean
    @ConditionalOnProperty(prefix = "filters", name = "enable-timing-filter", havingValue = "true")
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<TimingFilter> bean = new FilterRegistrationBean<>(new TimingFilter());
        bean.setUrlPatterns(Collections.singletonList("/*"));
        return bean;
    }

    public boolean isEnableTimingFilter() {
        return enableTimingFilter;
    }

    public void setEnableTimingFilter(boolean enableTimingFilter) {
        this.enableTimingFilter = enableTimingFilter;
    }
}
