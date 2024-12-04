<%@ page import="model.bean.StudentBEAN" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: nhatt
  Date: 11/28/2023
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xoá sinh viên</title>
    <style>
        td{
            text-align: center;
        }
    </style>
</head>
<body>
    <a href="index.jsp">Back</a>
    <h2 style="text-align: center;">Danh sach sinh vien</h2>
    <table border="1" width="100%">

        <tr>
            <th>ID</th><th>Name</th><th>Age</th><th>University</th>


        </tr>

        <%
            ArrayList<StudentBEAN> StudentList = (ArrayList<StudentBEAN>) request.getAttribute("studentList");
            for(int i=0; i<StudentList.size(); i++){

        %>

        <tr>

            <td><%= StudentList.get(i).getId() %></td>
            <td><%= StudentList.get(i).getName() %></td>
            <td><%= StudentList.get(i).getAge() %></td>
            <td><%= StudentList.get(i).getUniversity() %></td>
            <td><a href="StudentController?message=DeleteStudent&Id=<%= StudentList.get(i).getId() %>">xxx</a></td>
        </tr>
        <%}%>
    </table>
</body>
</html>
