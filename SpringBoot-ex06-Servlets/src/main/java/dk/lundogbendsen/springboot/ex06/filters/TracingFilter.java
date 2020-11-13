package dk.lundogbendsen.springboot.ex06.filters;

import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

public class TracingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MDC.put("traceId", UUID.randomUUID().toString());
        filterChain.doFilter(servletRequest,servletResponse);
        MDC.remove("traceId");
    }
}
