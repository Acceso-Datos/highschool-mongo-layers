package org.iesfm.highschool.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "students")
public class Student {
    @Id
    private String nif;
    private String name;
    private String surname;
    private int groupId;
    private List<Absence> absences;

    public Student(String nif, String name, String surname, int groupId, List<Absence> absences) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.groupId = groupId;
        this.absences = absences;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(List<Absence> absences) {
        this.absences = absences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return groupId == student.groupId && Objects.equals(nif, student.nif) && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(absences, student.absences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surname, groupId, absences);
    }
}
