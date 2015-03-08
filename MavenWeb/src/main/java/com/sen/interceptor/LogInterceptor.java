package com.sen.interceptor;

import java.util.Map;

import org.apache.struts2.dispatcher.ServletDispatcherResult;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LogInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("----------------begin---------------");
		System.out.println("Action:"+arg0.getAction().getClass().getName());
		System.out.println("Method:"+arg0.getProxy().getMethod());
		Map<String, Object> params = arg0.getInvocationContext().getParameters();
		for (String key:params.keySet()){
		    Object obj = params.get(key);
		    if(obj instanceof String[]){
		        String[] arr = (String[]) obj;
		        System.out.println("Param:"+key);
		        for (String value:arr){
		            System.out.println(value);
		        }
		    }
		}
		String theresult = arg0.invoke();
		Result result = arg0.getResult();
		if (result instanceof ServletDispatcherResult){
		    ServletDispatcherResult sdr = (ServletDispatcherResult) result;
		    System.out.println("JSP:"+sdr.getLastFinalLocation());
		}
		System.out.println("----------------end---------------");
		return theresult;
	}

}
