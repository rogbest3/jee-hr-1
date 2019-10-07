package com.hr.web.command;

import javax.servlet.http.HttpServletRequest;

import com.hr.web.serviceimpls.HrServiceImpl;

public class SearchCommand extends Command{
	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(action);
		setDomain(domain);
		execute();
	}
	
	public void execute() {
		HrServiceImpl.getInstance().viewMypage();
		super.execute();
	}
}
