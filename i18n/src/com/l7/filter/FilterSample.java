package com.l7.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/Login.jsp")
public class FilterSample implements Filter {

    public FilterSample() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// pass the request along the filter chain
		System.out.println("Entered Filter");
		chain.doFilter(request, response);
		System.out.println("Exited Filter");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
