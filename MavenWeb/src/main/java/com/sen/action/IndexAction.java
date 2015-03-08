package com.sen.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sen.service.ProductService;
import com.sen.util.PageBean;

public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductService ps;
	private int pagenow;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String execute() throws Exception {
		PageBean pb= ps.queryForPage(10, pagenow);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("pagebean", pb);
		return SUCCESS;
	}

	public int getPagenow() {
		return pagenow;
	}

	public void setPagenow(int pagenow) {
		this.pagenow = pagenow;
	}

	public ProductService getPs() {
		return ps;
	}

	public void setPs(ProductService ps) {
		this.ps = ps;
	}
	
}
