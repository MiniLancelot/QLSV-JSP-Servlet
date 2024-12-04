package model.dao;
import model.bean.StudentBEAN;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    public  ArrayList<StudentBEAN> getAllStudents() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu", "root", "09062003");
        String sql = "SELECT * FROM sinhvien";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        ArrayList<StudentBEAN> students = new ArrayList<StudentBEAN>();
        while (resultSet.next()){
            StudentBEAN student = new StudentBEAN();
            student.setId(resultSet.getString(1));
            student.setName(resultSet.getString(2));
            student.setAge(resultSet.getInt(3));
            student.setUniversity(resultSet.getString(4));
            students.add(student);
        }
        return students;
    }
    public void insertStudent(StudentBEAN student) throws ClassNotFoundException, SQLException {
        if (!student.isValidId() || !student.isValidName() || !student.isValidAge() || !student.isValidUniversity()) {
            // Handle validation error, throw an exception, or return an error message
            throw new IllegalArgumentException("Invalid student data");
        }

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu", "root", "09062003");
        String sql = "INSERT INTO sinhvien VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setString(1,student.getId());
        statement.setString(2,student.getName());
        statement.setInt(3,student.getAge());
        statement.setString(4,student.getUniversity());

        statement.executeUpdate();
        statement.close();
        conn.close();
    }

    public StudentBEAN getStudentById(String id) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu", "root", "09062003");
        String sql = "SELECT * FROM sinhvien WHERE Id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            StudentBEAN student = new StudentBEAN();
            student.setId(resultSet.getString(1));
            student.setName(resultSet.getString(2));
            student.setAge(resultSet.getInt(3));
            student.setUniversity(resultSet.getString(4));
            return student;
        }
        return null;
    }

    public void updateStudent(StudentBEAN student) throws ClassNotFoundException, SQLException{
        if (!student.isValidId() || !student.isValidName() || !student.isValidAge() || !student.isValidUniversity()) {
            throw new IllegalArgumentException("Invalid student data");
        }
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu", "root", "09062003");
        String sql = "UPDATE sinhvien SET name=?, age=?, university=? WHERE id=?";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setString(1, student.getName());
        statement.setInt(2, student.getAge());
        statement.setString(3, student.getUniversity());
        statement.setString(4, student.getId());

        statement.executeUpdate();
        statement.close();
        conn.close();
    }
    public  ArrayList<StudentBEAN> searchStudent(String field, String value) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu", "root", "09062003");
        String sql = "SELECT * FROM sinhvien WHERE " + field + " LIKE ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "%" + value + "%");
        ResultSet resultSet = statement.executeQuery();

        ArrayList<StudentBEAN> searchResult = new ArrayList<StudentBEAN>();
        while (resultSet.next()){
            StudentBEAN student = new StudentBEAN();
            student.setId(resultSet.getString("id"));
            student.setName(resultSet.getString("name"));
            student.setAge(resultSet.getInt("age"));
            student.setUniversity(resultSet.getString("university"));
            searchResult.add(student);
        }
        return searchResult;
    }

    public void deleteStudent(String id) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu", "root", "09062003");
        String sql = "DELETE FROM sinhvien WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, id);
        statement.executeUpdate();
        statement.close();
        conn.close();
    }

    public void deleteAllStudents(String[] ids) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu", "root", "09062003");
        String sql = "DELETE FROM sinhvien WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        for (String id : ids){
            statement.setString(1,id);
            statement.executeUpdate();
        }
    }
}