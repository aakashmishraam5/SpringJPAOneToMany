package com.akash.cruddemo.dao;

import com.akash.cruddemo.entity.Course;
import com.akash.cruddemo.entity.Instructor;
import com.akash.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDao {

    void save(Instructor theInstructor);
    void save(InstructorDetail instructorDetail);

    void delete(int id);
    Instructor findInstructor(int id);

    InstructorDetail findInstructorDetail(int id);

    void deleteInstructorDetail(int id);

    List<Course> findCoursesById(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void updateInstructor(Instructor instructor);

    void updateCourse(Course course);
    Course findCourseById(int id);

    void deleteCourse(int id);

}
