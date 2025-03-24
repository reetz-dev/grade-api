package reetzzz.grade.dto;

import reetzzz.grade.enums.Time;

public class AddTimeRequest {
    private Long gradeId;
    private Time time;

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
