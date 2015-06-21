package com.anurag.cors;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class CORSFilter extends HandlerInterceptorAdapter {
	
	

	public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex) throws IOException, ServletException {
		response.setHeader("Access-Control-Allow-Origin", "<origin> | *");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
	}


}