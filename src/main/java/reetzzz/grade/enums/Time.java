package reetzzz.grade.enums;

public enum Time {
    PRIMEIRA_AULA,
    SEGUNDA_AULA,
    TERCEIRA_AULA,
    QUARTA_AULA,
    QUINTA_AULA;
    public static Time fromString(String value) {
        for (Time day : Time.values()) {
            if (day.name().equalsIgnoreCase(value.replace(" ", "_"))) {
                return day;
            }
        }
        throw new IllegalArgumentException("Horário de aula inválida: " + value);
    }
}
