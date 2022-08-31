package test.com.fileupload;

import java.io.File;
import java.io.IOException;
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

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/fileUpload.do")
public class FileController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public FileController() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      System.out.println("doPost():");

      String dir_path = request.getServletContext().getRealPath("/upload");
      System.out.println(dir_path);

      int fileSizeMax = 1024 * 1024 * 100;
      boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);

      // Multipart 요청이면 true, 일반요청이면 false
      if (isMultipartContent) {
         DiskFileItemFactory factory = new DiskFileItemFactory();
         factory.setSizeThreshold(fileSizeMax);

         ServletFileUpload sfu = new ServletFileUpload(factory);
         sfu.setFileSizeMax(fileSizeMax);// 파일 사이즈 제한
         
         String name ="";
         int age =0;
         String imgName ="";
         try {
            List<FileItem> items = sfu.parseRequest(request);
            for (FileItem item : items) {
               if (item.isFormField()) { // name,age 받기
                  if(item.getFieldName().equals("name")) {
                     name = item.getString("UTF-8");
                  }
                  if(item.getFieldName().equals("age")) {
                     age = Integer.parseInt(item.getString("UTF-8"));
                  }
                  
//                  System.out.println("폼필드 키 : " + item.getFieldName());
//                  System.out.println("폼필드 값 : " + item.getString("UTF-8"));

               }else { //file 정보받기.
//                  System.out.println("파일의 키 : " + item.getFieldName());
//                  System.out.println("파일 파일명 : " + item.getName());
//                  System.out.println("파일 컨텐츠 타입 : " + item.getContentType());
//                  System.out.println("파일 사이즈  : " + item.getSize());
                  
                  imgName = FilenameUtils.getName(item.getName());

                  File saveFile = new File(dir_path, imgName);
      
                  try {
                     item.write(saveFile);
                  } catch (Exception e) {
                     e.printStackTrace();
                  }

               }
            }//end for
            

         } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

         System.out.println("name: "+ name);
         System.out.println("age: "+ age);
         System.out.println("imgName: "+ imgName);
      } //end if << isMultilpart

   }

}