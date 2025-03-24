package reetzzz.grade.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reetzzz.grade.enums.Time;
import reetzzz.grade.enums.Weekday;
import reetzzz.grade.model.Grade;
import reetzzz.grade.repository.GradeRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TimeService {
    @Autowired
    GradeRepository gradeRepository;

    public Grade updateTimeInGradeAndWeekday(Long gradeId, Time oldTime, Time newTime) {
        Optional<Grade> gradeOpt = gradeRepository.findById(gradeId);
        if (gradeOpt.isPresent()) {
            Grade grade = gradeOpt.get();

            // Verifica se o dia antigo existe e substitui pelo novo
            if (grade.getHorarios().contains(oldTime)) {
                grade.getHorarios().remove(oldTime);
                grade.getHorarios().add(newTime);
                return gradeRepository.save(grade);
            } else {
                throw new IllegalArgumentException("O horário especificado não existe para essa matéria.");
            }
        }
     else {
        throw new EntityNotFoundException("Matéria não encontrada!");
    }
    }
    public Grade addTimeInWeekdayAndGrade(Long gradeId, Time time) {
        Optional<Grade> gradeOpt = gradeRepository.findById(gradeId);

        if (gradeOpt.isPresent()) {
            Grade grade = gradeOpt.get();

            if (grade.getHorarios() == null) {
                grade.setHorarios(new ArrayList<>());
            }
            if (!grade.getHorarios().contains(time)) {
                grade.getHorarios().add(time);
            }

            return gradeRepository.save(grade);
        } else {
            throw new EntityNotFoundException("Matéria não encontrada!");
        }
    }
}
