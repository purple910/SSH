package sunyang;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;


/**
 * Servlet implementation class Download
 */
@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//获取下载的文件名字
		String fileName = request.getParameter("filename");
		//下载文件:设置消息头
		response.addHeader("contentType", "application/octet-stream");//二进制文件
		//获取留恋其的头信息
		String agent = request.getHeader("User-Agent");
		
		if(agent.toLowerCase().indexOf("firefox")!=-1) {
			response.addHeader("Content-Disposition", "attachment;filename==?UTF-8"+new String(Base64.encodeBase64(fileName.getBytes("utf-8")))+"?=");//firfox
		}else if(agent.toLowerCase().indexOf("edge")!=-1){
			response.addHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "utf-8"));//防止edge乱码

		}
		
		//
		InputStream in  = getServletContext().getResourceAsStream("/reg/1.png");
		
		ServletOutputStream out = response.getOutputStream();//通过输出流将已经转换输入流的文件 输入给用户
		byte[] bs = new byte[24];
		int len = 0;
		while((len=in.read())!=-1){
			out.write(len);
		}
		out.close();
		in.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
