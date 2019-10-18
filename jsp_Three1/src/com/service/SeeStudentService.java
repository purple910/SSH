package com.service;

import com.dao.StudentDao;
import com.factory.StudentBean;

public class SeeStudentService {

	public static StudentBean See(int id) {
		
		return StudentDao.queryStudent(id);		
	}
}
