package reetzzz.grade.weekday;

public class UpdateWeekdayRequest {
    private Long gradeId;
    private Weekday oldWeekday;
    private Weekday newWeekday;

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Weekday getOldWeekday() {
        return oldWeekday;
    }

    public void setOldWeekday(Weekday oldWeekday) {
        this.oldWeekday = oldWeekday;
    }

    public Weekday getNewWeekday() {
        return newWeekday;
    }

    public void setNewWeekday(Weekday newWeekday) {
        this.newWeekday = newWeekday;
    }
}