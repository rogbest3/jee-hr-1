package com.hr.web.command;

import javax.servlet.http.HttpServletRequest;

import com.hr.web.domains.HrBean;
import com.hr.web.serviceimpls.HrServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(action);
		setDomain(domain);
		execute();
	}
	public void execute() {
		HrBean hr = new HrBean();
		hr.setEmpno(request.getParameter("empno"));
		hr.setEname(request.getParameter("ename"));
		hr.setDname(request.getParameter("dname"));

		request.setAttribute("facade", HrServiceImpl.getInstance().login(hr));
		setPage((hr!=null) ? request.getParameter("page"):"login");
		super.execute();
	}
}
