package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

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
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }
    public void testAddRecords(){
        Configuration conf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student_rel.class).addAnnotatedClass(Laptop_rel.class);
        SessionFactory sf = conf.buildSessionFactory();
        Laptop_rel l1 = new Laptop_rel();
        l1.setLid(102);
        l1.setLname("Lenovo");
        Laptop_rel l2 = new Laptop_rel();
        l2.setLid(103);
        l2.setLname("Lenovo Mac");
        Student_rel s1 = new Student_rel();
        s1.setRollNo(2);
        s1.setName("Ram");
        s1.setMarks(95);
        s1.getLaptops().add(l1);
        s1.getLaptops().add(l2);
        l1.setStudent(s1);
        l2.setStudent(s1);
        Student_rel s2 =  new Student_rel();
        s2.setRollNo(3);
        s2.setName("Akash");
        s2.setMarks(50);
        try(Session session =  sf.openSession()){
            session.beginTransaction();
            session.persist(l1);
            session.persist(l2);
            session.persist(s1);
            session.persist(s2);
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }
    public void testfetchRecords(){
        Configuration conf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student_rel.class).addAnnotatedClass(Laptop_rel.class);
        SessionFactory sf = conf.buildSessionFactory();

        try(Session session = sf.openSession()){
            session.beginTransaction();
            Student_rel s1 = session.get(Student_rel.class, 1);
            Laptop_rel l1 =  session.get(Laptop_rel.class, 102);

            System.out.println(s1);
            System.out.println(l1);
//            List<Laptop_rel> laptops = s1.getLaptops();
//            for(Laptop_rel laptop:laptops){
//                System.out.println(laptop.getLname());
//            }
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    public static junit.framework.Test suite() {
        return new TestSuite(Mapping_test.class); // Explicitly add the test case
    }
}
