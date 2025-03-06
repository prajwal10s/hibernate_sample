package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeTest extends TestCase {
    public EmployeeTest(String testName) {
        super(testName); // Required constructor for JUnit 3
    }
    public void testInsertionOfRecord(){
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Employee E1 = new Employee("Yadavendra", "Sakharkar", 1000);
        try (Session session = sf.openSession()){
            session.beginTransaction();
            session.persist(E1);
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static junit.framework.Test suite() {
        return new TestSuite(EmployeeTest.class); // Explicitly add the test case
    }
}
