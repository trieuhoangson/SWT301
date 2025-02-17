/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_studentmanagement;

/**
 *
 * @author fptshop
 */
public class Report {
    private String studentName;
    private String courseName;
    private int _totalCourse;

    public Report(String studentName, String courseName, int _totalCourse) {
        this.studentName = studentName;
        this.courseName = courseName;
        this._totalCourse = _totalCourse;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourse() {
        return _totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this._totalCourse = totalCourse;
    }
    
}
