<%--
  Created by IntelliJ IDEA.
  User: hamza bettaibi
  Date: 5/22/2025
  Time: 5:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajout</title>
</head>
<body>
<form action="ajout" method="get">
    <input type="text" name="title" placeholder="Enter task title" required>
    <input type="text" name="description" placeholder="Enter task description">
    <input type="date" name="deadline" placeholder="Set deadline">
    <input type="submit" value="Add Task">
</form>
</body>
</html>
