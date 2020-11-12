package vieirabarbosa.com.br.student.controller;

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

import vieirabarbosa.com.br.student.DTO.StudentDTO;
import vieirabarbosa.com.br.student.business.object.RegisterStudentBO;

@RestController
@RequestMapping("/school")
public class StudentController {
	@Autowired
	private RegisterStudentBO registerStudent;
	@PostMapping(path = "/v1/students")
	public @ResponseBody Boolean createStudent(@RequestBody StudentDTO student) {
		return registerStudent.createStudentDTO(student);
	}
	@GetMapping(path = "/v1/students")
	public @ResponseBody Object[] getStudentList() {
		return registerStudent.getStudentDTOList();
	}
	@GetMapping(path = "/v1/students/{id}")
	public @ResponseBody StudentDTO getStudentDTObyId(@PathVariable("id") int id) {
		return registerStudent.getStudentDTObyId(id);
	}
	@PutMapping(path = "/v1/students/{id}")
	public @ResponseBody StudentDTO updateStudentDTObyId(
			@PathVariable("id") int id
			, @RequestBody StudentDTO student) {
		return registerStudent.updateStudentDTObyId(id, student);
	}
	@DeleteMapping(path = "/v1/students/{id}")
	public @ResponseBody StudentDTO deleteStudentDTObyId(@PathVariable("id") int id) {
		return registerStudent.deleteStudentDTObyId(id);
	}
}