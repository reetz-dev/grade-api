package reetzzz.grade.service;

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

    // Criar ou Atualizar uma Grade
    public Grade createOrUpdateGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    // Buscar todos as Grades
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    // Buscar Grade por ID
    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }

    // Deletar uma Grade por ID
    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}