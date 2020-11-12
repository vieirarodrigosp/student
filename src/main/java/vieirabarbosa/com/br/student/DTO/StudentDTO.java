package vieirabarbosa.com.br.student.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class StudentDTO {
	String name;
	String matricula;
}