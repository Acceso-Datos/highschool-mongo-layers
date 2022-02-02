package org.iesfm.highschool.api.controllers;

import org.iesfm.highschool.api.controllers.pojos.GroupApi;
import org.iesfm.highschool.pojos.Group;
import org.iesfm.highschool.services.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GroupController {

    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/groups")
    public List<GroupApi> list() {
        return convertToApi(groupService.list());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/groups")
    public void addGroup(@RequestBody GroupApi group) {
        if (!groupService.insert(convertToModel(group))) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe");
        }
    }


    public GroupApi convertToApi(Group group) {
        return new GroupApi(
                group.getId(),
                group.getTitle(),
                group.getCourse(),
                group.getLetter(),
                group.getClassroom(),
                group.getYear()
        );
    }

    public Group convertToModel(GroupApi group) {
        return new Group(
                group.getId(),
                group.getTitle(),
                group.getCourse(),
                group.getLetter(),
                group.getClassroom(),
                group.getYear()
        );
    }

    private List<GroupApi> convertToApi(List<Group> groups) {
        return groups
                .stream()
                .map(group -> convertToApi(group))
                .collect(Collectors.toList());
    }

    private List<Group> convertToModel(List<GroupApi> groups) {
        return groups
                .stream()
                .map(group -> convertToModel(group))
                .collect(Collectors.toList());
    }
}
