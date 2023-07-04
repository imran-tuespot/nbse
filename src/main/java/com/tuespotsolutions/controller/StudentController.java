package com.tuespotsolutions.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuespotsolutions.model.StudentModel;
import com.tuespotsolutions.service.StudentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin
@RequestMapping("api/v1/")
public class StudentController {

	@Autowired
	StudentService service;

	@PostMapping("/save")
	public ResponseEntity<?> add(@RequestBody StudentModel model) {

		StudentModel add = this.service.add(model);
		return new ResponseEntity<StudentModel>(add, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<?> get() {
		List<StudentModel> list = this.service.get();
		return new ResponseEntity<List<StudentModel>>(list, HttpStatus.OK);
	}

	@GetMapping("/getStudentBy")
	public ResponseEntity<?> getStudentBy(Long id) {
		StudentModel studentBy = this.service.getStudentBy(id);
		return new ResponseEntity<StudentModel>(studentBy, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(StudentModel model) {
		StudentModel update = this.service.update(model);
		return new ResponseEntity<StudentModel>(update, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteStudentBy(Long id) {
		Map<String, String> deleteStudentBy = this.service.deleteStudentBy(id);
		return new ResponseEntity<Map<String, String>>(deleteStudentBy, HttpStatus.OK);
	}
}
