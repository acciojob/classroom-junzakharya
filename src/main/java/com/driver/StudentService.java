package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String studentName, String teacherName){
        studentRepository.addStudentTeacherPair(studentName, teacherName);
    }

    public Student getStudentByName(String name){
        return studentRepository.getStudentByName(name);
    }

    public Teacher getTeacherByName(String name){
        return studentRepository.getTeacherByName(name);
    }

    public List<String> getStudentByTeacherName(String teacher){
        return studentRepository.getStudentByTeacherName(teacher);
    }

    public List<String> getAllStudent(){
        return studentRepository.getAllStudent();
    }

    public void deleteTeacherByName(String teacherName){
        studentRepository.deleteTeacherByName(teacherName);
    }

    public void deleteAll(){
        studentRepository.deleteAll();
    }
}
