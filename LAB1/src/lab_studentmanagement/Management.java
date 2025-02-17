/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_studentmanagement;

import java.util.*;

/**
 *
 * @author fptshop
 */
public class Management {
    Validation validation = new Validation();
    public void printMenu() {
        System.out.println("1.   Create");
        System.out.println("2.   Find/Sort");
        System.out.println("3.   Update/Delete");
        System.out.println("4.   Report");
        System.out.println("5.   Exit");
    }
    public void create(ArrayList<Student> t) {
        if(t.size() > 10) {
            String choice = validation.getChoice("Do you want to continue(Y/N)?", "y", "n");
            if(choice.equalsIgnoreCase("n")) return;
        }
        while (true) {            
            String id = validation.getString("ID: ","[A-Za-z0-9]+");
            String studentName = validation.getString("Student name: ","[A-Za-z]+\\s*[A-Za-z]+\\s*[A-Za-z]+\\s*[A-Za-z]+");
            if(validation.checkIdExist(t, id, studentName)) {
                System.out.println("exist this ID!");
                continue;
            }
            String semester = validation.getString("Semester: ","[A-Za-z]+\\s*[A-Za-z]+");
            String courseName = validation.getCourse("CourseName: ");
            if(!validation.checkStudentExist(t, id, studentName, semester, courseName)) {
                t.add(new Student(id, studentName, semester, courseName));
                System.out.println("Add successfully");
                return;
            }
            else {
                System.out.println("Dupplicated");
            }
        }
    }
    public ArrayList<Student> listFindByName(ArrayList<Student> t) {
        ArrayList<Student> list = new ArrayList<>();
        //String name = validation.getString("Enter a name: ","[A-Za-z]+\\s*[A-Za-z]+\\s*[A-Za-z]+\\s*[A-Za-z]+");
        String name = validation.getString2("Enter character: ");

        for (Student s : t) {
            if(s.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                list.add(s);
            }
        }
        return list;
    }
    public void findAndSort(ArrayList<Student> t) {
        if(t.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        else {
            ArrayList<Student> list = listFindByName(t);
            if(list.isEmpty()) {
                System.out.println("No student has this name");
                return;
            }
            else {
                Collections.sort(list, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.getStudentName().compareToIgnoreCase(o2.getStudentName());
                    }
                });
                System.out.printf("%-15s%-15s%-15s\n", "Student name","Semester","Course name");
                for (Student s : list) {
                    s.print();
                }
            }
        }
    }

    public ArrayList<Student> getListStudentById( Set<Student> ls, String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }
    public void updateOrDelete(ArrayList<Student> t) {
        String id = validation.getString("enter id:","[A-Za-z0-9]+");
        for (Student s : t) {
            if(s.getId().equalsIgnoreCase(id)) {
                s.print();
                String choice1 = validation.getChoice("Do you want to edit this data? (y/n)", "y", "n");
                if(choice1.equalsIgnoreCase("y")) {
                String choice = validation.getChoice("Do you want to update (U) or delete (D) student?","u","d");
                if(choice.equalsIgnoreCase("u")) {
                    String studentID = validation.getString1("Enter student ID: ","[A-Za-z0-9]+");
                    String studentName = validation.getString1("Enter student name: ","[A-Za-z]+\\s*[A-Za-z]+\\s*[A-Za-z]+\\s*[A-Za-z]+");
                    String semester = validation.getString1("Enter semester: ","[A-Za-z]+\\s*[A-Za-z]+");
                    String courseName = validation.getCourse1("Enter course name: ");
                    if(!validation.checkChangeInformation(s, studentID, studentName, semester, courseName)) {
                        System.out.println("Nothing change.");
                    }
                    else {
                        if(!studentID.equals("")) {
                            for (Student s1 : t) {
                                if(s1.getId().equalsIgnoreCase(id)) {
                                    s1.setId(studentID);
                                }
                            }
                        }
                        if(!studentName.equals("")) {
                            s.setStudentName(studentName);
                            for (Student s1 : t) {
                                if(s1.getId().equalsIgnoreCase(s.getId())) {
                                    s1.setStudentName(studentName);
                                }
                            }
                        }
                        if(!semester.equals("")) s.setSemester(semester);
                        if(!courseName.equals(""))s.setCourseName(courseName);
                        System.out.println("Update successfully");
                    }
                }
                else {
                    ArrayList<Student> listFindById = getListStudentById(t, id);
                    for (Student student : listFindById) {
                        t.remove(student);
                        //break;
                    }
                    System.out.println("Delete successfully");
                    break;
                }
                }
                else {
                    continue;
                }
            }
        }
    }
    public void report(ArrayList<Student> t) {
        if(t.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        ArrayList<Report> list = new ArrayList<>();
        for (int i = 0; i < t.size(); i++) {
            //int total = 0;
            for (Student s : t) {
                String id = s.getId();
                String courseName = s.getCourseName();
                String studentName = s.getStudentName();
                int total = 0;
                for (Student s1 : t) {
                    if(id.equalsIgnoreCase(s1.getId()) && courseName.equalsIgnoreCase(s1.getCourseName())) {
                        total++;
                    }
                }
                if(!validation.checkReportExist(list, studentName, courseName, total)) {
                    list.add(new Report(studentName, courseName, total));
                }
            }
        }
        for (Report r : list) {
            System.out.printf("%-20s|%-10s|%-5d\n", r.getStudentName(),r.getCourseName(),r.getTotalCourse());
        }
    }
}
