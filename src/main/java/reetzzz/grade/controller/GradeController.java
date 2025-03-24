package reetzzz.grade.controller;

import reetzzz.grade.weekday.AddWeekdayRequest;
import reetzzz.grade.model.Grade;
import reetzzz.grade.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reetzzz.grade.service.WeekdayService;
import reetzzz.grade.weekday.UpdateWeekdayRequest;
import reetzzz.grade.weekday.Weekday;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grades")
public class GradeController {
    @Autowired
    private WeekdayService weekdayService;
    @Autowired
    private GradeService gradeService;

    @PutMapping("/weekdays/{gradeId}")
    public ResponseEntity<Grade> updateWeekdayInGrade(@PathVariable Long gradeId, @RequestBody UpdateWeekdayRequest request) {
        Grade updatedGrade = weekdayService.updateWeekdayInGrade(gradeId, request.getOldWeekday(), request.getNewWeekday());
        return ResponseEntity.ok(updatedGrade);
    }

    @PostMapping("/weekdays")
    public ResponseEntity<Grade> addWeekdayToGrade(@RequestBody AddWeekdayRequest request) {
        Grade savedWeekday = weekdayService.addWeekdayToGrade(request.getGradeId(), request.getWeekday());
        return new ResponseEntity<>(savedWeekday, HttpStatus.CREATED);
    }
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
    @GetMapping("/weekdays")
    public ResponseEntity<List<Grade>> getAllGradesWithWeekdays() {
        List<Grade> grades = weekdayService.getAllGradesWithWeekdays();
        return ResponseEntity.ok(grades);
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
    @GetMapping("/weekdays/{gradeId}")
    public ResponseEntity<Grade> getGradeWithWeekdays(@PathVariable Long gradeId) {
        Grade grade = weekdayService.getWeekdaysByGrade(gradeId);
        return ResponseEntity.ok(grade);
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
    @DeleteMapping("/weekdays/{gradeId}/{weekday}")
    public ResponseEntity<Void> removeWeekdayFromGrade(@PathVariable Long gradeId, @PathVariable Weekday weekday) {
        weekdayService.removeWeekdayFromGrade(gradeId, weekday);
        return ResponseEntity.noContent().build();
    }
}