package com.sen.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void destroy() {
		
	}

	public void init() {
		
	}

	public String intercept(ActionInvocation actioninvocation) throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String un = (String) session.get("username");
		if(un==null) {
			return "login";
		}else {
			actioninvocation.invoke();
		}
		return null;
	}

}
