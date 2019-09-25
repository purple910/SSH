package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.factory.StudentBean;
import com.service.SeeStudentService;

/**
 * Servlet implementation class SeeStudentServlet
 */
@WebServlet("/SeeStudentServlet")
public class SeeStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		StudentBean stu = SeeStudentService.See(id);
		if( stu!= null) {
			request.setAttribute("stu", stu);
			request.getRequestDispatcher("SeeUpdateStudent.jsp").forward(request, response);
		}
		else {
			request.getSession().setAttribute("error", "查无此人");		
			response.sendRedirect("error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
