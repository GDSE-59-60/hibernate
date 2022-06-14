import lk.ijse.hibernate.entity.Laptop;
import lk.ijse.hibernate.entity.Owner;
import lk.ijse.hibernate.entity.Pet;
import lk.ijse.hibernate.entity.Student;
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
    }
}
