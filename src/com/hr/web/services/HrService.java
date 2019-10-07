package com.hr.web.services;

import java.util.List;

import com.hr.web.domains.HrBean;

public interface HrService {
	public void join(HrBean param);
	public HrBean login(HrBean param);
	public List<String> viewMypage();
}
