package com.tuespotsolutions.service;

import java.util.List;
import java.util.Map;

import com.tuespotsolutions.model.StudentModel;

public interface StudentService {
	
	public StudentModel add(StudentModel model);

	public List<StudentModel> get();

	public StudentModel getStudentBy(Long id);
	
	public StudentModel update(StudentModel model);
	
	public Map<String, String> deleteStudentBy(Long id);

}
