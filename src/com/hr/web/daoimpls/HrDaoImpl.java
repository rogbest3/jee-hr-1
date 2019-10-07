package com.hr.web.daoimpls;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hr.web.daos.HrDao;
import com.hr.web.domains.HrBean;
import com.hr.web.factory.Database;
import com.hr.web.factory.DatabaseFactory;
import com.hr.web.pool.Constants;
import com.hr.web.serviceimpls.HrServiceImpl;

public class HrDaoImpl implements HrDao{
	private static HrDaoImpl instance = new HrDaoImpl();
	public static HrDaoImpl getInstance() {return instance;}
	private HrDaoImpl() {}

	public void insertJoin(HrBean param) {
		String sql = "INSERT INTO EMP (EMPNO, ENAME, JOB, DEPTNO, MGR, HIREDATE, SAL, COMM )\r\n" + 
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = DatabaseFactory.createDatabase(Constants.VENDOR)
					.getConnection()
					.prepareStatement(sql);
			System.out.println("======"+param.toString());
			stmt.setString(1, param.getEmpno());
			stmt.setString(2, param.getEname());
			stmt.setString(3, param.getJob());
			stmt.setString(4, param.getDeptno());
			stmt.setString(5, param.getMgr());
			stmt.setString(6, param.getHiredate());
			stmt.setString(7, param.getSal());
			stmt.setString(8, param.getComm());
			System.out.println(sql+"++++++++++++");
			ResultSet rs = stmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HrBean selectLogin(HrBean param) {
		System.out.println("========= 1 ============");
		
		HrBean hr = null;
		
			String sql = "SELECT D.DNAME , E.EMPNO, E.ENAME, E.JOB, E.MGR, "
					+ " E.HIREDATE, E.SAL, E.COMM, E.DEPTNO "
					+ " FROM EMP E JOIN DEPT D ON E.DEPTNO LIKE D.DEPTNO WHERE E.EMPNO LIKE ? AND E.ENAME LIKE ? AND D.DNAME LIKE ? ";
			System.out.println("========= 2 ============"+ sql);
			try {
				PreparedStatement stmt = DatabaseFactory.createDatabase(Constants.VENDOR)
						.getConnection()
						.prepareStatement(sql);
				stmt.setString(1, param.getEmpno());
				stmt.setString(2, param.getEname());
				stmt.setString(3, param.getDname());
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					hr = new HrBean();
					System.out.println("======= 3 ======== ");
					hr.setDname(rs.getString("DNAME"));
					hr.setEmpno(rs.getString("EMPNO"));
					hr.setEname(rs.getString("ENAME"));
					hr.setDeptno(rs.getString("DEPTNO"));
					hr.setJob(rs.getString("JOB"));
					hr.setMgr(rs.getString("MGR"));
					hr.setHiredate(rs.getString("HIREDATE"));
					hr.setSal(rs.getString("SAL"));
					hr.setComm(rs.getString("COMM"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return hr;
	}
	
	public List<String> searchMypage() {
		return null;
	}


}
