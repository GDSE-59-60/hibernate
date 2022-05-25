package lk.ijse.hibernate.util;

import lk.ijse.hibernate.enitity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
    @author DanujaV
    @created 24/05/2022 - 10:46 AM
*/
public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration()
                : factoryConfiguration;
    }
    public Session getSession() {
        return sessionFactory.openSession();
    }
}
