package it.itsvita.byte19.ufc9.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import it.itsvita.byte19.ufc9.utils.Utils;

@WebFilter(filterName = "RequestParameterFilter", urlPatterns = {"/*"})
public class RequestParameterFilter implements Filter {
    ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        context.log(httpRequest.getRemoteAddr() + "::Username::{" + httpRequest.getParameter(Utils.PARAM_USERNAME) + "}");
        context.log(httpRequest.getRemoteAddr() + "::Value::{" + httpRequest.getParameter("value") + "}");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}