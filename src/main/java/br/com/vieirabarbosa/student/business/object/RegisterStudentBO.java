package br.com.vieirabarbosa.student.business.object;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.vieirabarbosa.student.DTO.StudentDTO;

@Component
public class RegisterStudentBO {
	public List<StudentDTO> studentListDTO = new ArrayList<StudentDTO>();
	public Boolean createStudentDTO(StudentDTO student) {
		return studentListDTO.add(student);
	}
	public Object[] getStudentDTOList() {
		return studentListDTO.toArray();
	}
	public StudentDTO getStudentDTObyId(int id) {
		return studentListDTO.get(id);
	}
	public StudentDTO updateStudentDTObyId(int id, StudentDTO student) {
		return studentListDTO.set(id, student);
	}
	public StudentDTO deleteStudentDTObyId(int id) {
		return studentListDTO.remove(id);
	}
}