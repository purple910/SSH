package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.StudentBean;
import com.service.SeeAllStudentPageService;

/**
 * Servlet implementation class SeeAllStudentPageServlet
 */
@WebServlet("/SeeAllStudentPageServlet")
public class SeeAllStudentPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeAllStudentPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SeeAllStudentPageService studentPage = new SeeAllStudentPageService();
		int count = studentPage.getTotal();
		ArrayList<StudentBean> result =  studentPage.queryAllStudentPageService(1, 5);
		if(result!=null) {
			request.setAttribute("result", result);
			request.getRequestDispatcher("SeeAllStudentPage.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("error", "加载分页失败");
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
