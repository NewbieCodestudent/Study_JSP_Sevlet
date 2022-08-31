package test.com.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import test.com.member.model.MemberDAO;
import test.com.member.model.MemberDAOimpl;
import test.com.member.model.MemberVO;

public class InsertOKAction {
	
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String id = null;
		String pw = null;
		String name = null;
		String tel = null;
		String profile = null;
		
		String dir_path = request.getServletContext().getRealPath("/upload");
		System.out.println(dir_path);
		
		int fileSizeMax = 1024 * 1024 * 100;

		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);

		if(isMultipartContent) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(fileSizeMax);
			
			ServletFileUpload sfu = new ServletFileUpload(factory);
			sfu.setFileSizeMax(fileSizeMax);//파일 사이즈 제한
			
			try {
				List<FileItem> items = sfu.parseRequest(request);
				for (FileItem item : items) {
					if (item.isFormField()) { //id,pw,name,tel 받기
						if(item.getFieldName().equals("id")) {
							id = item.getString("UTF-8");
						}
						if(item.getFieldName().equals("pw")) {
							pw = item.getString("UTF-8");
						}
						if(item.getFieldName().equals("name")) {
							name = item.getString("UTF-8");
						}
						if(item.getFieldName().equals("tel")) {
							tel = item.getString("UTF-8");
						}

					}else {
						profile = FilenameUtils.getName(item.getName());
						File saveFile = new File(dir_path, profile);

						try {
							item.write(saveFile);
						} catch (Exception e) {
							e.printStackTrace();
						}

					}//end else

				}//end for << items
			} catch (FileUploadException e) {
				e.printStackTrace();
			}


		}//end if << isMultilpart
		System.out.println("id:"+id);
		System.out.println("pw:"+pw);
		System.out.println("name:"+name);
		System.out.println("tel:"+tel);
		System.out.println("img_name:"+profile);
		
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setTel(tel);
		vo.setProfile(profile);
		
		MemberDAO dao = new MemberDAOimpl();
		int result = dao.insert(vo);
		System.out.println("result:" + result);
		
		if(result==1)
			response.sendRedirect("m_selectAll.do");
		else
			response.sendRedirect("m_insert.do");
	}

}
