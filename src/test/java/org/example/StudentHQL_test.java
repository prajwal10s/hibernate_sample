package org.example;

import jakarta.persistence.Query;
import jakarta.persistence.SynchronizationType;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Random;

public class StudentHQL_test extends TestCase {
    public StudentHQL_test(String testName) {
        super(testName);
    }

    public void testInsertionOfRecords() {
        Configuration conf = new Configuration().configure("hibernate1.cfg.xml").addAnnotatedClass(Student_HQL.class);
        SessionFactory sessionFactory = conf.buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Random r = new Random();
            for (int i = 1; i <= 50; i++) {
                Student_HQL s = new Student_HQL();
                s.setRollno(i);
                s.setName("Name " + i);
                s.setMarks(r.nextInt(100));
                session.persist(s);

            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void test_query1() {
        Configuration conf = new Configuration().configure("hibernate1.cfg.xml").addAnnotatedClass(Student_HQL.class);
        SessionFactory sessionFactory = conf.buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query q = session.createQuery("Select rollno,marks from Student_HQL where rollno=7");
            Object[] result = (Object[])q.getSingleResult();
            //System.out.println(result.length); output is 2
            System.out.println(result[0]+" "+result[1]);
            Query q2 = session.createQuery("Select rollno, marks, name from Student_HQL where marks>=60");
            List<Object[]> results = (List<Object[]>) q2.getResultList();
            for(Object[] student:results){
                System.out.println(student[0]+" "+student[1]+" "+student[2]);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static junit.framework.Test suite () {
        return new TestSuite(StudentTest.class); // Explicitly add the test case
    }

}
