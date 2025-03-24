package reetzzz.grade.dto;

import reetzzz.grade.enums.Weekday;

public class AddWeekdayRequest {
    private Long gradeId;
    private Weekday weekday;

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }
}