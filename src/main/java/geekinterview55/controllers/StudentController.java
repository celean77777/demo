package geekinterview55.controllers;

import geekinterview55.dto.StudentDto;
import geekinterview55.entities.Student;
import geekinterview55.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>>  findAll(){
        final List<Student> studentList = studentService.findAll();
        return studentList != null &&  !studentList.isEmpty()
                ? new ResponseEntity<>(studentList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> findStudentById(@PathVariable Long id){
        StudentDto studentDto = new StudentDto(studentService.findById(id).get());
        return studentDto != null
                ? new ResponseEntity<>(studentDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/students")
    public StudentDto save(@RequestBody StudentDto studentDto){
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setMark(studentDto.getMark());
        studentService.save(student);
        return new StudentDto(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteById(id);
    }






}
