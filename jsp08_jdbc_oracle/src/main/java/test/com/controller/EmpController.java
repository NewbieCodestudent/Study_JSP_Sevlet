package test.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import test.com.model.EmpDAO;
import test.com.model.EmpDAOimpl;
import test.com.model.EmpVO;

/**
 * Servlet implementation class EmpController
 */
@WebServlet({"/selectAll.do","/insert.do","/insertOK.do","/json_dept_id.do","/json_job_id.do", "/selectAll_join.do"})
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpDAO dao = new EmpDAOimpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet....");
		String sPath = request.getServletPath();
		System.out.println(sPath);
		
		if(sPath.equals("/selectAll.do")) {
			
			List<EmpVO> vos = dao.selectAll();
			System.out.println("vos.size():"+vos.size());
			
			request.setAttribute("vos", vos);
			
			request.getRequestDispatcher("emp/selectAll.jsp")
								.forward(request, response);
		}else if(sPath.equals("/selectAll_view.do")) {
			
			List<EmpVO> vos = dao.selectAll_view();
			System.out.println("vos.size():"+vos.size());
			
			request.setAttribute("vos", vos);
			
			request.getRequestDispatcher("emp/selectAll_view.jsp").forward(request, response);
		}else if(sPath.equals("/selectAll_join.do")) {
			
			List<EmpVO> vos = dao.selectAll_join();
			System.out.println("vos.size():"+vos.size());
			
			request.setAttribute("vos", vos);
			
			request.getRequestDispatcher("emp/selectAll_join.jsp").forward(request, response);
		}else if(sPath.equals("/insert.do")) {
			request.getRequestDispatcher("emp/insert.jsp").forward(request, response);
		}else if(sPath.equals("/json_dept_id.do")) {
			
			List<Integer> dept_ids = dao.selectDeptID();
			System.out.println(dept_ids);
			
			PrintWriter out = response.getWriter();
			out.print(dept_ids.toString());

		}else if(sPath.equals("/json_job_id.do")) {
			
			List<String> job_ids = dao.selectJobID();
			System.out.println(job_ids);
//			String txt = "[";
//			for (int i=0;i<job_ids.size();i++) {
//				txt += "\""+job_ids.get(i)+"\"";
//				if(i<job_ids.size()-1)txt += ",";
//			}
//			txt += "]";
			//simple-json.jar 라이브러리사용
			JSONArray arr = new JSONArray();
			arr.addAll(job_ids);
			PrintWriter out = response.getWriter();
			out.print(arr);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		
		if(sPath.equals("/insertOK.do")) {
			new InsertOKAction().execute(request, response);
		}
		
	}

}
