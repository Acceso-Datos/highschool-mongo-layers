package org.iesfm.highschool.repository;

import org.iesfm.highschool.pojos.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends MongoRepository<Group, Integer> {
}
