package pers.cabin.jichu.a5_designPattern.dm26_ModelViewControllerPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class StudentView {
    public void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}
