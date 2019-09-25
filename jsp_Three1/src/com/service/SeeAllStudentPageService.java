package com.service;

import java.util.ArrayList;

import com.dao.StudentDao;
import com.factory.StudentBean;

public class SeeAllStudentPageService {

	public static int getTotal() {
		return StudentDao.getTotalCount();
	}
	public ArrayList<StudentBean> queryAllStudentPageService(int currentPage,int pageSize){
		return StudentDao.queryAllStudentPage(currentPage, pageSize);
	}
}
