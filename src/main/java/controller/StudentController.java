package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.StudentBEAN;
import model.bo.StudentBO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    StudentBO studentBO = new StudentBO();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String destination = null;

        String message = request.getParameter("message").trim();

        if (message.equals("ViewStudent")) {
            ArrayList<StudentBEAN> studentList = new ArrayList<StudentBEAN>();

            try {
                studentList = (ArrayList<StudentBEAN>) studentBO.getAllStudents();
                request.setAttribute("studentList", studentList);
                destination = "/studentView.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException | IOException | ServletException e) {
                e.printStackTrace();
            }
        } else if (message.equals("InsertStudent")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String ageString = request.getParameter("age");
            String university = request.getParameter("university");
            if (id == null || name == null || ageString == null || university == null) {
                response.sendRedirect("studentInsert.jsp");
                return;
            }
            int age = 0;
            try {
                age = Integer.parseInt(ageString);
            } catch (NumberFormatException e) {
                // Handle invalid age (not a number)
                e.printStackTrace();
            }
            StudentBEAN student = new StudentBEAN(id, name, age, university);

            try {
                studentBO.insertStudent(student);
                ArrayList<StudentBEAN> studentList = (ArrayList<StudentBEAN>) studentBO.getAllStudents();
                request.setAttribute("studentList", studentList);
                destination = "/studentView.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException | IOException | ServletException e) {
                e.printStackTrace();
            }
        } else if (message.equals("UpdateStudentView")) {
            ArrayList<StudentBEAN> studentList = new ArrayList<StudentBEAN>();

            try {
                studentList = (ArrayList<StudentBEAN>) studentBO.getAllStudents();
                request.setAttribute("studentList", studentList);
                destination = "/studentUpdateView.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException | IOException | ServletException e) {
                e.printStackTrace();
            }
        } else if (message.equals("UpdateStudentForm")) {
            String id = request.getParameter("Id");
            try {
                StudentBEAN existingStudent = studentBO.getStudentById(id);

                StudentBEAN studentToUpdate = new StudentBEAN();
                studentToUpdate.setId(existingStudent.getId());
                studentToUpdate.setName(existingStudent.getName());
                studentToUpdate.setAge(existingStudent.getAge());
                studentToUpdate.setUniversity(existingStudent.getUniversity());


                request.setAttribute("studentToUpdate", studentToUpdate);
                destination = "/studentUpdateForm.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (message.equals("UpdateStudent")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String ageString = request.getParameter("age");
            String university = request.getParameter("university");

            if (id == null || name == null || ageString == null || university == null) {
                response.sendRedirect("studentUpdateForm.jsp");
                return;
            }

            int age = 0;
            try {
                age = Integer.parseInt(ageString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            StudentBEAN updatedStudent = new StudentBEAN(id, name, age, university);

            try {
                studentBO.updateStudent(updatedStudent);
                ArrayList<StudentBEAN> studentList = (ArrayList<StudentBEAN>) studentBO.getAllStudents();
                request.setAttribute("studentList", studentList);
                destination = "/studentUpdateView.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (message.equals("SearchStudent")) {
            String field = request.getParameter("field");
            String txtSearch = request.getParameter("txtSearch");
            if (txtSearch == null) {
                response.sendRedirect("studentSearch.jsp");
                return;
            }

            try {
                ArrayList<StudentBEAN> searchResult = studentBO.searchStudent(field, txtSearch);
                request.setAttribute("searchResult", searchResult);
//                request.setAttribute("field", field);
//                request.setAttribute("searchValue", txtSearch);
                destination = "/studentSearchList.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        } else if (message.equals("DeleteStudentView")) {
            ArrayList<StudentBEAN> studentList = new ArrayList<StudentBEAN>();

            try {
                studentList = (ArrayList<StudentBEAN>) studentBO.getAllStudents();
                request.setAttribute("studentList", studentList);
                destination = "/studentDeleteView.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException | IOException | ServletException e) {
                e.printStackTrace();
            }
        } else if (message.equals("DeleteStudent")) {
            String id = request.getParameter("Id");
            try {
                studentBO.deleteStudent(id);
                ArrayList<StudentBEAN> studentList = (ArrayList<StudentBEAN>) studentBO.getAllStudents();
                request.setAttribute("studentList", studentList);
                destination = "/studentDeleteView.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (message.equals("DeleteAllStudentView")) {
            ArrayList<StudentBEAN> studentList = new ArrayList<StudentBEAN>();

            try {
                studentList = (ArrayList<StudentBEAN>) studentBO.getAllStudents();
                request.setAttribute("studentList", studentList);
                destination = "/studentDeleteAll.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException | IOException | ServletException e) {
                e.printStackTrace();
            }
        } else if (message.equals("DeleteSelected")) {
            String[] ids = request.getParameterValues("selectedStudents");
            if (ids != null && ids.length > 0) {
                try {
                    studentBO.deleteAllStudents(ids);
                    ArrayList<StudentBEAN> studentList = studentBO.getAllStudents();
                    request.setAttribute("studentList", studentList);
                    destination = "/studentDeleteAll.jsp";
                    RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
                    rd.forward(request, response);

                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                ArrayList<StudentBEAN> studentList = null;
                try {
                    studentList = studentBO.getAllStudents();
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute("studentList", studentList);
                destination = "/studentDeleteAll.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(request, response);
            }
        }
    }
}