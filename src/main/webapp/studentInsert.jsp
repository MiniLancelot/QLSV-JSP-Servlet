<%--
  Created by IntelliJ IDEA.
  User: nhatt
  Date: 11/28/2023
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sinh viên</title>
</head>
<body>
    <p style="text-align: center"><a href="javascript:history.back()">Back</a></p>
    <h2 style="text-align: center;">Them sinh vien</h2>
    <form action="StudentController" method="post">
        <input type="hidden" name="message" value="InsertStudent">
        <div style=" justify-content: center; display: flex;">

            <table>

                <tr><td style="text-align: right">Id: </td> <td><input type="text" name="id"  required></td></tr>
                <tr><td style="text-align: right">Name: </td> <td><input type="text" name="name"  required></td></tr>
                <tr><td style="text-align: right">Age: </td> <td><input type="text" name="age" required></td></tr>
                <tr><td style="text-align: right">University: </td> <td><input type="text" name="university" required></td></tr>
                <tr>
                    <td style="text-align: right">
                        <input type="submit" value="Add">
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
