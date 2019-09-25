package com.servlet;

import com.factory.StudentBean;
import com.service.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.SeeAllStudentService;

/**
 * Servlet implementation class SeeAllStudentServlet
 */
@WebServlet("/SeeAllStudentServlet")
public class SeeAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeAllStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<StudentBean> result = SeeAllStudentService.SeeAll();
		if(result!=null) {
			request.setAttribute("result", result);
			request.getRequestDispatcher("SeeAllStudent.jsp").forward(request, response);;
		}else {
			request.getSession().setAttribute("error", "数据库里面没人");
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
