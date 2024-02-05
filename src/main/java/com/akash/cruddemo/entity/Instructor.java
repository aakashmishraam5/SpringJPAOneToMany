package com.akash.cruddemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="instructor")
public class Instructor {
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(name = "first_name")
    private String FirstName;
@Column(name="last_name")
    private String LastName;
@Column(name="email")
    private String Email;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;
@OneToMany(mappedBy = "instructor",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
private List<Course> courses;

    public Instructor(String firstName, String lastName, String email) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
    }
    public Instructor(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }

    //add convinience method for bidirectional relation
    public void add(Course tempcourse){

        if(courses==null){
            courses=new ArrayList<>();
        }
        courses.add(tempcourse);
        tempcourse.setInstructor(this);
    }
}
