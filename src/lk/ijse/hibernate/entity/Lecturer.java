package lk.ijse.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lecturer {
    @Id
    private String lId;
    private String name;

    @ManyToMany
    private List<Subject> subjectList = new ArrayList<>();

    public Lecturer() {
    }

    public Lecturer(String lId, String name, List<Subject> subjectList) {
        this.lId = lId;
        this.name = name;
        this.subjectList = subjectList;
    }

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
