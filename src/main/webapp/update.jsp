<%--
  Created by IntelliJ IDEA.
  User: hamza bettaibi
  Date: 5/22/2025
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="update" method="post">
    <input type="text" name="title" placeholder="Enter task title" required>
    <input type="text" name="description" placeholder="Enter task description">
    <input type="date" name="deadline" placeholder="Set deadline">
    <input type="hidden" name="id" value="${param.id}">
    <input type="submit" value="Update">
</form>
</body>
</html>
