<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <title> Login Page </title>
        <style><%@include file="../css/style.css"%></style>
    </head>
<body>
<h2>Login</h2>
<br>
<form method="get" action="/get/">
    <Label>Username:</Label>
    <input name="brusername" type="text">
    <label>Password:</label>
    <input name="brpass" type="password">
    <input type="submit" value = "Submit">
</form>
