<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Modify</title>
    <link rel="stylesheet" href="../resources/css/style.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>

</head>
<body>
<table class="one">
    <thead>
    <tr>
        <td style="text-align: center;"><big>Система управления студентами и их
            успеваемостью</big></td>
    </tr>
    </thead>
</table>
<p style="margin-left: 1250px; margin-top: -20px;">
    <a href="./logout.html">Logout</a>
</p>
<a href="./stranitsa1.html">На главную</a>
<a href="./stranitsa1.html">Назад</a>

<span style="margin-left:152px; font-family: cursive;"><big>Для модифицирования студента заполните все поля и нажмите кнопку "Применить"</big> </span>
<br>
<br>
<br>
<br>
<div class="five">
    <form action="/student-modify" method="post">
        <input type="hidden" name="id" value="${student.id}">

        <tr style="margin: 10px;"><small>Фамилия</small></tr>
        <input type="text" name="surname" value="${student.surname}">

        <tr style="margin: 10px;"><small>Имя</small></tr>
        <input type="text" name="name" value="${student.name}">

        <tr style="margin: 10px;"><small>Группа</small></tr>
        <input type="text" name="group" value="${student.group}">

        <tr style="margin: 10px;"><small>Дата поступления</small></tr>
        <input type="text" name="date" id="datepicker" value = "<fmt:formatDate pattern="dd/MM/yyyy" value="${student.date}"/>">

        <input style="font-family: cursive; border-color: dimgray; width: 140px;background-color: darkgray; margin-left: 120px; margin-top: 10px;"
               type="submit" value="Применить">
    </form>
</div>
<c:if test="${error =='1'}">
    <h4>Поля не должны быть пустыми!!!</h4>
</c:if>
</body>
</html>
