package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.StudentBean;
import com.service.AddStudentService;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String date = request.getParameter("date");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String other = request.getParameter("other");
		StudentBean stu = new StudentBean(id,name,sex,date,phone,email,address,other);
		boolean temp = AddStudentService.Add(stu);
		if(temp) {
			response.sendRedirect("SeeAllStudentServlet");
		}
		else {
			request.getSession().setAttribute("error", "添加失败!");
			response.sendRedirect("error.jsp");
		}
	}

}
