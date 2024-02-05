package com.akash.cruddemo;

import com.akash.cruddemo.dao.AppDao;
import com.akash.cruddemo.dao.AppDaoImpl;
import com.akash.cruddemo.entity.Course;
import com.akash.cruddemo.entity.Instructor;
import com.akash.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@SpringBootApplication
public class CruddemoApplication {
	private  final Logger log= LogManager.getLogger(CruddemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
		//System.out.println("Main method");
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner ->{

			//createInstructor(appDao);
			//createInstructorDetail(appDao);
			//deleteInstructor(appDao);
			//findInstructor(appDao);
			//findInstructorDetail(appDao);
			//deleteInstructorDetailById(appDao);
			//createInstructorwithCourse(appDao);
			//findInstructorWithCourses(appDao);
			//findCoursesForInstructor(appDao);
			//findInstructorWithCoursesJoinFetch(appDao);
			//updateInstructorDetail(appDao);
			//updateCourse(appDao);
			//deleteInstructor(appDao);
			//deleteCourse(appDao);

		};
	}

	private void deleteCourse(AppDao appDao) {
		int id=10;
		System.out.println("deleting the course with id " + id);

		appDao.deleteCourse(id);
		System.out.println("done");

	}

	private void updateCourse(AppDao appDao) {
		int id=10;
		System.out.println("updating the course for :id " +id );
		Course course=appDao.findCourseById(id);
		course.setTitle("stupid-guide");
		appDao.updateCourse(course);
		System.out.println("course title updated " );
		System.out.println("done");


	}

	private void updateInstructorDetail(AppDao appDao) {
		int id=1;
		System.out.println("updating the instructor with id  " + id);
		Instructor instructor=appDao.findInstructor(id);
		System.out.println("updating the data for instructor");
		instructor.setLastName("Dog");
		appDao.updateInstructor(instructor);
		System.out.println("new name is " + instructor.getLastName());
		System.out.println("done");
	}

	private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
		int id=1;
		System.out.println("Finding the instructor " + id);
		Instructor instructor=appDao.findInstructorByIdJoinFetch(id);
		System.out.println("instructor " + id);
		System.out.println("courses " +instructor.getCourses());
		System.out.println("instructorDetails " +instructor.getInstructorDetail());
		System.out.println("Done");
		log.info("result");
	}

	private void findCoursesForInstructor(AppDao appDao) {
		int theId=1;
		System.out.println("finding the instructor " +theId);
		Instructor instructor=appDao.findInstructor(theId);
		System.out.println("instructor is " +instructor);
		//find courses
		System.out.println("finding courses for id " + theId);
		List<Course> courseList=appDao.findCoursesById(theId);
		instructor.setCourses(courseList);
		System.out.println("the associated course " +instructor.getCourses());
		System.out.println("done");
	}

	private void findInstructorWithCourses(AppDao appDao) {
		int theId=1;
		System.out.println("finding the instructor " +theId);
		Instructor instructor=appDao.findInstructor(theId);
		System.out.println("instructor is " +instructor);
		System.out.println("courses are " +instructor.getCourses());
		System.out.println("done");
	}


	private void createInstructorwithCourse(AppDao appDao) {
		InstructorDetail instructorDetail = new InstructorDetail("helloabc.youtube.com","code");
		Instructor instructor=new Instructor("hello","abc","helloabc@gmail.com");
		instructor.setInstructorDetail(instructorDetail);

		//create courses
		Course course1=new Course("Guitar-guide");
		Course course2=new Course("coding-guide");
		//Course course3=new Course("football-guide");
		//Course course4=new Course("cricket-guide");
		instructor.add(course1);
		instructor.add(course2);
		System.out.println("saving instructor"+instructor);
		System.out.println("courses" + instructor.getCourses());
		appDao.save(instructor);
		System.out.println("done!");

	}

	private void deleteInstructorDetailById(AppDao appDao) {
		int id=5;
		System.out.println("id to be removed" + id);
		appDao.deleteInstructorDetail(id);
		System.out.println("deleted");
	}

	private void findInstructorDetail(AppDao appDao) {
		int id=5;
		InstructorDetail instructorDetail=appDao.findInstructorDetail(id);
		System.out.println("InstructorDetails" +id);
		//System.out.println(instructorDetail);
		System.out.println("Instructor" + instructorDetail.getInstructor());
		System.out.println("done");
	}

	private void createInstructorDetail(AppDao appDao) {
		InstructorDetail instructorDetail = new InstructorDetail("arpibala.youtube.com","jokes");
		Instructor instructor=new Instructor("Arpit","Bala","abc@gmail.com");
		instructorDetail.setInstructor(instructor);
		System.out.println("InstructorDetails" + instructorDetail);

	}

	private void deleteInstructor(AppDao appDao) {
		int id=1;
		System.out.println("to be deleted row is " + id);
		appDao.delete(id);
		System.out.println("done");
	}

	private void findInstructor(AppDao appDao) {
		int id=2;
		System.out.println("finding instructor with id "+ id);
		Instructor tempInstructor=appDao.findInstructor(id);
		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDao appDao) {

		//Instructor tempInstructor=new Instructor("Akash","Mishra","aakashmishraam5@gmail.com");
		//InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.start.spring.io","playing games");

		Instructor tempInstructor=new Instructor("Disha","Dutta","dishadumbo@gmail.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.start.spring.io","eating");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("saving instructor:" +tempInstructor);
		appDao.save(tempInstructor);


	}

}
