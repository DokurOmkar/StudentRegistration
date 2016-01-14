package com.omkar.bestbuyapi.model;

import java.io.Serializable;

/**
 * Created by omkardokur on 12/18/15.
 */

public class Student implements Serializable{
    private String studentId;
    private String studentName;
    private String studentClass;
    private String studentMarks;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(String studentMarks) {
        this.studentMarks = studentMarks;
    }
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

}
