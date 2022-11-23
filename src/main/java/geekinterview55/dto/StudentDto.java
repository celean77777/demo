package geekinterview55.dto;

import geekinterview55.entities.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private int mark;

    public StudentDto(Student student){
        this.id = student.getId();
        this.name = student.getName();
        this.mark = student.getMark();
    }

}
