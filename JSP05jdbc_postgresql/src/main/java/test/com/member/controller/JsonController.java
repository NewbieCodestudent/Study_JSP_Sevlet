package test.com.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexController
 */

@WebServlet({ "/json_idCheck.do" })
public class JsonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonController() {
        super();
        System.out.println("JsonController");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sPath = request.getServletPath();
		System.out.println("sPath : " + sPath);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String sPath = request.getServletPath();
		System.out.println("doPost()...");
		System.out.println("sPath : " + sPath);
		if (sPath.equals("/json_idCheck.do")) {
			System.out.println(request.getParameter("id"));
			boolean result = true;
			result = false;
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Credentials", "true");
			
			PrintWriter out = response.getWriter();
			if(result) {
				out.print("{\"result\" : \"Not Ok\"}");
			}else {
				out.print("{\"result\" : \"Ok\"}");
			};			
		} 
	}

}
