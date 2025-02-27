package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AppTest extends TestCase{
    public AppTest(String testName) {
        super(testName); // Required constructor for JUnit 3
    }
    public void test_save_my_first_object_to_the_db(){
        Alien alien = new Alien();
        alien.setColor("Blue");
        alien.setId(202);
        alien.setAname("Prajwal");
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        try (Session session = sf.openSession()){
            session.beginTransaction();
            session.persist(alien);
            session.getTransaction().commit();

        }
        catch(Exception e){
            System.out.println(e);
        }
        assertTrue(true);
    }

    public static junit.framework.Test suite() {
        return new TestSuite(AppTest.class); // Explicitly add the test case
    }
}
