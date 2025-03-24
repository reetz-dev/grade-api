package reetzzz.grade.weekday;

public enum Weekday {
    SEGUNDA_FEIRA,
    TERCA_FEIRA,
    QUARTA_FEIRA,
    QUINTA_FEIRA,
    SEXTA_FEIRA;

    public static Weekday fromString(String value) {
        for (Weekday day : Weekday.values()) {
            if (day.name().equalsIgnoreCase(value.replace(" ", "_"))) {
                return day;
            }
        }
        throw new IllegalArgumentException("Dia da semana inválido: " + value);
    }
}