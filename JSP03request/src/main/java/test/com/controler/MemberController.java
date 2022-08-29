package test.com.controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.MemberVO;

/**
 * Servlet implementation class MemberController
 */
@WebServlet({"/m_update.do", "/m_updateOK.do", "/m_insertOK.do" , "/m_insert.do", "/m_delete.do", "/m_deleteOK.do" , "/m_selectAll.do", "/m_selectOne.do", "/m_searchList.do", "/joinOK.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        System.out.println("MemberController");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sPath = request.getServletPath();
		System.out.println("doGet()...");
		System.out.println("sPath : " + sPath);
		
		if (sPath.equals("/index.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);	
		} else if (sPath.equals("/m_insert.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("member/insert.jsp");
			rd.forward(request, response);	
		} else if (sPath.equals("/m_update.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("member/update.jsp");
			rd.forward(request, response);	
		} else if (sPath.equals("/m_delete.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("member/delete.jsp");
			rd.forward(request, response);	
		} else if (sPath.equals("/m_selectAll.do")) {
//			request.setAttribute("user_name", "yangssem");  // 다음 web으로 정보를 넘겨주기 위해 request를 이용해서 념겨준다.
//			MemberVO vo2 = new MemberVO();  // 값을 입력하여 이 값을 selectAll.jsp파일 15~21번 줄 코딩으로 가져가서 쓸수있다.
//			vo2.setNum(11);
//			vo2.setId("admind11");
//			vo2.setPw("hi1234");
//			vo2.setName("kim11");
//			vo2.setTel("010");
//			request.setAttribute("vo2", vo2);  // 다음 web으로 정보를 넘겨주기 위해 request를 이용해서 념겨준다.
			
			List<MemberVO> vos = new ArrayList<MemberVO>();
			for (int i = 0; i < 10; i++) {
				MemberVO vo = new MemberVO();
				vo.setNum(i+1);
				vo.setId("admin" + (i+1));
				vo.setPw("hi000" + (i+1));
				vo.setName("lee" + (i+1));
				vo.setTel("00" + (i+1));
				vos.add(vo);
			}
			request.setAttribute("vos", vos);
			
			RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
			rd.forward(request, response);	
		} else if (sPath.equals("/m_selectOne.do")) {
			
			List<MemberVO> vos = new ArrayList<MemberVO>();
			for (int i = 0; i < 10; i++) {
				MemberVO vo = new MemberVO();
				vo.setNum(i+1);
				vo.setId("admin" + (i+1));
				vo.setPw("hi000" + (i+1));
				vo.setName("lee" + (i+1));
				vo.setTel("00" + (i+1));
				vos.add(vo);
			}
			request.setAttribute("vos", vos);
			
			RequestDispatcher rd = request.getRequestDispatcher("member/selectOne.jsp");
			rd.forward(request, response);	
		} else if (sPath.equals("/m_searchList.do")) {
			System.out.println("searchKey : " + request.getParameter("searchKey") +
							   " searchWord : " + request.getParameter("searchWord"));
			
			List<MemberVO> vos = new ArrayList<MemberVO>();
			for (int i = 0; i < 10; i+=2) {
				MemberVO vo = new MemberVO();
				vo.setNum(i+1);
				vo.setId("admin" + (i+1));
				vo.setPw("hi000" + (i+1));
				vo.setName("lee" + (i+1));
				vo.setTel("00" + (i+1));
				vos.add(vo);
			}
			request.setAttribute("vos", vos);
			
			RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
			rd.forward(request, response);	
		} else if (sPath.equals("/m_insertOK.do")) {
			response.sendRedirect("m_insertAll.do");
		} else if (sPath.equals("/m_updateOK.do")) {
			System.out.println(request.getParameter("num"));
			
			List<MemberVO> vos = new ArrayList<MemberVO>();
			for (int i = 0; i < 10; i++) {
				MemberVO vo = new MemberVO();
				vo.setNum(i+1);
				vo.setId("admin" + (i+1));
				vo.setPw("hi000" + (i+1));
				vo.setName("lee" + (i+1));
				vo.setTel("00" + (i+1));
				vos.add(vo);
			}
			request.setAttribute("vos", vos);
			
			response.sendRedirect("m_selectOne.do");
		} else if (sPath.equals("/m_deleteOK.do")) {
			System.out.println(request.getParameter("num"));
			response.sendRedirect("m_selectAll.do");
		}
		
		//else if (sPath.equals("/m_insertOK.do")) { // 제출을 통한 이동은 요청이 아니라 응답이기 때문에 response로 해야한다.
		//	System.out.println("ID:" + request.getParameter("id")+" PW:"+request.getParameter("pw")+" NAME:"+request.getParameter("name")+" TEL:"+request.getParameter("tel"));
		//  response.sendRedirect("m_selectAll.do"); // 회원가입을 하면 위에 클릭으로 올라가 m_selectAll이 클릭한 것으로 인식한다. 	
		//}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Post에서 Get으로 넘어가기 전 한글이 깨지는 것을 막는 코딩
		request.setCharacterEncoding("UTF-8");
//		doGet(request, response);
		String sPath = request.getServletPath();
		System.out.println("doPost()...");
		System.out.println("sPath : " + sPath);
		if (sPath.equals("/m_insertOK.do")) { // 제출을 통한 이동은 요청이 아니라 응답이기 때문에 response로 해야한다.
			System.out.println("ID:" + request.getParameter("id")+" PW:"+request.getParameter("pw")+" NAME:"+request.getParameter("name")+" TEL:"+request.getParameter("tel"));
			response.sendRedirect("m_selectAll.do"); // 회원가입을 하면 위에 클릭으로 올라가 m_selectAll이 클릭한 것으로 인식한다. 	
		} else if (sPath.equals("/m_updateOK.do")) {
			System.out.println("NUM:" + request.getParameter("num")+ "ID:" + request.getParameter("id")+" PW:"+request.getParameter("pw")+" NAME:"+request.getParameter("name")+" TEL:"+request.getParameter("tel"));
			response.sendRedirect("m_selectOne.do?num=" + request.getParameter("num")); 	
		} else if (sPath.equals("/joinOK.do")) {
			System.out.println("ID:" + request.getParameter("id")+" PW:"+request.getParameter("pw")+" NAME:"+request.getParameter("name")+" TEL:"+request.getParameter("tel"));
			response.sendRedirect("index.do"); 	
		}
	}

}
