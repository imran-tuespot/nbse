package com.tuespotsolutions.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tuespotsolutions.customExceptions.ValueNotFoundException;
import com.tuespotsolutions.entity.Student;
import com.tuespotsolutions.model.StudentModel;
import com.tuespotsolutions.repo.StudentRepository;
import com.tuespotsolutions.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;

	@Override
	public StudentModel add(StudentModel model) {
		Student student = new Student();
		student.setName(model.getName());
		Student save = this.repository.save(student);

		StudentModel response = new StudentModel();
		response.setId(save.getId());
		response.setName(save.getName());
		return response;
	}

	@Override
	public List<StudentModel> get() {
		List<StudentModel> arrayList = new ArrayList<>();
		List<Student> findAll = this.repository.findAll();
		findAll.forEach(data -> {
			StudentModel response = new StudentModel();
			response.setId(data.getId());
			response.setName(data.getName());
			arrayList.add(response);
		});
		return arrayList;
	}

	@Override
	public StudentModel getStudentBy(Long id) {
		Student student = this.repository.findById(id).orElseThrow(() -> new ValueNotFoundException("value not present with this id ="+id));
		StudentModel response = new StudentModel();
		response.setId(student.getId());
		response.setName(student.getName());
		return response;
	}

	@Override
	public StudentModel update(StudentModel model) {
		Student orElseThrow = this.repository.findById(model.getId()).orElseThrow(()-> new ValueNotFoundException("value not present with this id = "+model.getId()));
		Student student = new Student();
		student.setId(model.getId());
		student.setName(model.getName());
		Student save = this.repository.save(student);

		StudentModel response = new StudentModel();
		response.setId(save.getId());
		response.setName(save.getName());
		return response;
	}

	@Override
	public Map<String, String> deleteStudentBy(Long id) {
		Student student = this.repository.findById(id).orElseThrow(()->  new ValueNotFoundException("value not present with this id = "+id));
		this.repository.delete(student);

		Map<String, String> map = new HashMap<>();
		map.put("message", "User deleted successfully");
		return map;
	}

}
