package ru.marshenina.data;

public enum Tariffs {

    ON_START("На старте"),
    MOST_IMPORTANT("Самое важное"),
    ALL_INCLUSIVE("Всё включено"),
    HIGH_SPEED("Большие обороты");

    private String tariffName;

    Tariffs(String tariffName) {
        this.tariffName = tariffName;
    }

    public String getTariffName() {
        return tariffName;
    }
}
