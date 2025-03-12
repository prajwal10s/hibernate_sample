package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

public class Mapping_test extends TestCase {
    public Mapping_test(String testName){
        super(testName);
    }
    public void testMapping(){
        Configuration conf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student_rel.class).addAnnotatedClass(Laptop_rel.class);
        SessionFactory sf = conf.buildSessionFactory();
        Laptop_rel l1 = new Laptop_rel();
        l1.setLid(101);
        l1.setLname("Dell");
        Student_rel s1 = new Student_rel();
        s1.setRollNo(1);
        s1.setName("Jai");
        s1.setMarks(80);
        s1.getLaptops().add(l1);
        l1.setStudent(s1);
        try(Session session = sf.openSession()){
            session.beginTransaction();

            session.persist(s1);
            session.persist(l1);
            session.getTransaction().commit();
        }
    }
    public static junit.framework.Test suite() {
        return new TestSuite(Mapping_test.class); // Explicitly add the test case
    }
}
