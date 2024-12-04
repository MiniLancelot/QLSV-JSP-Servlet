<%--
  Created by IntelliJ IDEA.
  User: nhatt
  Date: 11/28/2023
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tìm kiếm sinh viên</title>
</head>
<body>
    <p style="text-align: center"><a href="javascript:history.back()">Back</a></p>
    <h2 style="text-align: center;">Tim kiem sinh vien</h2>
    <form action="StudentController" method="post">
        <table style="margin: auto;">
            <tr>
                <td style="text-align: right;"><label>Field: </label></td>
                <td>
                    <select name="field" id="field">
                        <option value="id">ID</option>
                        <option value="name">Name</option>
                        <option value="age">Age</option>
                        <option value="university">University</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;"><label>Nhập thông tin tìm kiếm: </label></td>
                <td><input type="text" name="txtSearch"></td>
            </tr>
        </table>
        <div style="text-align: center; margin-top: 10px;">
            <button type="submit" name="message" value="SearchStudent">Search</button>
        </div>
    </form>
</body>
</html>
