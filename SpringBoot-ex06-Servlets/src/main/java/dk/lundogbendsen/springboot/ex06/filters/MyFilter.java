package dk.lundogbendsen.springboot.ex06.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        System.out.println("Request received: " + req.getRequestURI());
        req.getParameterMap().forEach((n,v) -> System.out.println("\t" + n + "->" + pp(v)));
        filterChain.doFilter(servletRequest,servletResponse);
    }

    /**
     * Pretty Print an array of strings
     *
     * @param v an array of strings
     * @return a string with values separated by ,
     */
    private String pp(String[] v) {
        return Arrays.asList(v).stream().collect( Collectors.joining( ", " ) );

    }


}
