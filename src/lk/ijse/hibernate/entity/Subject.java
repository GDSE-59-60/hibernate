package lk.ijse.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {
    @Id
    private String subCode;
    private String name;

    @ManyToMany(mappedBy = "subjectList")
    private List<Lecturer> lecturerList = new ArrayList<>();

    public Subject() {
    }

    public Subject(String subCode, String name, List<Lecturer> lecturerList) {
        this.subCode = subCode;
        this.name = name;
        this.lecturerList = lecturerList;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Lecturer> getLecturerList() {
        return lecturerList;
    }

    public void setLecturerList(List<Lecturer> lecturerList) {
        this.lecturerList = lecturerList;
    }
}
