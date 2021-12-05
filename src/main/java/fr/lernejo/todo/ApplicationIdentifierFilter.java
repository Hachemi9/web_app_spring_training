package fr.lernejo.todo;

import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class ApplicationIdentifierFilter implements javax.servlet.Filter{
    String id;
    public ApplicationIdentifierFilter() {
        UUID uuid = UUID. randomUUID();
        id=uuid.toString();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = ((HttpServletResponse) servletResponse);
        httpServletResponse.setHeader("Instance-Id", id);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
