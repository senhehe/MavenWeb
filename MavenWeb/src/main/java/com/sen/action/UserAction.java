package com.sen.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sen.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<com.sen.vo.User>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService us;
	com.sen.vo.User user = new com.sen.vo.User();
	
	public String reg() {
		String result = SUCCESS;
		try {
			us.addUser(user);
		} catch (Exception e) {
			result = ERROR;
			e.printStackTrace();
		}
		return result;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String login() {
		String result = SUCCESS;
		try {
			int type = us.queryUserByUP(user.getUsername(), user.getPassword());
			if(type == 0) {
				result=ERROR;
			}else {
				Map session = ActionContext.getContext().getSession();
				session.put("username", user.getUsername());
				session.put("type", type);
			}
		} catch (Exception e) {
			result=ERROR;
			e.printStackTrace();
		}
        return result;
	}
	
	@SuppressWarnings("rawtypes")
	public String loginout() {
		Map session = ActionContext.getContext().getSession();
		session.remove("username");
		session.remove("type");
		if(session.get("cart")!=null) {
			session.remove("cart");
		}
		return SUCCESS;
	}

	public com.sen.vo.User getModel() {
		return user;
	}

	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

}
