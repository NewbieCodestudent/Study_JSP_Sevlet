package test.com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONArray;

import test.com.student.model.StDAO;
import test.com.student.model.StDAOimpl;
import test.com.student.model.StVO;

/**
 * Servlet implementation class StudentController
 */
@WebServlet({ "/s_insert.do", "/s_img_insertOK.do", "/s_insertOK.do", "/s_selectAll.do", "/json_dept_id.do",
		"/json_major_id.do" })
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StDAO dao = new StDAOimpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentController() {
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

		if (sPath.equals("/s_selectAll.do")) {

			List<StVO> vos = dao.selectAll();
			System.out.println("vos.size():" + vos.size());

			request.setAttribute("vos", vos);

			request.getRequestDispatcher("student/selectAll.jsp").forward(request, response);
		} else if (sPath.equals("/s_insert.do")) {

			request.getRequestDispatcher("student/insert.jsp").forward(request, response);
		}  else if (sPath.equals("/json_dept_id.do")) {

			List<Integer> ids = dao.json_dept_id();
			System.out.println(ids);

			PrintWriter out = response.getWriter();
			out.print(ids.toString());
//			out.print("[10,20,30]");
		} else if (sPath.equals("/json_major_id.do")) {

			List<String> ids = dao.json_major_id();
			System.out.println(ids);

			// simple-json.jar 라이브러리사용
			JSONArray arr = new JSONArray();
			arr.addAll(ids);
			PrintWriter out = response.getWriter();
			out.print(arr);
//			out.print("[\"SOFT_DEV\",\"SOFT_WEB\",\"ST_SAL\"]");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String sPath = request.getServletPath();
		System.out.println(sPath);
		if (sPath.equals("/s_img_insertOK.do")) {
			String dir_path = request.getServletContext().getRealPath("/uploadimg");
			System.out.println(dir_path);

			int fileSizeMax = 1024 * 1024 * 100;

			boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);

			if (isMultipartContent) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(fileSizeMax);

				ServletFileUpload sfu = new ServletFileUpload(factory);
				sfu.setFileSizeMax(fileSizeMax);// 파일 사이즈 제한

				String st_name = "";
				String score = "";
				String major_id = "";
				String dept_id = "";
				String img_name = "";

				try {
					List<FileItem> items = sfu.parseRequest(request);
					for (FileItem item : items) {
						if (item.isFormField()) { // st_name,,,, 받기
							if (item.getFieldName().equals("st_name")) {
								st_name = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("score")) {
								score = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("major_id")) {
								major_id = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("dept_id")) {
								dept_id = item.getString("UTF-8");
							}

						} else { // file정보받기.
							img_name = FilenameUtils.getName(item.getName());

							File saveFile = new File(dir_path, img_name);

							try {
								item.write(saveFile);
							} catch (Exception e) {
								e.printStackTrace();
							}

						} // end else

					} // end for << items
				} catch (FileUploadException e) {
					e.printStackTrace();
				}

				System.out.println(st_name);
				System.out.println(score);
				System.out.println(major_id);
				System.out.println(dept_id);
				System.out.println(img_name);

				StVO vo = new StVO();
				vo.setSt_name(st_name);
				vo.setScore(Integer.parseInt(score));
				vo.setMajor_id(major_id);
				vo.setDept_id(Integer.parseInt(dept_id));
				vo.setImg_name(img_name);

				int result = dao.insert(vo);
				if (result == 1)
					response.sendRedirect("s_selectAll.do");
				else
					response.sendRedirect("s_insert.do");

			} // end if << isMultilpart
		}else if (sPath.equals("/s_insertOK.do")) {

			String st_name = request.getParameter("st_name");
			String score = request.getParameter("score");
			String major_id = request.getParameter("major_id");
			String dept_id = request.getParameter("dept_id");

			System.out.println(st_name);
			System.out.println(score);
			System.out.println(major_id);
			System.out.println(dept_id);

			StVO vo = new StVO();
			vo.setSt_name(st_name);
			vo.setScore(Integer.parseInt(score));
			vo.setMajor_id(major_id);
			vo.setDept_id(Integer.parseInt(dept_id));

			int result = dao.insert(vo);
			if (result == 1)
				response.sendRedirect("s_selectAll.do");
			else
				response.sendRedirect("s_insert.do");
		}

		
	}

}
