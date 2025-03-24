package reetzzz.grade.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reetzzz.grade.model.Grade;
import reetzzz.grade.enums.Weekday;
import reetzzz.grade.repository.GradeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WeekdayService {
    @Autowired
    private GradeRepository gradeRepository;
    public Grade addWeekdayToGrade(Long gradeId, Weekday weekday) {
        Optional<Grade> gradeOpt = gradeRepository.findById(gradeId);

        if (gradeOpt.isPresent()) {
            Grade grade = gradeOpt.get();

            if (grade.getWeekdays() == null) {
                grade.setWeekdays(new ArrayList<>());
            }
            if (!grade.getWeekdays().contains(weekday)) {
                grade.getWeekdays().add(weekday);
            }

            return gradeRepository.save(grade);
        } else {
            throw new EntityNotFoundException("Matéria não encontrada!");
        }
    }

    public Grade updateWeekdayInGrade(Long gradeId, Weekday oldWeekday, Weekday newWeekday) {
        Optional<Grade> gradeOpt = gradeRepository.findById(gradeId);

        if (gradeOpt.isPresent()) {
            Grade grade = gradeOpt.get();

            // Verifica se o dia antigo existe e substitui pelo novo
            if (grade.getWeekdays().contains(oldWeekday)) {
                grade.getWeekdays().remove(oldWeekday);
                grade.getWeekdays().add(newWeekday);
            } else {
                throw new IllegalArgumentException("O dia da semana especificado não existe para essa matéria.");
            }

            return gradeRepository.save(grade);
        } else {
            throw new EntityNotFoundException("Matéria não encontrada!");
        }
    }

    public Grade getWeekdaysByGrade(Long gradeId) {
        return gradeRepository.findById(gradeId)
                .orElseThrow(() -> new EntityNotFoundException("Matéria não encontrada!"));
    }
    public void removeWeekdayFromGrade(Long gradeId, Weekday weekday) {
        Optional<Grade> gradeOpt = gradeRepository.findById(gradeId);

        if (gradeOpt.isPresent()) {
            Grade grade = gradeOpt.get();
            if (grade.getWeekdays().contains(weekday)) {
                grade.getWeekdays().remove(weekday);
                gradeRepository.save(grade);
            } else {
                throw new IllegalArgumentException("Esse dia da semana não está associado a essa matéria.");
            }
        } else {
            throw new EntityNotFoundException("Matéria não encontrada!");
        }
    }

    public List<Grade> getAllGradesWithWeekdays() {
        return gradeRepository.findAll();
    }
}
