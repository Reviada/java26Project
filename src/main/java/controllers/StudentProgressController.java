package controllers;

import database.DBManager;
import entity.Discipline;
import entity.Student;
import entity.Term;
import services.MarksService;
import services.TermService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StudentProgressController", urlPatterns = "/student-progress")
public class StudentProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("progressHidden");
        String idSelectedTerm = req.getParameter("idSelectedTerm");
        DBManager manager = new DBManager();
        //вытянуть данные из базы
        // 1-  студент по id
        // 2- все активные семестры
        // 3- определить первый активный семестр(выбранный по умолчанию)
        // 5- оценки, если есть по этому студенту по выбранному семестру
        // 6- определить среднюю оценку
//1
        Student student = manager.getStudentById(id);//передаем id активного студента
//2

        List<Term> terms = manager.getAllActiveTerms();
        Term selectedTerm = null;
        req.setAttribute("terms", terms);
        //если параметр пустой
        if (idSelectedTerm == null ){
            selectedTerm = terms.get(0);
            req.setAttribute("selectedTerms", selectedTerm);
        } else{
            selectedTerm = TermService.getTermById(terms, idSelectedTerm);
            req.setAttribute("selectedTerms", selectedTerm);
        }
//3
//5
        Map<Discipline, Integer> marks = manager.getMarksByTerm(selectedTerm.getId(), id);
        if (marks.isEmpty()) {
            List<Discipline> disciplines = manager.getDisciplinesByTerm(selectedTerm.getId());
            req.setAttribute(   "disciplines",disciplines);
        } else {
            req.setAttribute("disciplines",marks.keySet());
            req.setAttribute("disciplines",marks.keySet());
            double avarage = MarksService.getAvarageMarks(marks.values());
        }
        req.setAttribute("student", student);

        req.getRequestDispatcher("JSP/student-progress.jsp").forward(req, resp);
    }
}

