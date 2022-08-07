<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../resources/css/style.css">
    <link rel="stylesheet" href="../resources/fonts/fonts.css">
    <link rel=" preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
            href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
            rel="stylesheet">
    <script src="../resources/js/function.js"></script>

</head>
<body>
<div class="page">
    <nav>
        <a href="/home"> На главную</a>
    </nav>
    <table class="home">
        <thead>
        <tr>
            <th align="center">Система управления студентами и их успеваемостью</th>
        </tr>
        <div class="header_login">
            <button class="header_login_button" href="./logout.html">Logout
            </button>
        </div>
        </thead>
    </table>

    <br>

    <div class="container">
        <div class="button1">
            <p>
          <input type="submit" value="Просмотреть успеваемость выбранных студентов" onclick="progressStudents()">            </p>
            <p>
           <input type="submit" value="Модифицировать выбранного студента..." onclick="modifyStudents()">
            </p>
            <p>
        </div>
        <div class="button2">
            <form action="/student-create"><input type="submit" value="Создать студента..."></form>
            </p>
            <p>
            <input type="submit" value="Удалить выбранных студентов" onclick="deleteStudents()">
            </p>
        </div>
    </div>

    <br>
    <section>
        <table class="student_list">
            <caption>Список студентов</caption>
            <tr>
                <th class="col1"></th>
                <th class="col2">Фамилия</th>
                <th class="col3">Имя</th>
                <th class="col4">Группа</th>
                <th class="col5">Дата поступления</th>
            </tr>

            <tr>
                <%--                //тянем из БД//--%>
                <c:forEach items="${students}" var="st">
            <tr>
                <td>
                    <input name="idStudent" type="checkbox" value="${st.id}">
                </td>
                <td>${st.surname} </td>
                <td>${st.name}</td>
                <td>${st.group} </td>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${st.date}"/>
                </td>
            </tr>
            </c:forEach>
        </table>
    </section>
</div>
</body>
<form action="/student-delete" method="post" id="deleteForm">
    <input type="hidden" id="deleteHidden" name="deleteHidden">
</form>
<form action="/student-modify" method="get" id="modifyForm">
    <input type="hidden" id="modifyHidden" name="modifyHidden">
</form>
<form action="/student-progress" method="get" id="progressForm">
    <input type="hidden" id="progressHidden" name="progressHidden">
</form>

</html>