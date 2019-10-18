package com.service;

import java.util.ArrayList;

import com.dao.StudentDao;
import com.factory.StudentBean;

public class SeeAllStudentService {

	public static ArrayList<StudentBean> SeeAll() {
		return StudentDao.queryAllStudent();
	}
	
}
