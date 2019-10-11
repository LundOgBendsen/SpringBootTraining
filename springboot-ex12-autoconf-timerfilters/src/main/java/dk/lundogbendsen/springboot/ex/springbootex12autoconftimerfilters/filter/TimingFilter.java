package dk.lundogbendsen.springboot.ex.springbootex12autoconftimerfilters.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class TimingFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(TimingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long begin = System.currentTimeMillis();
        chain.doFilter(request, response);
        long end = System.currentTimeMillis();
        logger.debug("Time processing request {} ms", (end - begin));

    }
}
