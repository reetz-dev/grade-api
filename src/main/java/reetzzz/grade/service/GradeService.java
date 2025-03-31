package reetzzz.grade.service;

import org.springframework.transaction.annotation.Transactional;
import reetzzz.grade.dto.GradeDTO;
import reetzzz.grade.model.Grade;
import reetzzz.grade.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;
    @Transactional
    public Grade createOrUpdateGrade(GradeDTO gradeDTO) {
        System.out.println("Chamando createOrUpdateGrade");
        if (gradeDTO.id() != null) {
            Grade existingGrade = gradeRepository.findById(gradeDTO.id()).orElse(null);
            if (existingGrade != null) {
                existingGrade.setName(gradeDTO.name());
                existingGrade.setWeekdays(null);
                existingGrade.setHorarios(null);
                return gradeRepository.save(existingGrade);
            }
        }

        Grade newGrade = new Grade(gradeDTO, null, null);
        return gradeRepository.save(newGrade);
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}