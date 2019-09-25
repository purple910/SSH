package com.service;

import com.factory.StudentBean;
import com.dao.StudentDao;;
public class UpdateStudentService {

	public static boolean update(StudentBean stu) {
		boolean temp = false;
		if(StudentDao.queryStudent(stu.getId()) != null) {
			temp = StudentDao.updateStudent(stu);
		}
		return temp;		
	}
}
