package reetzzz.grade.controller;

import reetzzz.grade.model.Grade;
import reetzzz.grade.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    // Criar ou Atualizar uma Grade
    @PostMapping
    public ResponseEntity<Grade> createOrUpdateGrade(@RequestBody Grade grade) {
        Grade savedGrade = gradeService.createOrUpdateGrade(grade);
        return new ResponseEntity<>(savedGrade, HttpStatus.CREATED);
    }

    // Listar todas as Grades
    @GetMapping
    public ResponseEntity<List<Grade>> getAllGrades() {
        List<Grade> grades = gradeService.getAllGrades();
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }

    // Buscar uma Grade por ID
    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable("id") Long id) {
        Optional<Grade> grade = gradeService.getGradeById(id);
        if (grade.isPresent()) {
            return new ResponseEntity<>(grade.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Deletar uma Grade por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable("id") Long id) {
        Optional<Grade> grade = gradeService.getGradeById(id);
        if (grade.isPresent()) {
            gradeService.deleteGrade(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}