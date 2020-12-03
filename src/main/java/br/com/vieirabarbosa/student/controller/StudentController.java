package br.com.vieirabarbosa.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vieirabarbosa.student.DTO.StudentDTO;
import br.com.vieirabarbosa.student.business.object.RegisterStudentBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/school")
@Api(value = "API REST Student"
, tags = "Student Registration Microservice API"
, description = "This microservice is responsible for registering, updating, deleting and listing students.")
public class StudentController {
	@Autowired
	private RegisterStudentBO registerStudent;
	@PostMapping(path = "/v1/students")
	@ApiOperation(value = "This method is responsible for creating new students.")
	public @ResponseBody Boolean createStudent(@RequestBody StudentDTO student) {
		return registerStudent.createStudentDTO(student);
	}
	@GetMapping(path = "/v1/students")
	@ApiOperation(value = "This method is responsible for listing all students.")
	public @ResponseBody Object[] getStudentList() {
		return registerStudent.getStudentDTOList();
	}
	@GetMapping(path = "/v1/students/{id}")
	@ApiOperation(value = "This method is responsible for displaying a student by id.")
	public @ResponseBody StudentDTO getStudentDTObyId(@PathVariable("id") int id) {
		return registerStudent.getStudentDTObyId(id);
	}
	@PutMapping(path = "/v1/students/{id}")
	@ApiOperation(value = "This method is responsible for updating a student by id.")
	public @ResponseBody StudentDTO updateStudentDTObyId(
			@PathVariable("id") int id
			, @RequestBody StudentDTO student) {
		return registerStudent.updateStudentDTObyId(id, student);
	}
	@DeleteMapping(path = "/v1/students/{id}")
	@ApiOperation(value = "This method is responsible for creating new curricular grid records.")
	public @ResponseBody StudentDTO deleteStudentDTObyId(@PathVariable("id") int id) {
		return registerStudent.deleteStudentDTObyId(id);
	}
}