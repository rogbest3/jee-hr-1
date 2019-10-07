package com.hr.web.serviceimpls;

import java.util.List;

import com.hr.web.daoimpls.HrDaoImpl;
import com.hr.web.domains.HrBean;
import com.hr.web.services.HrService;

public class HrServiceImpl implements HrService{
	private static HrServiceImpl instance = new HrServiceImpl();
	public static HrServiceImpl getInstance() {return instance;}
	private HrServiceImpl() {}

	public void join(HrBean param) {
		System.out.println("joinService=");
		HrDaoImpl.getInstance().insertJoin(param);
	}
	
	public HrBean login(HrBean param) {
		return HrDaoImpl.getInstance().selectLogin(param);
	}

	public List<String> viewMypage() {
		return HrDaoImpl.getInstance().searchMypage();
	}
	

}
