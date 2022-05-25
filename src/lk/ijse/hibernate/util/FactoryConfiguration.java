package lk.ijse.hibernate.util;

import lk.ijse.hibernate.enitity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
    @author DanujaV
    @created 24/05/2022 - 10:46 AM
*/

//this FactoryConfiguration class use Singleton design pattern
public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        // configure() -> load and config Hibernate.cfg.xml file to SessionFactory
        // addAnnotatedClass() -> define which Entity that gonna use to Persist
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class);

        // build a SessionFactory and assign it to sessionFactory reference
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration()
                : factoryConfiguration;
    }
    // return a new Session through sessionFactory
    public Session getSession() {
        return sessionFactory.openSession();
    }
}
