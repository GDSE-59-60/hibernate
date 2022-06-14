import lk.ijse.hibernate.entity.*;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/*
    @author DanujaV
    @created 24/05/2022 - 10:46 AM
*/
public class AppInitializer {
    public static void main(String[] args) {
        //One to One Relation
        /*Student student = new Student();
        student.setsId("S001");
        student.setName("Danuja");
        student.setAddress("Galle");

        Laptop laptop = new Laptop();
        laptop.setCode("L001");
        laptop.setModel("HP");
        laptop.setStudent(student);

        // get a new session
        Session session = FactoryConfiguration.getInstance().getSession();

        // transaction begin
        Transaction transaction = session.beginTransaction();

        session.save(student);
        session.save(laptop);

        transaction.commit();

        session.close();
*/

        //One to Many Relation
        /*Owner owner = new Owner();
        owner.setoId("O001");
        owner.setName("Danuja");


        Pet p1 = new Pet();
        p1.setpId("P001");
        p1.setName("Dog");

        Pet p2 = new Pet();
        p2.setpId("P002");
        p2.setName("Cat");

        p1.setOwner(owner);
        p2.setOwner(owner);

        // 1st methodology
        List<Pet> petList = new ArrayList<>();
        petList.add(p1);
        petList.add(p2);

        owner.setPetList(petList);

        // get a new session
        Session session = FactoryConfiguration.getInstance().getSession();

        // transaction begin
        Transaction transaction = session.beginTransaction();

        session.save(owner);
        session.save(p1);
        session.save(p2);

        transaction.commit();

        session.close();*/

        //Many to Many Relation
        Subject s1 = new Subject();
        s1.setSubCode("SB001");
        s1.setName("PRF");

        Subject s2 = new Subject();
        s2.setSubCode("SB002");
        s2.setName("ORM");

        Subject s3 = new Subject();
        s3.setSubCode("SB003");
        s3.setName("DBM");

        Lecturer l1 = new Lecturer();
        l1.setlId("L001");
        l1.setName("Danuja");

        Lecturer l2 = new Lecturer();
        l2.setlId("L002");
        l2.setName("Niroth");

        //1 methodology
        /*ArrayList<Subject> danujaSubjectList = new ArrayList<>();
        danujaSubjectList.add(s1);
        danujaSubjectList.add(s2);

        ArrayList<Subject> nirothSubjectList = new ArrayList<>();
        nirothSubjectList.add(s1);
        nirothSubjectList.add(s3);

        ArrayList<Lecturer> sub1LectureList = new ArrayList<>();
        sub1LectureList.add(l1);
        sub1LectureList.add(l2);

        ArrayList<Lecturer> sub2LectureList = new ArrayList<>();
        sub2LectureList.add(l1);

        ArrayList<Lecturer> sub3LectureList = new ArrayList<>();
        sub3LectureList.add(l2);

        l1.setSubjectList(danujaSubjectList);
        l2.setSubjectList(nirothSubjectList);

        s1.setLecturerList(sub1LectureList);
        s2.setLecturerList(sub2LectureList);
        s3.setLecturerList(sub3LectureList);*/

        //2 methodology
        l1.getSubjectList().add(s1);
        l1.getSubjectList().add(s2);
        l2.getSubjectList().add(s3);

        s1.getLecturerList().add(l1);
        s2.getLecturerList().add(l1);
        s3.getLecturerList().add(l2);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(l1);
        session.save(l2);
        session.save(s1);
        session.save(s2);
        session.save(s3);

        transaction.commit();
        session.close();
    }
}
