import lk.ijse.hibernate.enitity.Customer;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
    @author DanujaV
    @created 24/05/2022 - 10:46 AM
*/
public class AppInitializer {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.setId("C001");
        c1.setName("Kamal");
        c1.setSalary(200000);
        c1.setAddress("Panadura");

        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.save(c1);

        transaction.commit();

        session.close();
    }
}
