package org.iesfm.highschool.services;

import org.iesfm.highschool.pojos.Absence;
import org.iesfm.highschool.pojos.Student;
import org.iesfm.highschool.repository.GroupRepository;
import org.iesfm.highschool.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private GroupRepository groupRepository;
    private StudentRepository studentRepository;

    public StudentService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }


    public List<Student> listGroupStudents(int groupId) {

        return studentRepository.findByGroupId(groupId);
    }

    public boolean insert(Student student) {
        if (studentRepository.existsById(student.getNif())) {
            return false;
        }
        studentRepository.insert(student);
        return true;
    }

    public List<Student> findGroupStudents(int groupId) {
        return studentRepository.findByGroupId(groupId);
    }

    public Student getStudent(int groupId, String nif) {
        return studentRepository.findByGroupIdAndNif(groupId, nif);
    }

    public void addAbsence(String nif, int groupId, Absence absence) {
        Student student = getStudent(groupId, nif);
        student.getAbsences().add(absence);
        studentRepository.save(student);
    }
}
