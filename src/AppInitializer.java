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
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        // ----- In HQL -----

        // SELECT *
        /*String hql = "FROM Owner";  // need to add JPA Facet to the Module
        Query query = session.createQuery(hql);
        List<Owner> ownerList = query.list();

        for (Owner owner : ownerList) {
//            System.out.println(owner.getoId() + " : " + owner.getName() + " : " + owner.getPetList());
            System.out.println(owner);
        }*/

        // SELECT specified COLUMN
        /*String hql = "SELECT name FROM Owner";
        Query query = session.createQuery(hql);
        List<String> nameList = query.list();   // return String List

        for (String name : nameList) {
            System.out.println(name);
        }*/

        // WHERE clause
        /*String hql = "FROM Owner WHERE name LIKE 'D%'";
//        Query query = session.createQuery(hql);
//        List<Owner> ownerList = query.list();

        List<Owner> ownerList = session.createQuery(hql).list();

        for (Owner owner : ownerList) {
            System.out.println(owner.getoId() + " : " + owner.getName() + " : " + owner.getPetList());
        }*/

        // ORDER BY clause
        /*String hql = "FROM Owner o ORDER BY o.oId DESC";
        List<Owner> ownerList = session.createQuery(hql).list();

        for (Owner owner : ownerList) {
            System.out.println(owner.getoId() + " : " + owner.getName() + " : " + owner.getPetList());
        }*/

        // ----- Using name parameters -----
        // perform WHERE clause
        /*String name = "Danuja";
        String hql = "FROM Owner WHERE name = :owner_name";
        Query query = session.createQuery(hql);
        query.setParameter("owner_name", name);
        List<Owner> ownerList = query.list();

        for (Owner owner : ownerList) {
            System.out.println(owner.getoId() + " : " + owner.getName() + " : " + owner.getPetList());
        }*/

        // UPDATE clause -> query.executeUpdate()
        /*String id = "O001";
        String name = "Sumera";

        String hql = "UPDATE Owner SET name = :owner_name WHERE oId = :owner_id";
        Query query = session.createQuery(hql);
        query.setParameter("owner_name", name);
        query.setParameter("owner_id", id);

        int rowCount = query.executeUpdate();
        System.out.println(rowCount > 0 ? "Hureeeee!!!" : "OOPS!! something went wrong!");*/

        // DELETE clause -> query.executeUpdate()
        /*String id = "P003";
        String hql = "DELETE FROM Pet WHERE pId = :pet_id";

        Query query = session.createQuery(hql);
        query.setParameter("pet_id", id);

        System.out.println(query.executeUpdate() > 0 ? "Deleted..!" : "OOPs! something went wrong!");*/

        // INNER JOIN
        /*String hql = "SELECT o.oId, o.name, p.name FROM Owner o INNER JOIN Pet p ON o.oId = p.owner";
        List<Object[]> result = session.createQuery(hql).list();

        for (Object[] obj : result) {
            System.out.println(obj[0] + " : " + obj[1] + " : " + obj[2]);
        }*/

        // ----- In SQL -----
        // SELECT *
        /*String sql = "SELECT * FROM Owner";
        NativeQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(Owner.class);
        List<Owner> ownerList = sqlQuery.list();

        for (Owner owner : ownerList) {
            System.out.println(owner.getoId() + " : " + owner.getName() + " : " + owner.getPetList());
        }*/

        transaction.commit();
        session.close();

        // ----- Hibernate Caching -----
        // First Level Cache
        /*Session s1 = FactoryConfiguration.getInstance().getSession();
        Transaction transaction1 = s1.beginTransaction();

        Owner o1 = s1.get(Owner.class, "O002"); // Query execute only this line
        System.out.println("O1 from s1 session: " + o1);

        Owner o2 = s1.get(Owner.class, "O002"); // no query executed
        System.out.println("O2 from s1 session: " +o2);

        transaction1.commit();
        s1.close();

        Session s2 = FactoryConfiguration.getInstance().getSession();
        Transaction transaction2 = s2.beginTransaction();

        Owner o3 = s2.get(Owner.class, "O002"); // this time query has executed again
        System.out.println("O3 from s2 session: " +o3);

        transaction2.commit();
        s2.close();*/


        // Hibernate Object State
        Customer customer = new Customer(); // Transient State
        customer.setId("C003");
        customer.setAddress("Galle");
        customer.setFullName("Kushan");

        Session s = FactoryConfiguration.getInstance().getSession();
        Transaction transaction1 = s.beginTransaction();

        s.save(customer);   // Persistence State
        customer.setAddress("Jaffna");

//        s.detach(customer); // Detached State
//        customer.setAddress("London");

        s.delete(customer);    // Removed State

        transaction1.commit();
        s.close();
    }
}
