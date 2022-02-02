package org.iesfm.highschool.api.controllers.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class GroupApi {
    private int id;
    private String title;
    private int course;
    private String letter;
    private String classroom;
    private int year;

    @JsonCreator
    public GroupApi(
            @JsonProperty("id") int id,
            @JsonProperty("title") String title,
            @JsonProperty("course") int course,
            @JsonProperty("letter") String letter,
            @JsonProperty("classroom") String classroom,
            @JsonProperty("year") int year) {
        this.id = id;
        this.title = title;
        this.course = course;
        this.letter = letter;
        this.classroom = classroom;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupApi group = (GroupApi) o;
        return id == group.id && course == group.course && year == group.year && Objects.equals(title, group.title) && Objects.equals(letter, group.letter) && Objects.equals(classroom, group.classroom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, course, letter, classroom, year);
    }
}
