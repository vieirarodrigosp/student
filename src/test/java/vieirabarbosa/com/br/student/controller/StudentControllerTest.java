package vieirabarbosa.com.br.student.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import vieirabarbosa.com.br.student.DTO.StudentDTO;
import vieirabarbosa.com.br.student.business.object.RegisterStudentBO;
import vieirabarbosa.com.br.student.config.VariablesMocked;

@RunWith(SpringRunner.class)
public class StudentControllerTest {
	@InjectMocks
	private StudentController studentController;
	@Mock
	private RegisterStudentBO registerStudent;
	@Test
	public void createStudentSucess() {
		when(registerStudent.createStudentDTO(Mockito.any())).thenReturn(true);
		assertEquals(true, studentController.createStudent(VariablesMocked.getStudent()));
	}
	@Test
	public void createStudentFalse() {
		when(studentController.createStudent(Mockito.any())).thenReturn(false);
		assertEquals(false, studentController.createStudent(null));
	}
	@Test
	public void getStudentListWithList() {
		when(studentController.getStudentList()).thenReturn(VariablesMocked.getStudentListObject("withList"));
		assertEquals(1, studentController.getStudentList().length);
	}
	@Test
	public void getStudentListNoList() {
		when(studentController.getStudentList()).thenReturn(VariablesMocked.getStudentListObject("withList"));
		assertNotEquals(3, studentController.getStudentList().length);
	}
	@Test
	public void getStudentDTObyIdSucess() {
		when(studentController.getStudentDTObyId(Mockito.anyInt())).thenReturn(VariablesMocked.getStudent());
		assertEquals(true, studentController.getStudentDTObyId(0).getMatricula().equals("1"));
	}
	@Test
	public void getStudentDTObyIdFalse() {
		when(studentController.getStudentDTObyId(Mockito.anyInt())).thenReturn(VariablesMocked.getStudent());
		assertNotEquals("2", studentController.getStudentDTObyId(0).getMatricula());
	}
	@Test
	public void updateStudentDTObyIdSucess() {
		when(studentController.updateStudentDTObyId(Mockito.anyInt(), Mockito.any())).thenReturn(VariablesMocked.getStudent());
		assertEquals(VariablesMocked.getStudent().getName(), studentController.updateStudentDTObyId(0, VariablesMocked.getStudent()).getName());
	}
	@Test
	public void deleteStudentDTObyIdSucess() {
		when(studentController.deleteStudentDTObyId(Mockito.anyInt())).thenReturn(VariablesMocked.getStudent());
		assertEquals(VariablesMocked.getStudent().getName(), studentController.deleteStudentDTObyId(0).getName());
	}
	@Test
	public void setStudentDTOSucess() {
		when(studentController.getStudentDTObyId(Mockito.anyInt())).thenReturn(VariablesMocked.getStudent());
		StudentDTO student1 = StudentDTO.builder().build();
		student1.setName("Pedro");
		student1.setMatricula("3");
		StudentDTO student2 = StudentDTO.builder().matricula("4").build();
		assertEquals("Pedro", student1.getName());
		assertEquals("4", student2.getMatricula());
	}
}