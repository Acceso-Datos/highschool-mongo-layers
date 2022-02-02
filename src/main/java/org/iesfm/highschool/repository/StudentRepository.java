package org.iesfm.highschool.repository;

import org.iesfm.highschool.pojos.Group;
import org.iesfm.highschool.pojos.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByGroupId(int groupId);

    Student findByGroupIdAndNif(int groupId, String nif);
}
