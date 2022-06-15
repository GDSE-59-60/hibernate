import lk.ijse.hibernate.entity.Owner;
import lk.ijse.hibernate.entity.Pet;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
    @author DanujaV
    @created 24/05/2022 - 10:46 AM
*/
public class AppInitializer {
    public static void main(String[] args) {
        Owner owner = new Owner();
        owner.setoId("O001");
        owner.setName("Maneesha");

        Pet p1 = new Pet();
        p1.setpId("P001");
        p1.setName("Dog");
        p1.setOwner(owner);

        Pet p2 = new Pet();
        p2.setpId("P002");
        p2.setName("Cat");
        p2.setOwner(owner);

        owner.getPetList().add(p1);
        owner.getPetList().add(p2);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        //1st methodology for fetching data from the table
        // return true object IF NOT return NullPointerException
        Owner o1 = session.get(Owner.class, "O001");  //query has executed
//        session.delete(o1);
        System.out.println(o1.getoId());

        //2nd methodology for fetching data from the table
        //return proxy object IF NOT return ObjectNotFoundException
        Owner o2 = session.load(Owner.class, "O002");   //query has not executed
        session.delete(o2);
        System.out.println(o2.getoId());

        System.out.println("-----------");

        System.out.println(o2.getName());   //query has begin to execute!

        transaction.commit();
        session.close();

    }
}
