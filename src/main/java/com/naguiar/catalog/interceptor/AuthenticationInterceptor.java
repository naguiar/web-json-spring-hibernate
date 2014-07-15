/**
 * 
 */
package com.naguiar.catalog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author naty
 * 
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String uri = request.getRequestURI();
		
		if (uri.endsWith("newLogin") || uri.endsWith("login") || uri.contains("resources") || uri.contains("_template")) {
			return true;
		}

		if (request.getSession().getAttribute("userLogged") != null) {
			return true;
		}

		response.sendRedirect("newLogin");
		
		return false;
	}
}
