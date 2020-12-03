package br.com.vieirabarbosa.student.business.object;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import br.com.vieirabarbosa.student.DTO.StudentDTO;
import br.com.vieirabarbosa.student.config.VariablesMocked;

@RunWith(SpringRunner.class)
public class RegisterStudentBOTest {
	@InjectMocks
	private RegisterStudentBO registerStudentBO;
	@Before
	public void init() {
		ReflectionTestUtils.setField(registerStudentBO, "studentListDTO", new ArrayList<StudentDTO>());
		registerStudentBO.studentListDTO.add(VariablesMocked.getStudent());
	}
	@Test
	public void createStudentDTOSucess() {
		assertEquals(true, registerStudentBO.createStudentDTO(VariablesMocked.getStudent()));
	}
	@Test
	public void studentListSucess() {
		assertEquals(1, registerStudentBO.getStudentDTOList().length);
	}
	@Test
	public void getStudentDTObyIdSucess() {
		assertEquals("1", registerStudentBO.getStudentDTObyId(0).getMatricula());
	}
	@Test
	public void updateStudentDTObyIdSucess() {
		assertEquals(VariablesMocked.getStudent().getName(), registerStudentBO.updateStudentDTObyId(0, VariablesMocked.getStudent()).getName());
	}
	@Test
	public void deleteStudentDTObyIdSucess() {
		assertEquals(VariablesMocked.getStudent().getName(), registerStudentBO.deleteStudentDTObyId(0).getName());
	}
}