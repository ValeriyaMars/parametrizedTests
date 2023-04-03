package ru.marshenina.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestWithValueSource {
    @ValueSource(strings = {
            "Комедии", "Мультфильмы", "Ужасы", "Фантастика", "Триллеры", "Боевики", "Мелодрамы", "Детективы",
            "Приключения", "Фэнтези", "Военные", "Семейные", "Аниме", "Исторические", "Драмы", "Документальные",
            "Детские", "Криминал", "Биографии", "Вестерны", "Фильмы-нуар", "Спортивные", "Реальное ТВ",
            "Короткометражки", "Музыкальные", "Мюзиклы", "Ток-шоу", "Игры"
    })
    @ParameterizedTest(name = "Список фильмов в разделе {0} равен 20")
    void listOfFilmsShouldBe20InCategory(String name) {
        open("https://www.kinopoisk.ru/lists/categories/movies/8/");
        $(".styles_content__2mO6X").shouldBe(visible)
                .$(byText(name)).click();
        $$(".styles_root__ti07r").shouldHave(size(20));
    }
}
