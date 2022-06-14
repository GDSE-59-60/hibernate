import lk.ijse.hibernate.embeded.Name;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
    @author DanujaV
    @created 24/05/2022 - 10:46 AM
*/
public class AppInitializer {
    public static void main(String[] args) {

        Name name = new Name();
        name.setFirstName("Danuja");
        name.setSecondName("Vimukthi");
        name.setLastName("Deshan");

        Customer c1 = new Customer();
        c1.setId("C001");
        c1.setSalary(200000);
        c1.setAddress("Panadura");
        c1.setName(name);

        // get a new session
        Session session = FactoryConfiguration.getInstance().getSession();

        // transaction begin
        Transaction transaction = session.beginTransaction();

        session.save(c1);

        transaction.commit();

        session.close();
    }
}
