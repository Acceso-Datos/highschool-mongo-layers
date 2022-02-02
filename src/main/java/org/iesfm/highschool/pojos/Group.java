package org.iesfm.highschool.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "groups")
public class Group {

    @Id
    private int id;
    private String title;
    private int course;
    private String letter;
    private String classroom;
    private int year;

    public Group(
            int id,
            String title,
            int course,
            String letter,
            String classroom,
            int year) {
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
        Group group = (Group) o;
        return id == group.id && course == group.course && year == group.year && Objects.equals(title, group.title) && Objects.equals(letter, group.letter) && Objects.equals(classroom, group.classroom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, course, letter, classroom, year);
    }
}
