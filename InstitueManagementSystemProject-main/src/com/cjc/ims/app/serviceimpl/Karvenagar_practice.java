package com.cjc.ims.app.serviceimpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.cjc.ims.app.model.Batch;
import com.cjc.ims.app.model.Course;
import com.cjc.ims.app.model.Faculty;
import com.cjc.ims.app.model.Student;
import com.cjc.ims.app.servicei.CJC;
import com.config.HibernateUtil;

public class Karvenagar_practice implements CJC {
    Session session=HibernateUtil.getSessionFactory().openSession();
	
    Scanner scanner=new Scanner(System.in);
    
	@Override
	public void addCourse() throws WrongInputException {
		 Course c=new Course();
		try {
		System.out.println("Enter Course id : ");
		c.setCourseId(scanner.nextInt());
		if(c.getCourseId()<=0)
			throw new WrongInputException("Please enter non negative and non zero number");
	
		scanner.nextLine();//consume next line or it doesnt take the name input
		
		System.out.println("Enter Course Name");
		c.setCourseName(scanner.nextLine());
		if(c.getCourseName().isBlank())
			throw new WrongInputException("Name cannot be blank");
		
		session.persist(c);
		Transaction t=session.beginTransaction();
		t.commit();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Error : id cannot include characters");
			scanner.nextLine();
		}
	}

	@Override
	public void viewCourse() {
		System.out.println("This is the list of course :");
		String hql="FROM Course";
		List<Course> courses= session.createQuery(hql,Course.class).getResultList();
		for (Course course : courses) {
			System.out.println("[ Course id : "+course.getCourseId()+" Name :"+course.getCourseName()+" ]");
		}
		
	}

	@Override
	public void addFaculty() throws WrongInputException {
		Faculty f=new Faculty();
		try {
		System.out.println("Enter Faculty id : ");
		f.setFacultyId(scanner.nextInt());
        if(f.getFacultyId()<=0)
        	throw new WrongInputException("Please enter non negative and non zero number");
		
		scanner.nextLine();//consume next line after id
		
		System.out.println("Enter Faculty Name : ");
		f.setFacultyName(scanner.nextLine());
		if(f.getFacultyName().isBlank())
			throw new WrongInputException("Name cannot be blank");
		
		System.out.println("Assign a course to the faculty from the course list : ");
		viewCourse();
		System.out.println("Enter Course id : ");
		int checkcid=scanner.nextInt();
		
		Course course=session.get(Course.class, checkcid);
		if(course==null)
		{
			throw new WrongInputException("The id doesn't exist");
		}
		else {
		f.setC(course);
		}
		
		Transaction t=session.beginTransaction();
		session.persist(f);
		t.commit();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Error : id cannot include characters");
			scanner.nextLine();
		}
	}

	@Override
	public void viewFaculty() {
		System.out.println("This is Faculty List");
		String hql="FROM Faculty";
		List<Faculty> faculties=session.createQuery(hql,Faculty.class).getResultList();
		
		for (Faculty faculty : faculties) {
			System.out.println("[ Faculty id : "+faculty.getFacultyId()+" Name : "+faculty.getFacultyName()
			+" Assigned Course id :"+faculty.getC().getCourseId()+" Course Name : "+faculty.getC().getCourseName()+"]");
		}
		
	}

	@Override
	public void addBatch() throws WrongInputException {
		Batch b=new Batch();
		try {
		System.out.println("Enter batch id : ");
		b.setBatchId(scanner.nextInt());
		if(b.getBatchId()<=0)
			throw new WrongInputException("please enter non negative and non zero id");
		
		scanner.nextLine();
		
		System.out.println("Enter batch name : ");
		b.setBatchName(scanner.nextLine());
		if(b.getBatchName().isBlank())
			throw new WrongInputException("Name cannot be blank");
		
		System.out.println("Assign a Faculty to the batch from this faculty list : ");
		viewFaculty();
		System.out.println("Enter a Faculty id");
		int checkfid=scanner.nextInt();
		
		Faculty faculty = session.get(Faculty.class, checkfid);
		if(faculty==null)
		{
			throw new WrongInputException("the id doesn't exist");
		}
		else {
		b.setF(faculty);
		}
		
		Transaction t=session.beginTransaction();
		session.persist(b);
		t.commit();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Error : id cannot include characters");
		}
		
	}

	@Override
	public void viewBatch() {
		System.out.println("This is batch list : ");
		String hql="FROM Batch";
		List<Batch> batches=session.createQuery(hql,Batch.class).getResultList();
		for (Batch batch : batches) {
			System.out.println("[ Batch id : "+batch.getBatchId()+" Name : "+batch.getBatchName()
			        +" , Assigned Faculty id : "+batch.getF().getFacultyId()+" Name : "+batch.getF().getFacultyName()+"]");
		}
		
	}

	@Override
	public void addStudent() throws WrongInputException {
		Student s=new Student();
		try {
		System.out.println("Enter Student id : ");
		s.setsId(scanner.nextInt());
		if(s.getsId()<=0)
			throw new WrongInputException("Please enter non negative and non zero number");
		
		scanner.nextLine();
		
		System.out.println("Enter Student Name : ");
		s.setsName(scanner.nextLine());
		if(s.getsName().isBlank())
			throw new WrongInputException("Name cannot be blank");
		
		System.out.println("Assign a batch to the student from this batch list");
		viewBatch();
		System.out.println("Enter a batch id : ");
		int checkbid=scanner.nextInt();
		
		Batch batch=session.get(Batch.class, checkbid);
		if(batch==null)
		{
			throw new WrongInputException("The id doesn't exist");
		}
		else {
		s.setB(batch);
		}
		
		Transaction t=session.beginTransaction();
		session.persist(s);
		t.commit();
	}
	catch(InputMismatchException e)
	{
		System.out.println("Error : id cannot include characters");
	}
  }

	@Override
	public void viewStudent() {
		System.out.println("This is Student list : ");
		String hql="FROM Student";
		List<Student> students=session.createQuery(hql,Student.class).getResultList();
		for (Student student : students) {
			System.out.println("[ Student id : "+student.getsId()+" Name : "+student.getsName()+
					          " , Assigned Batch id : "+student.getB().getBatchId()+" Name : "+student.getB().getBatchName()+" ]");
		}
		
	}

}
