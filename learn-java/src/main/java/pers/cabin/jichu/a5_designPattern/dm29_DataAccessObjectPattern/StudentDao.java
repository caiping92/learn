package pers.cabin.jichu.a5_designPattern.dm29_DataAccessObjectPattern;

import java.util.List;

/**
 * Created by caiping on 2017/3/3.
 */
public interface StudentDao {
    public List<Student> getAllStudents();

    public Student getStudent(int rollNo);

    public void updateStudent(Student student);

    public void deleteStudent(Student student);
}
