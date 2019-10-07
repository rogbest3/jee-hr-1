package com.hr.web.daos;

import java.util.List;

import com.hr.web.domains.HrBean;

public interface HrDao {
	public void insertJoin(HrBean param);
	public HrBean selectLogin(HrBean param);
	public List<String> searchMypage();
}
