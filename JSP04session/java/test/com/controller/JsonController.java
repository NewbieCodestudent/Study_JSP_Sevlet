package test.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/json_idCheck.do" })
public class JsonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsonController() {
        super();
        System.out.println("JsonController");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("sPath : " + sPath);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String sPath = request.getServletPath();
		System.out.println("doPost()...");
		System.out.println("sPath : " + sPath);
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
