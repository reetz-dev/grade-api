package reetzzz.grade.dto;

import reetzzz.grade.model.Grade;

public record GradeDTO(Long id, String name) {
    public GradeDTO(Grade grade){
        this(grade.getId(), grade.getName());
    }
}
