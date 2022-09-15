package test.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.dept.model.DeptDAO;
import test.com.dept.model.DeptDAOimpl;
import test.com.dept.model.DeptVO;

/**
 * Servlet implementation class DeptController
 */
@WebServlet({ "/d_insert.do",
	"/d_insertOK.do", "/d_selectAll.do", 
	"/json_st_id.do" })
public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptDAO dao = new DeptDAOimpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeptController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet....");
		String sPath = request.getServletPath();
		System.out.println(sPath);

		if (sPath.equals("/d_selectAll.do")) {

			List<DeptVO> vos = dao.selectAll();
			System.out.println("vos.size():" + vos.size());

			request.setAttribute("vos", vos);

			request.getRequestDispatcher("dept/selectAll.jsp").forward(request, response);
		} else if (sPath.equals("/d_insert.do")) {

			request.getRequestDispatcher("dept/insert.jsp").forward(request, response);
		} else if (sPath.equals("/d_insertOK.do")) {

			String dept_name = request.getParameter("dept_name");
			String mgr_id = request.getParameter("mgr_id");
			
			System.out.println(dept_name);
			System.out.println(mgr_id);
			
			DeptVO vo = new DeptVO();
			vo.setDept_name(dept_name);
			vo.setMgr_id(Integer.parseInt(mgr_id));

			int result = dao.insert(vo);
			if (result == 1)
				response.sendRedirect("d_selectAll.do");
			else
				response.sendRedirect("d_insert.do");
		} else if (sPath.equals("/json_st_id.do")) {

			List<Integer> ids = dao.json_st_id();
			System.out.println("ids.size():" + ids.size());
//			
			PrintWriter out = response.getWriter();
			out.print(ids.toString());
//			out.print("[100,101,102]");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("doPost....");
		doGet(request, response);
	}

}
