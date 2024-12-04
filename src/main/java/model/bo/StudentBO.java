package model.bo;

import model.bean.StudentBEAN;
import model.dao.StudentDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBO {

    StudentDAO studentDAO = new StudentDAO();

    public ArrayList<StudentBEAN> getAllStudents() throws SQLException, ClassNotFoundException {
        return studentDAO.getAllStudents();
    }
    public ArrayList<StudentBEAN> searchStudent(String field, String value) throws SQLException, ClassNotFoundException {
        if (value == null || value.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return studentDAO.searchStudent(field, value);
    }
    public void insertStudent(StudentBEAN student) throws SQLException, ClassNotFoundException {
        if (!student.isValidId() || !student.isValidName() || !student.isValidAge() || !student.isValidUniversity()) {
            throw new IllegalArgumentException("Invalid student data");
        }
        studentDAO.insertStudent(student);
    }
    public void updateStudent(StudentBEAN student) throws SQLException, ClassNotFoundException {
        if (!student.isValidId() || !student.isValidName() || !student.isValidAge() || !student.isValidUniversity()) {
            throw new IllegalArgumentException("Invalid student data");
        }
        studentDAO.updateStudent(student);
    }
    public void deleteStudent(String id) throws SQLException, ClassNotFoundException {
        studentDAO.deleteStudent(id);
    }
    public void deleteAllStudents (String[] ids) throws SQLException, ClassNotFoundException {
        studentDAO.deleteAllStudents(ids);
    }
    public StudentBEAN getStudentById(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.getStudentById(id);
    }
}