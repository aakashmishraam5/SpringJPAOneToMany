package com.akash.cruddemo.dao;

import com.akash.cruddemo.entity.Course;
import com.akash.cruddemo.entity.Instructor;
import com.akash.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao{

    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }
@Transactional
    @Override
    public void save(InstructorDetail instructorDetail) {
        entityManager.persist(instructorDetail);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Instructor tempInstructor=entityManager.find(Instructor.class,id);

        List<Course> courses=tempInstructor.getCourses();

        for (Course tempCourse:courses){
            tempCourse.setInstructor(null);
        }
        entityManager.remove(tempInstructor);


    }

    @Override

    public Instructor findInstructor(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    public InstructorDetail findInstructorDetail(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetail(int id) {
        InstructorDetail instructorDetail= entityManager.find(InstructorDetail.class,id);

        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesById(int id) {

        //create query
        TypedQuery<Course> query=entityManager.createQuery
                                              ("from Course where instructor.id=:data",Course.class );
        query.setParameter("data",id);
        //execute the query
        List<Course> courses=query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        //create query
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i" +
                        " JOIN FETCH i.courses" +
                        " JOIN FETCH i.instructorDetail" +
                        " where i.id = :data", Instructor.class);
        query.setParameter("data",id);
        Instructor instructor=query.getSingleResult();


        return instructor;
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);

    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        Course course=entityManager.find(Course.class,id);
        entityManager.remove(course);
    }


}
