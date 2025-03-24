package reetzzz.grade.model;

import jakarta.persistence.*;
import reetzzz.grade.weekday.Weekday;

import java.util.List;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private List<Weekday> weekdays;
    public Long getId() {
        return id;
    }

    public List<Weekday> getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(List<Weekday> weekdays) {
        this.weekdays = weekdays;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
