package com.example.myapp.DAO;

public class DPDemo {
    public static void main(String[] args) {
        StudentDAO studentDAO = new SDImp();

        for (Student student:
                studentDAO.getAllStudents()) {
            System.out.println("Student [RollNo: " + student.getRollNo() + ", Name: " + student.getName() + " ]");
        }

        Student student = studentDAO.getAllStudents().get(0);
        student.setName("RAFIQ");
        studentDAO.updateStudent(student);

        studentDAO.getStudent(0);
        System.out.println("Student [RollNo: " + student.getRollNo() + ", Name: " + student.getName() + " ]");
    }
}
