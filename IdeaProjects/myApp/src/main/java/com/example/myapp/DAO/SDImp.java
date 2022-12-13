package com.example.myapp.DAO;

import java.util.ArrayList;
import java.util.List;

public class SDImp implements StudentDAO {

    List<Student> students; // list is working like a DB.

    public SDImp() {
        students = new ArrayList<Student>();
        Student s1 = new Student("Murad", 0);
        Student s2 = new Student("Ismayil", 1);
        Student s3 = new Student("Nicat", 2);
        students.add(s1);
        students.add(s2);
        students.add(s3);
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudent(int r) {
        return students.get(r);
    }

    @Override
    public void updateStudent(Student student) {
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student: RollNo " + student.getRollNo() + ", has been updated in the database");
    }

    @Override
    public void deleteStudent(Student student) {
        students.remove(student.getRollNo());
        System.out.println("Student: RollNo " + student.getRollNo() + ", has been deleted from the database");
    }
}
