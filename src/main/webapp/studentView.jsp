<%@ page import="model.bean.StudentBEAN" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: nhatt
  Date: 11/28/2023
  Time: 9:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sinh viên</title>
    <style>
         td{
            text-align: center;
        }
    </style>
</head>
<body>
    <a href="javascript:history.back()">Back</a>
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

        </tr>
        <%}%>
    </table>
</body>
</html>
