package com.cjc.ims.app.serviceimpl;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.cjc.ims.app.model.Course;
import com.cjc.ims.app.model.Faculty;
import com.cjc.ims.app.model.Batch;
import com.cjc.ims.app.model.Student;
import com.cjc.ims.app.servicei.CJC;
import com.config.HibernateUtil;

public class Karvenagar implements CJC {
    
    // Open a session from HibernateUtil
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    Scanner sc = new Scanner(System.in);

    @Override
    public void addCourse() throws WrongInputException {
        Course c = new Course();
        Transaction transaction = null;
        try {
            System.out.println("Enter Course id : ");
            c.setCourseId(sc.nextInt());

            if (c.getCourseId() <= 0) {
                throw new WrongInputException("Please enter non-negative and non-zero value");
            }

            sc.nextLine(); // clear the new line
            System.out.println("Enter Course name : ");
            c.setCourseName(sc.nextLine());
            if (c.getCourseName().isBlank()) {
                throw new WrongInputException("The name cannot be empty ");
            }

            // Start a transaction
            transaction = session.beginTransaction();
            session.persist(c); // Persist the course
            transaction.commit(); // Commit the transaction

        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback in case of error
            e.printStackTrace();
        }
    }

    @Override
    public void viewCourse() {
        System.out.println("The course details are below : ");
        try {
            // Query to fetch all courses from the database
            List<Course> courses = session.createQuery("FROM Course", Course.class).list();
            for (Course course : courses) {
                System.out.println("[ id : " + course.getCourseId() + " , name : " + course.getCourseName() + " ]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addFaculty() throws WrongInputException {
        Faculty f = new Faculty();
        Transaction transaction = null;
        try {
            System.out.println("Enter faculty id : ");
            f.setFacultyId(sc.nextInt());
            if (f.getFacultyId() <= 0) {
                throw new WrongInputException("Please enter non-negative and non-zero value");
            }

            sc.nextLine(); // clear the new line
            System.out.println("Enter faculty name : ");
            f.setFacultyName(sc.nextLine());
            if (f.getFacultyName().isBlank()) {
                throw new WrongInputException("The name cannot be empty ");
            }

            // Assign a course to the faculty by checking the course ID in the database
            System.out.println("Assign a course to the faculty from below list :");
            viewCourse(); // View available courses

            System.out.println("Enter a course id from the above list : ");
            int checkcid = sc.nextInt();

            // Query the database to check if the entered courseId exists
            Course course = session.get(Course.class, checkcid); // Use the session to get the Course by ID

            if (course == null) {
                throw new WrongInputException("The course id doesn't exist in the database");
            } else {
                f.setC(course); // Assign the course to the faculty
            }

            // Start a transaction to save the faculty
            transaction = session.beginTransaction();
            session.persist(f); // Persist the faculty
            transaction.commit(); // Commit the transaction

        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback in case of error
            e.printStackTrace();
        }
    }

    @Override
    public void viewFaculty() {
        System.out.println("The faculty details are below : ");
        try {
            // Query to fetch all faculties from the database
            List<Faculty> faculties = session.createQuery("FROM Faculty", Faculty.class).list();
            for (Faculty faculty : faculties) {
                System.out.println("[ Id : " + faculty.getFacultyId() + " , Name : " + faculty.getFacultyName()
                        + " , Assigned Course Id , Name : " + faculty.getC().getCourseId() + " " + faculty.getC().getCourseName()
                        + " ]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBatch() throws WrongInputException {
        Batch b = new Batch();
        Transaction transaction = null;
        try {
            System.out.println("Enter batch id : ");
            b.setBatchId(sc.nextInt());
            if (b.getBatchId() <= 0) {
                throw new WrongInputException("Please enter non-negative and non-zero value");
            }

            sc.nextLine();
            System.out.println("Enter batch name : ");
            b.setBatchName(sc.nextLine());
            if (b.getBatchName().isBlank()) {
                throw new WrongInputException("The name cannot be empty ");
            }

            // Assign a faculty to the batch by checking if the faculty ID exists in the database
            System.out.println("Assign a faculty to the batch from below list : ");
            viewFaculty(); // View available faculty members

            System.out.println("Enter a faculty id from the above list : ");
            int checkfid = sc.nextInt();

            // Query the database to check if the entered facultyId exists
            Faculty faculty = session.get(Faculty.class, checkfid); // Use the session to get the Faculty by ID

            if (faculty == null) {
                throw new WrongInputException("The faculty id doesn't exist in the database");
            } else {
                b.setF(faculty); // Assign the faculty to the batch
            }

            // Start a transaction to save the batch
            transaction = session.beginTransaction();
            session.persist(b); // Persist the batch
            transaction.commit(); // Commit the transaction

        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback in case of error
            e.printStackTrace();
        }
    }

    @Override
    public void viewBatch() {
        System.out.println("The Batch details are below : ");
        try {
            // Query to fetch all batches from the database
            List<Batch> batches = session.createQuery("FROM Batch", Batch.class).list();
            for (Batch batch : batches) {
                System.out.println("[ Id : " + batch.getBatchId() + " , Name : " + batch.getBatchName() + " , Assigned faculty Id , Name :"
                        + batch.getF().getFacultyId() + " " + batch.getF().getFacultyName() + " ]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addStudent() throws WrongInputException {
        Student s = new Student();
        Transaction transaction = null;
        try {
            System.out.println("Enter student id : ");
            s.setsId(sc.nextInt());
            if (s.getsId() <= 0) {
                throw new WrongInputException("Please enter non-negative and non-zero value ");
            }

            sc.nextLine();
            System.out.println("Enter student name : ");
            s.setsName(sc.nextLine());
            if (s.getsName().isBlank()) {
                throw new WrongInputException("The name cannot be empty ");
            }

            // Assign a batch to the student by checking if the batch ID exists in the database
            System.out.println("Assign a batch to the student from below list : ");
            viewBatch(); // View available batches

            System.out.println("Enter a batch id from the above list : ");
            int checkbid = sc.nextInt();

            // Query the database to check if the entered batchId exists
            Batch batch = session.get(Batch.class, checkbid); // Use the session to get the Batch by ID

            if (batch == null) {
                throw new WrongInputException("The batch id doesn't exist in the database");
            } else {
                s.setB(batch); // Assign the batch to the student
            }

            // Start a transaction to save the student
            transaction = session.beginTransaction();
            session.persist(s); // Persist the student
            transaction.commit(); // Commit the transaction

        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback in case of error
            e.printStackTrace();
        }
    }

    @Override
    public void viewStudent() {
        System.out.println("The student details are below : ");
        try {
            // Query to fetch all students from the database
            List<Student> students = session.createQuery("FROM Student", Student.class).list();
            for (Student student : students) {
                System.out.println("[ Id : " + student.getsId() + " , Name : " + student.getsName() + " , Assigned batch Id , Name : "
                        + student.getB().getBatchId() + " " + student.getB().getBatchName() + " ]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
