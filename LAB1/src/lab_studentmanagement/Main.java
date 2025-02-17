/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_studentmanagement;

import java.util.ArrayList;

/**
 *
 * @author fptshop
 */
public class Main {
    //hehehe
    //hiep
    public static void main(String[] args) {
        ArrayList<Student> ls = new ArrayList<>();
        Management management = new Management();
        Validation validation = new Validation();
        int number;
        //ls.add(new Student("1", "Pham Ngoc Hoa", "Spring", "java"));
        ls.add(new Student("2", "Do Quang Hiep", "Summer", ".net"));
        ls.add(new Student("3", "Nguyen Xuan Cuong", "Spring", "c/c++"));
        //loop until user want to exit program
        while (true) {
            //Show menu option
            management.printMenu();
            int choice = validation.getInt("Choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program", "Choose 1 to 5", 1, 5);
            switch (choice) {
                case 1:
                    management.create(ls);
                    break;
                case 2:
                    management.findAndSort(ls);
                    break;
                case 3:
                    management.updateOrDelete(ls);
                    break;
                case 4:
                    management.report(ls);
                    break;
                case 5:
                    return;
            }
        }
    }
}