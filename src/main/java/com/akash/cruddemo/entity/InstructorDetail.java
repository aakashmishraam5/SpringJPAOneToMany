package com.akash.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
@Column(name = "id")
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(name = "youtube_channel")
private String Youtube_channel;
@Column(name="hobby")
private String hobby;
@OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
private Instructor instructor;

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", Youtube_channel='" + Youtube_channel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
    public InstructorDetail(){

    }

    public InstructorDetail(String youtube_channel, String hobby) {
        Youtube_channel = youtube_channel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutube_channel() {
        return Youtube_channel;
    }

    public void setYoutube_channel(String youtube_channel) {
        Youtube_channel = youtube_channel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
