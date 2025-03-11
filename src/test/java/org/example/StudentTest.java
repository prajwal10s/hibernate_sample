package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentTest extends TestCase {
    public StudentTest(String testName) {
        super(testName); // Required constructor for JUnit 3
    }
    public void test_insert_student_record(){
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        StudentName studentName = new StudentName();
        studentName.setFname("Jai");
        studentName.setMname("Deepak");
        studentName.setLname("Verma");
        Student st = new Student();
        st.setStudentName(studentName);
        st.setId(101);
        st.setRollNo("17BCE0011");
        try (Session session = sf.openSession()){
            session.beginTransaction();
            session.persist(st);
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static junit.framework.Test suite() {
        return new TestSuite(StudentTest.class); // Explicitly add the test case
    }
}
