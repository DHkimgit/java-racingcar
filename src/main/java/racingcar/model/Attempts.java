package racingcar.model;

public record Attempts (
    Integer attempt
) {

    public static Attempts from(String attempt) {
        return new Attempts(Integer.parseInt(attempt));
    }
}
