<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Creating</title>
    <link rel="stylesheet" href="../resources/css/style.css">
    <link rel="stylesheet" href="../resources/fonts/fonts.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker();
        });
    </script>
</head>

<body>
<div class="page">
    <nav>
        <a href="/home"> На главную</a>
        <a href="/students"> Назад</a>
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
    <br>

    <input type="hidden" name="idStudent" value="${student.id}">
    <thead>
    <table class="student_list">
        <caption>Отображена успеваемость для следующего студента</caption>
        <tr>
            <th class="colpr1">Фамилия</th>
            <th class="colpr2">Имя</th>
            <th class="colpr3">Группа</th>
            <th class="colpr4">Дата поступления</th>
        </tr>
        <tr>
            <td>${student.surname} </td>
            <td>${student.name}</td>
            <td>${student.group} </td>
            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${student.date}"/></td>
        </tr>
        </thead>
    </table>
    <%--    <br>--%>
    <%--    <br>--%>
    <br>
    <div class="student_progress_discipline">
        <%--        <thead>--%>
        <section>
            <table class="student_list_discipline">
                <caption>Список студентов</caption>
                <tr>
                    <th class="coldis1">Дисциплина</th>
                    <th class="coldis2">Оценка</th>
                </tr>
                <tr>
                    <td>Информатика</td>
                    <td>5</td>
                </tr>
                <tr>
                    <td>Системный анализ</td>
                    <td>4</td>
                </tr>
                <tr>
                    <td>Управления проектами</td>
                    <td>5</td>
                </tr>
                <tr>
                    <td>Основы Дискретной Математики</td>
                    <td>4</td>
                </tr>
            </table>
        </section>
            <div class="student_progress_terms">
                <p><strong>Выбрать семестр</strong></p>
                <select name="select">
                    <c:forEach items="${terms}" var="t">
                        <c:choose>
                            <c:when test="${t.id eq selectedTerm.id}">
                                <option selected value="value1">${t.term}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="value2">${t.term}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                <br>
                <div>
                    <form action="">
                        <input type="submit" value="Выбрать">
                    </form>
                </div>

                    <p>
                        <b>Средняя оценка за семестр: 4.8 балла</b>
                    </p>

            </div>
    </div>
    <%--        </thead>--%>
    <%--        <div class="student_progress_terms">--%>
    <%--            <p><strong>Выбрать семестр</strong></p>--%>
    <%--            <select name="select">--%>
    <%--                <c:forEach items="${terms}" var="t">--%>
    <%--                    <c:choose>--%>
    <%--                        <c:when test="${t.id eq selectedTerm.id}">--%>
    <%--                            <option selected value="value1">${t.term}</option>--%>
    <%--                        </c:when>--%>
    <%--                        <c:otherwise>--%>
    <%--                            <option value="value2">${t.term}</option>--%>
    <%--                        </c:otherwise>--%>
    <%--                    </c:choose>--%>
    <%--                </c:forEach>--%>
    <%--            </select>--%>
    <%--            <div>--%>
    <%--                <form action="">--%>
    <%--                    <input type="submit" value="Выбрать">--%>
    <%--                </form>--%>
    <%--            </div>--%>
    <%--            <p>--%>
    <%--                <b>Средняя оценка за семестр: 4.8 балла</b>--%>
    <%--            </p>--%>
    <%--        </div>--%>
</div>
</thead>

</div>
</body>
</html>