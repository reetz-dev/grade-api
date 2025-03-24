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
    public Grade createOrUpdateGrade(GradeDTO grade) {
        Grade grade1 = new Grade(grade, null, null);
        return gradeRepository.save(grade1);
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