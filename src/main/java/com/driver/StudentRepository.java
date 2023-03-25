package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
  HashMap<String,Student> students = new HashMap<>();
    HashMap<String,Teacher> teachers = new HashMap<>();
    HashMap<String, List<String>> teacherStudent = new HashMap<>();

    public void addStudent(Student student){
        students.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher){
        teachers.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String studentName, String teacherName){
        List<String> studentsForTeacher = teacherStudent.getOrDefault(teacherName, new ArrayList<>());

        studentsForTeacher.add(studentName);
        teacherStudent.put(teacherName, studentsForTeacher);
        //getting Student from hashmap by key and setting the teachername
        students.get(studentName).setTeacherName(teacherName);
    }
    public Student getStudentByName(String name) {
        return students.get(name);
    }
    public Teacher getTeacherByName(String name) {
        return teachers.get(name);
    }
    public List<String> getStudentByTeacherName(String teacher){
        return teacherStudent.get(teacher);
    }

    public List<String> getAllStudent(){
        return new ArrayList<>(students.keySet());
    }

    public void deleteTeacherByName(String teacherName) {
        Teacher teacher = teachers.remove(teacherName);
        if (teacher != null) {
            List<String> studentsForTeacher = teacherStudent.remove(teacherName);
            for (String studentName : studentsForTeacher) {
                students.remove(studentName);
            }
        }
    }

    public void deleteAll(){
        teachers.clear();
        students.clear();
        teacherStudent.clear();
    }

}
