package com.service;

import com.dao.StudentDao;

public class DeleteStudentService {

	public static boolean delete(int id) {
		
		if(StudentDao.queryStudent(id)!=null) {
			return StudentDao.deleteStudent(id);
		}
		return false;
	}
}
