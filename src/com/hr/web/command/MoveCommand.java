package com.hr.web.command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	public MoveCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(action);
		setDomain(domain);
		execute();
	}
	
	public void execute() {
		setPage(request.getParameter("page"));
		super.execute();
		
	}
}
