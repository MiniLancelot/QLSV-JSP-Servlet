<%@ page import="model.bean.StudentBEAN" %><%--
  Created by IntelliJ IDEA.
  User: nhatt
  Date: 11/28/2023
  Time: 9:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form cập nhật</title>
</head>
<body>
    <p style="text-align: center"><a href="javascript:history.back()">Back</a></p>
    <h2 style="text-align: center;">Cap nhat sinh vien</h2>
    <form action="StudentController" method="post">
        <input type="hidden" name="message" value="UpdateStudent">
        <div style=" justify-content: center; display: flex;">
                <% StudentBEAN student = (StudentBEAN) request.getAttribute("studentToUpdate"); %>
            <table>

                <tr><td style="text-align: right">Id: </td> <td><input type="text" name="id" value="<%= student.getId()%>" required></td></tr>
                <tr><td style="text-align: right">Name: </td> <td><input type="text" name="name"  value="<%= student.getName()%>" required></td></tr>
                <tr><td style="text-align: right">Age: </td> <td><input type="text" name="age" value="<%= student.getAge()%>" required></td></tr>
                <tr><td style="text-align: right">University: </td> <td><input type="text" name="university" value="<%= student.getUniversity()%>" required></td></tr>
                <tr>
                    <td style="text-align: right">
                        <input type="submit" value="Update">
                    </td>
                    <td>
                        <input type="reset" value="Reset">
                    </td>
                </tr>

            </table>
            <br>


    </form>
</body>
</html>
