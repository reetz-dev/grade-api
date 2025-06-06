package reetzzz.grade.model;

import jakarta.persistence.*;
import reetzzz.grade.dto.GradeDTO;
import reetzzz.grade.enums.Time;
import reetzzz.grade.enums.Weekday;

import java.util.List;


@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Weekday> weekdays;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Time> horarios;

    public Grade() {
    }

    public Grade(GradeDTO grade, List<Weekday> weekdays, List<Time> horarios) {
        this.id = grade.id();
        this.name = grade.name();
        this.weekdays = weekdays;
        this.horarios = horarios;
    }

    public Long getId() {
        return id;
    }

    public List<Weekday> getWeekdays() {
        return weekdays;
    }

    public List<Time> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Time> horarios) {
        this.horarios = horarios;
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
