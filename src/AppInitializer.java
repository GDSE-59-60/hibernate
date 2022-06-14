import lk.ijse.hibernate.entity.Laptop;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

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


    }
}
