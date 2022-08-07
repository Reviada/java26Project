package controllers;

import database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "StudentsCreatController", urlPatterns = "/student-create")
public class StudentsCreatController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("JSP/student-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String dateFromUser = req.getParameter("date");
//проверка пустых полей
        if (surname.isEmpty() || name.isEmpty() || group.isEmpty() || dateFromUser.isEmpty()) {
            req.setAttribute("error","1");
            //делаем перенаправление на мтраницу student-create.jsp
            req.getRequestDispatcher("JSP/student-create.jsp").forward(req, resp);
            return;
        }
        //String-->Date-->Strint (Двойное конвертирование dateFromUser(дата введенная от пользователя))
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);//в каком формате записана дата
        Date date = null;
        try {
            date = format.parse(dateFromUser);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //в нужный формат дату
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToDatabase = formatter.format(date);
        //создаем объект
        DBManager manager = new DBManager();
        //даем параметры объекту
        manager.createStudent(surname, name, group, dateToDatabase);

        resp.sendRedirect("/students");
    }

}
