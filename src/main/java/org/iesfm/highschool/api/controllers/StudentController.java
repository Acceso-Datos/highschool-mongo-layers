package org.iesfm.highschool.api.controllers;

import org.iesfm.highschool.api.controllers.pojos.AbsenceApi;
import org.iesfm.highschool.api.controllers.pojos.StudentApi;
import org.iesfm.highschool.pojos.Absence;
import org.iesfm.highschool.pojos.Student;
import org.iesfm.highschool.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/groups/{groupId}/students")
    public List<StudentApi> listGroupStudents(
            @PathVariable("groupId") int groupId
    ) {
        List<Student> students = studentService.listGroupStudents(groupId);
        return convertToApi(students);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/groups/{groupId}/students")
    public void addStudentToGroup(
            @PathVariable("groupId") int groupId,
            @RequestBody StudentApi student
    ) {
        //Se convierte a Api
        Student st = convertToModel(student, groupId);
        //Se inserta en RestService
        if (!studentService.insert(st)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "");
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/groups/{groupId}/students/{nif}/absences")
    public List<AbsenceApi> getStudentAbsences(
            @PathVariable("nif") String nif,
            @PathVariable("groupId") int groupId
    ) {
        Student student = studentService.getStudent(groupId, nif);
        return student
                .getAbsences()
                .stream()
                .map(absence ->
                        new AbsenceApi(
                                absence.getModule(),
                                absence.getDate()
                        )
                )
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/groups/{groupId}/students/{nif}/absences")
    public void getStudentAbsences(
            @PathVariable("nif") String nif,
            @PathVariable("groupId") int groupId,
            @RequestBody AbsenceApi absence
    ) {
        studentService.addAbsence(
                nif,
                groupId,
                new Absence(
                        absence.getModule(),
                        absence.getDate()
                )
        );
    }

    public StudentApi convertToApi(Student student) {
        return new StudentApi(
                student.getNif(),
                student.getName(),
                student.getSurname()
        );
    }

    public Student convertToModel(StudentApi student, int groupId) {
        return new Student(
                student.getNif(),
                student.getName(),
                student.getSurname(),
                groupId,
                new LinkedList<>()
        );
    }

    private List<StudentApi> convertToApi(List<Student> students) {
        return students
                .stream()
                .map(group -> convertToApi(group))
                .collect(Collectors.toList());
    }

    private List<Student> convertToModel(List<StudentApi> students, int groupId) {
        return students
                .stream()
                .map(group -> convertToModel(group, groupId))
                .collect(Collectors.toList());
    }
}
