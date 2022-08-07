package entity;

import java.util.ArrayList;
import java.util.List;

public class Term {
    private int id;
    private String term;
    private String duration;
    private int status;
    private List<Discipline> disciplines = new ArrayList<>();

    public Term() {
    }

    public Term(int id, String term, String duration, int status, List<Discipline> disciplines) {
        this.id = id;
        this.term = term;
        this.duration = duration;
        this.status = status;
        this.disciplines = disciplines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }
}
