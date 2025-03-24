package reetzzz.grade.dto;

import reetzzz.grade.enums.Time;

public class UpdateTimeRequest {
    private Long gradeId;
    private Time newTime;
    private Time oldTime;

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Time getNewTime() {
        return newTime;
    }

    public void setNewTime(Time newTime) {
        this.newTime = newTime;
    }

    public Time getOldTime() {
        return oldTime;
    }

    public void setOldTime(Time oldTime) {
        this.oldTime = oldTime;
    }
}
