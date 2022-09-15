package test.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.major.model.MajorDAO;
import test.com.major.model.MajorDAOimpl;
import test.com.major.model.MajorVO;

/**
 * Servlet implementation class DeptController
 */
@WebServlet({ "/m_insert.do",
	"/m_insertOK.do","/m_selectAll.do" })
public class MajorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MajorDAO dao = new MajorDAOimpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajorController() {
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
		
		if(sPath.equals("/m_selectAll.do")) {
			
			List<MajorVO> vos = dao.selectAll();
			System.out.println("vos.size():"+vos.size());
			
			request.setAttribute("vos", vos);
			
			request.getRequestDispatcher("major/selectAll.jsp")
								.forward(request, response);
		}else if(sPath.equals("/m_insert.do")) {
			
			request.getRequestDispatcher("major/insert.jsp")
								.forward(request, response);
		}else if(sPath.equals("/m_insertOK.do")) {
			
			String major_id = request.getParameter("major_id");
			String major_title = request.getParameter("major_title");
			String min_score = request.getParameter("min_score");
			String max_score = request.getParameter("max_score");
			
			System.out.println(major_id);
			System.out.println(major_title);
			System.out.println(min_score);
			System.out.println(max_score);
			
			MajorVO vo = new MajorVO();
			vo.setMajor_id(major_id);
			vo.setMajor_title(major_title);
			vo.setMin_score(Integer.parseInt(min_score));
			vo.setMax_score(Integer.parseInt(max_score));
			
			int result = dao.insert(vo);	
			if(result==1)
				response.sendRedirect("m_selectAll.do");
			else 
				response.sendRedirect("m_insert.do");
		}else if(sPath.equals("/json_st_id.do")) {
			
//			List<Integer> dept_ids = dao.json_mgr_id();
//			System.out.println(dept_ids);
			
			PrintWriter out = response.getWriter();
//			out.print(dept_ids.toString());
			out.print("[100,120,230]");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
