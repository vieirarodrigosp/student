package vieirabarbosa.com.br.student.config;

import java.util.ArrayList;
import java.util.List;

import vieirabarbosa.com.br.student.DTO.StudentDTO;

public class VariablesMocked {
	public static StudentDTO getStudent() {
		return StudentDTO.builder().name("Rodrigo Vieira").matricula("1").build();
	}
	public static Object[] getStudentListObject(String scenario) {
		List<StudentDTO> studentListDTO = new ArrayList<StudentDTO>();
		switch (scenario) {
		case "withList":
			studentListDTO.add(getStudent());	
			break;
		default:
			break;
		}
		return studentListDTO.toArray();
	}
}