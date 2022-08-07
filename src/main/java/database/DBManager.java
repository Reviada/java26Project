package database;

import constants.Constants;
import entity.Discipline;
import entity.Student;
import entity.Term;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBManager implements IDBManager {
    @Override
    public List<Student> getAllActiveStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //коннектим базу данных
            Connection conn = DriverManager.getConnection(Constants.DB_URL_CONNECTION);
            Statement stmt = conn.createStatement();
            //запрос из sql и вставляем
            ResultSet rs = stmt.executeQuery("select * from student where status = 1;");

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("date"));
                student.setStatus(1);
                students.add(student);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void createStudent(String surname, String name, String group, String date) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //коннекти базу данных
            Connection conn = DriverManager.getConnection(Constants.DB_URL_CONNECTION);
            Statement stmt = conn.createStatement();
            //запрос из sql и просто выполнить
            stmt.execute("INSERT INTO `student` (`surname`, `name`, `group`, `date`) VALUES ('" + surname + "', '" + name + "', '" + group + "', '" + date + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //коннекти базу данных
            Connection conn = DriverManager.getConnection(Constants.DB_URL_CONNECTION);
            Statement stmt = conn.createStatement();
            //запрос из sql и просто выполнить
            stmt.execute("UPDATE `student` SET `status` = '0' WHERE (`id` = '" + id + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudentById(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //коннектим базу данных
            Connection conn = DriverManager.getConnection(Constants.DB_URL_CONNECTION);
            Statement stmt = conn.createStatement();
            //запрос из sql и вставляем
            ResultSet rs = stmt.executeQuery("select * from student where status = 1 and id= " + id);

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("date"));
                student.setStatus(1);
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void modifyStudent(String id, String surname, String name, String group, String dateToDatabase) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //коннекти базу данных
            Connection conn = DriverManager.getConnection(Constants.DB_URL_CONNECTION);
            Statement stmt = conn.createStatement();
            //запрос из sql и просто выполнить
            stmt.execute("UPDATE `student` SET `surname` = '" + surname + "', `name` = '" + name + "', `group` = '" + group + "', `date` = '" + dateToDatabase + "'  WHERE (`id` = '" + id + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //лист семестров
    @Override
    public List<Term> getAllActiveTerms() {
        ArrayList<Term> terms = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //коннектим базу данных
            Connection conn = DriverManager.getConnection(Constants.DB_URL_CONNECTION);
            Statement stmt = conn.createStatement();
            //запрос из sql и вставляем
            ResultSet rs = stmt.executeQuery("select * from term where status = 1;");
            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setTerm(rs.getString("name"));
                terms.add(term);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return terms;
    }

    @Override
    public List<Discipline> getDisciplinesByTerm(int id) {
        ArrayList<Discipline> disciplines = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //коннектим базу данных
            Connection conn = DriverManager.getConnection(Constants.DB_URL_CONNECTION);
            Statement stmt = conn.createStatement();
            //запрос из sql и вставляем //запрос через workbench(MuSQL)
            ResultSet rs = stmt.executeQuery("SELECT d.id, d.discipline FROM term_discipline as td\n" +
                    "left join discipline as d on td.id_discipline = d.id\n" +
                    "where td.id_term = " + id + " and d.status = '1'");
            while (rs.next()) {

                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt(id));
                discipline.setDiscipline(rs.getString("disciplone"));
                disciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    @Override
    public Map<Discipline, Integer> getMarksByTerm(int idTerm, String idStud) {
        Map<Discipline, Integer> marks = new HashMap<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //коннектим базу данных
            Connection conn = DriverManager.getConnection(Constants.DB_URL_CONNECTION);
            Statement stmt = conn.createStatement();
            //запрос из sql и вставляем //запрос через workbench(MuSQL)
            ResultSet rs = stmt.executeQuery("SELECT d.id, d.discipline, m.mark FROM mark as m\n" +
                    "left join term_discipline as td on m.id_tern_discipline = td.id\n" +
                    "left join discipline as d on td.id_discipline = d.id\n" +
                    "where d.status = '1' and m.id_student = " + idStud + " and td.id_term = " + idTerm + "");
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                marks.put(discipline, rs.getInt("mark"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marks;
    }

}







