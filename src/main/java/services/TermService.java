package services;

import entity.Term;

import java.util.List;

public class TermService {
    public static Term getTermById(List<Term> terms, String idTerm) {
        for (Term t : terms) {
            if (t.getId() + "" == idTerm) {
                return t;
            }
        }
        return null;
    }
}
