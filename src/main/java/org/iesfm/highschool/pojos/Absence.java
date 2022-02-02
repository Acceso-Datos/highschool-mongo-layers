package org.iesfm.highschool.pojos;

import java.util.Date;
import java.util.Objects;

public class Absence {
    private String module;
    private Date date;

    public Absence(String module, Date date) {
        this.module = module;
        this.date = date;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Absence absence = (Absence) o;
        return Objects.equals(module, absence.module) && Objects.equals(date, absence.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(module, date);
    }
}
