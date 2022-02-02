package org.iesfm.highschool.services;

import org.iesfm.highschool.pojos.Group;
import org.iesfm.highschool.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {


    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> list() {
        return groupRepository.findAll();
    }

    public boolean insert(Group group) {
        if(groupRepository.existsById(group.getId())) {
            return false;
        }
        groupRepository.insert(group);
        return true;
    }
}
