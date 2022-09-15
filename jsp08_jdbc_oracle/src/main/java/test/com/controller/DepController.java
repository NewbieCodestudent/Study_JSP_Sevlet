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

import test.com.d_model.DepDAO;
import test.com.d_model.DepDAOimpl;
import test.com.d_model.DepVO;

/**
 * Servlet implementation class EmpController
 */
@WebServlet({"/d_selectAll.do","/d_insert.do","/d_insertOK.do", "/json_mana_id.do", "/json_loc_id.do", "/d_delete.do", "/d_deleteOK.do"})
public class DepController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepDAO dao = new DepDAOimpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepController() {
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
		
		if(sPath.equals("/d_selectAll.do")) {
			List<DepVO> vos = dao.selectAll();
			System.out.println("vos.size():"+vos.size());
			request.setAttribute("vos", vos);
			request.getRequestDispatcher("dep/selectAll.jsp").forward(request, response);
		}else if(sPath.equals("/d_insert.do")) {
			request.getRequestDispatcher("dep/insert.jsp").forward(request, response);
		}else if(sPath.equals("/json_mana_id.do")) {
			List<Integer> mana_ids = dao.selectManagerID();
			System.out.println(mana_ids);
			JSONArray arr = new JSONArray();
			arr.addAll(mana_ids);
			PrintWriter out = response.getWriter();
			out.print(arr);
		}else if(sPath.equals("/json_loc_id.do")) {
			List<Integer> loc_ids = dao.selectLocationID();
			System.out.println(loc_ids);
			JSONArray arr = new JSONArray();
			arr.addAll(loc_ids);
			PrintWriter out = response.getWriter();
			out.print(arr);
		}else if(sPath.equals("/d_delete.do")) {
			request.getRequestDispatcher("dep/delete.jsp").forward(request, response);
		}else if(sPath.equals("/d_deleteOK.do")) {
			
			DepDAO dao = new DepDAOimpl();
			DepVO vo = new DepVO();
			vo.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));
			
			int result = dao.delete(vo);
			
			System.out.println("result : " + result);
			
			if(result==1) response.sendRedirect("d_selectAll.do");
			else response.sendRedirect("d_delete.do");
		} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		
		if(sPath.equals("/d_insertOK.do")) {
			new d_InsertOKAction().execute(request, response);
		}
		
	}

}
