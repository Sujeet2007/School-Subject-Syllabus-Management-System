package com.examly.springapp.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long enrollmentId;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    private LocalDate enrollmentDate;

    //Constructor
    public Enrollment()
    {

    }

    

    public Enrollment(Course course, Student student, LocalDate enrollmentDate) {
        this.course = course;
        this.student = student;
        this.enrollmentDate = enrollmentDate;
    }



    //getter and setter
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }



    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }



    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }



    public long getEnrollmentId() {
        return enrollmentId;
    }



    public void setEnrollmentId(long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }  

    

}
