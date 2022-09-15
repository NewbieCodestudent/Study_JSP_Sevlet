package test.com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.d_model.DepDAO;
import test.com.d_model.DepDAOimpl;
import test.com.d_model.DepVO;

public class d_InsertOKAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("d_insertOKAction");
		DepDAO dao = new DepDAOimpl();
		DepVO vo = new DepVO();
		
		vo.setDepartment_name(request.getParameter("department_name"));
		vo.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
		vo.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
		
		System.out.println(vo);
		
		int result = dao.insert(vo);
		System.out.println(result);
		
		if(result ==1) response.sendRedirect("d_selectAll.do");
		else response.sendRedirect("d_insert.do");
		
		
	}

}
