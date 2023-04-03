package ru.marshenina.data;

public enum Businesses {

    NEW_BUSINESS("Новый бизнес"),
    SMALL_BUSINESS("Малый бизнес"),
    MEDIUM_BUSINESSES("Средний бизнес"),
    BIG_BUSINESS("Крупный бизнес");

    private String desc;

    Businesses(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
