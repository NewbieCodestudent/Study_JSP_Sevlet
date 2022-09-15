package test.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.department.departmentDAO;
import test.com.department.departmentDAOimpl;
import test.com.department.departmentVO;
import test.com.major.majorDAO;
import test.com.major.majorDAOimpl;
import test.com.major.majorVO;
import test.com.mission.missionDAO;
import test.com.mission.missionDAOimpl;
import test.com.mission.missionVO;
import test.com.student.studentDAO;
import test.com.student.studentDAOimpl;
import test.com.student.studentVO;

@WebServlet({"/selectAll_join.do","/selectAll_view.do","/major.do","/department.do","/student.do", "/json_major_id.do", "/json_dept_id.do", "/student_delete.do",
	"/student_deleteOK.do","/insert_majorOK.do", "/insert_studentOK.do", "/insert_departmentOK.do", "/insert_major.do", "/insert_student.do", "/insert_department.do"})
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MainController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet....");
		String sPath = request.getServletPath();
		System.out.println(sPath);
		
		if(sPath.equals("/selectAll_view.do")) {
			missionDAO dao = new missionDAOimpl();
			List<missionVO> vos = dao.selectAll_view();
			request.setAttribute("vos", vos);
			request.getRequestDispatcher("college/selectAll_view.jsp").forward(request, response);
		} else if(sPath.equals("/selectAll_join.do")) {
			missionDAO dao = new missionDAOimpl();
			List<missionVO> vos = dao.selectAll_join();
			request.setAttribute("vos", vos);
			request.getRequestDispatcher("college/selectAll_join.jsp").forward(request, response);
		} else if(sPath.equals("/major.do")) {
			majorDAO dao = new majorDAOimpl();
			List<majorVO> vos = dao.majorAll();
			System.out.println(vos);
			request.setAttribute("vos", vos);
			request.getRequestDispatcher("college/major.jsp").forward(request, response);
		} else if(sPath.equals("/department.do")) {
			departmentDAO dao = new departmentDAOimpl();
			List<departmentVO> vos = dao.departmentAll();
			System.out.println(vos);
			request.setAttribute("vos", vos);
			request.getRequestDispatcher("college/department.jsp").forward(request, response);
		} else if(sPath.equals("/student.do")) {
			studentDAO dao = new studentDAOimpl();
			List<studentVO> vos = dao.studentAll();
			System.out.println(vos);
			request.setAttribute("vos", vos);
			request.getRequestDispatcher("college/student.jsp").forward(request, response);
		} else if(sPath.equals("/insert_major.do")) {
			request.getRequestDispatcher("college/insert_major.jsp").forward(request, response);
		} else if(sPath.equals("/insert_department.do")) {
			request.getRequestDispatcher("college/insert_department.jsp").forward(request, response);
		} else if(sPath.equals("/insert_student.do")) {
			request.getRequestDispatcher("college/insert_student.jsp").forward(request, response);
		} else if(sPath.equals("/student_delete.do")) {
			request.getRequestDispatcher("college/student_delete.jsp").forward(request, response);
		} else if(sPath.equals("/student_deleteOK.do")) {
			String student_id = request.getParameter("student_id");
			System.out.println(student_id);
			
			studentDAO dao = new studentDAOimpl();

			studentVO vo = new studentVO();
			vo.setStudent_id(Integer.parseInt(student_id));
			
			int result = dao.delete(vo);
			if (result == 1)response.sendRedirect("student.do");
			else response.sendRedirect("student_delete.do?student_id=" + student_id);
		} else if(sPath.equals("/json_dept_id.do")) {
			studentDAO dao = new studentDAOimpl();
			List<Integer> dept_ids = dao.selectDeptID();
			System.out.println(dept_ids);
			
			PrintWriter out = response.getWriter();
			out.print(dept_ids.toString());

		} else if(sPath.equals("/json_major_id.do")) {
			studentDAO dao = new studentDAOimpl();
			List<Integer> major_ids = dao.selectMajorID();
			System.out.println(major_ids);
			
			PrintWriter out = response.getWriter();
			out.print(major_ids.toString());

		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		
		if(sPath.equals("/insert_majorOK.do")) {
			new Insert_majorOKAction().execute(request, response);
		} else if(sPath.equals("/insert_departmentOK.do")) {
			new Insert_departmentOKAction().execute(request, response);
		} else if(sPath.equals("/insert_studentOK.do")) {
			new Insert_studentOKAction().execute(request, response);
		}
		
	}

}
