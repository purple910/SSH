package sunyang;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;

public class CommonUpload extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");//响应
			response.setContentType("text/html; charset=UTF-8");//显示
			try {
			//上传
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);//判断mutipart字段
			if(isMultipart) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);					
				//设置上传的临时文件  //DiskFileItemFactory
				//factory.setSizeThreshold(10240);//10240kb
				//factory.setRepository(new File("..."));//临时目录
				//文件大小限制 20480kb
				upload.setSizeMax(20480);//ServletFileUpload				
				List<FileItem> items = upload.parseRequest(request);//保存前台传来的数据
				Iterator<FileItem> iter = items.iterator();
				while(iter.hasNext()) {
					FileItem item = iter.next();					
					//判断表单字段好是file字段
					if(item.isFormField()) {
						String iterName = item.getFieldName();//普通字段
						String name = null;
						if(iterName.equals("name")) {//根据name属性拿值
							name = item.getString("utf-8");//防止乱码
						}else {
							System.out.println("....");
						}
					}else {
						//文件名字
						String fileName = item.getName();//文件字段
						//类型限制
						String ext = fileName.substring(fileName.indexOf(".")+1);
						if(!(ext.equals("png")||ext.equals("jpg")||ext.equals("gif"))) {
							System.out.println("类型越界!!");
							//response.sendRedirect("CommonUpload.jsp");
							return ;
						}						
						//文件内容
						//定义文件路径
						//获取服务器路径
						String path = request.getSession().getServletContext().getRealPath("upload");
						File file = new File(path,fileName);																		
						item.write(file);//上传  
						System.out.println("上传成功!!");
						return ;
					}
				}
			}
		} catch (FileUploadBase.SizeLimitExceededException e) {//大小越界
			// TODO Auto-generated catch block
			System.out.println("大小越界!");
			e.printStackTrace();
		}catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
}
