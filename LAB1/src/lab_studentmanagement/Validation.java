/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_studentmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author fptshop
 */
public class Validation {
    Scanner sc = new Scanner(System.in);
    
    public int getInt(String mess, String error, int min, int max) {
        int number;
        while (true) {            
            try {
                System.out.println(mess);
                number = Integer.parseInt(sc.nextLine().trim());
                if(number < min || number > max) {
                    System.out.println(error);
                }
                else {
                    return number;
                }
            } catch (NumberFormatException numberFormatException) {

            }
        }
    }
    public String getString(String mess, String regex) {
        String input;
        while (true) {            
            System.out.println(mess);
            input = sc.nextLine().trim();
            if(input.matches(regex)) {
                return input;
            }
            else {
                System.out.println("Please enter again");
            }
        }
    }
    public String getString1(String mess, String regex) {
        String input;
        String output;
        while (true) {            
            System.out.println(mess);
            input = sc.nextLine().trim();
            if(input.matches(regex) || input.equalsIgnoreCase("")) {
                return input;
            }
            else {
                System.out.println("Please enter again");
            }
        }
    }
    public String getString2(String mess) {
        String input;
        while (true) {            
            System.out.println(mess);
            input = sc.nextLine().trim();
            if(!input.isEmpty()) {
                return input;
            }
            else {
                System.out.println("Please enter again");
            }
        }
    }
    public String getChoice(String mess, String s1, String s2) {
        String input;
        while (true) {            
            System.out.println(mess);
            input = sc.nextLine().trim();
            if(input.equalsIgnoreCase(s1) || input.equalsIgnoreCase(s2)) {
                return input;
            }
            else {
                System.out.println("Please choose "+s1+"/"+s2);
            }
        }
    }
    public String getCourse(String mess) {
        String inputCourse;
        while (true) {            
            System.out.println(mess);
            inputCourse = sc.nextLine().trim();
            if(inputCourse.equalsIgnoreCase("java") || inputCourse.equalsIgnoreCase(".net") || inputCourse.equalsIgnoreCase("c/c++"))
            {
                return inputCourse;
            } 
            else {
                System.out.println("Please enter course again");
            }
        }
    }
    public String getCourse1(String mess) {
        String inputCourse;
        while (true) {            
            System.out.println(mess);
            inputCourse = sc.nextLine().trim();
            if(inputCourse.equalsIgnoreCase("java") || inputCourse.equalsIgnoreCase(".net") || inputCourse.equalsIgnoreCase("c/c++") || inputCourse.equals(""))
            {
                return inputCourse;
            } 
            else {
                System.out.println("Please enter course again");
            }
        }
    }
    public boolean checkStudentExist(ArrayList<Student> t, String id, String studentName, String semester, String courseName) {
        for (Student s : t) {
            if(s.getId().equalsIgnoreCase(id) && s.getStudentName().equalsIgnoreCase(studentName) && s.getSemester().equalsIgnoreCase(semester) && s.getCourseName().equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }
    public boolean checkReportExist(ArrayList<Report> t, String studentName, String courseName, int totalCourse) {
        for (Report r : t) {
            if(r.getCourseName().equalsIgnoreCase(courseName) && r.getStudentName().equalsIgnoreCase(studentName) && r.getTotalCourse() == totalCourse) {
                return true;
            }
        }
        return false;
    }
    public boolean checkIdExist(ArrayList<Student> t, String id, String name) {
        for (Student s : t) {
            if(s.getId().equalsIgnoreCase(id) && !s.getStudentName().equalsIgnoreCase(name)) {
                return true;
            } 
        }
        return false;
    }
    public boolean checkChangeInformation(Student s, String id, String studentName, String semester, String courseName) {
        if(s.getId().equalsIgnoreCase(id) && s.getStudentName().equalsIgnoreCase(studentName) && s.getSemester().equalsIgnoreCase(semester) && s.getCourseName().equalsIgnoreCase(courseName)) {
            return false;
        }
        return true;
    }
}
