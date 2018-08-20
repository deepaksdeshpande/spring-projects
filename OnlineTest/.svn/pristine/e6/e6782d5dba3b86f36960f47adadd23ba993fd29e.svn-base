/**
 * 
 */
package org.iitb.exam.main.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author deepak
 *
 */
public class SessionValidityInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 
	 */
	public SessionValidityInterceptor() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession(false);

		if (session == null) {
			response.sendRedirect("sessionexpired.htm");
			return false;
		} 
		else {
			return true;
		}
	}

}
