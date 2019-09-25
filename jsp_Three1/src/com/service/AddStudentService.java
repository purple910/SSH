package com.service;

import com.dao.StudentDao;
import com.factory.StudentBean;

public class AddStudentService {

	public static boolean Add(StudentBean stu) {
		boolean temp = false;
		if(StudentDao.queryStudent(stu.getId()) == null) {
			temp = StudentDao.insertStudent(stu);
		}
		return temp;
		
	}
}
