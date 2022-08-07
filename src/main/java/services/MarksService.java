package services;

import java.util.Collection;

public class MarksService {
    public static double getAvarageMarks(Collection<Integer> marks) {
        double summMarks = 0;
        for (int makr : marks) {
            summMarks = summMarks + makr;
        }
        return summMarks / marks.size();
    }
}
