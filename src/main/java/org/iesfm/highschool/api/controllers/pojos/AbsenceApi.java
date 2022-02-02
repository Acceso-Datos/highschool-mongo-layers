package org.iesfm.highschool.api.controllers.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class AbsenceApi {
    private String module;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @JsonCreator
    public AbsenceApi(
            @JsonProperty("module") String module,
            @JsonProperty("date")Date date) {
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
        AbsenceApi that = (AbsenceApi) o;
        return Objects.equals(module, that.module) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(module, date);
    }
}
