package ru.marshenina.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.marshenina.data.Businesses;
import ru.marshenina.data.Tariffs;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestWithMethodSource extends TestBase {

    static Stream<Arguments> tariffShouldHaveListOfOptions() {
        return Stream.of(
                Arguments.of(Businesses.NEW_BUSINESS.getDesc(), Tariffs.ON_START.getTariffName(),
                        List.of("Уже есть расчетный счет в ВТБ", "Валютные платежи",
                                "Платежи физическим лицам", "Онлайн-касса", "Выдача наличных")),
                Arguments.of(Businesses.SMALL_BUSINESS.getDesc(), Tariffs.MOST_IMPORTANT.getTariffName(),
                        List.of("Уже есть расчетный счет в ВТБ", "Валютные платежи",
                        "Платежи физическим лицам", "Онлайн-касса", "Выдача наличных")),
                Arguments.of(Businesses.MEDIUM_BUSINESSES.getDesc(), Tariffs.ALL_INCLUSIVE.getTariffName(),
                        List.of("Уже есть расчетный счет в ВТБ", "Валютные платежи",
                        "Платежи физическим лицам", "Онлайн-касса", "Выдача наличных")),
                Arguments.of(Businesses.BIG_BUSINESS.getDesc(), Tariffs.HIGH_SPEED.getTariffName(),
                        List.of("Уже есть расчетный счет в ВТБ", "Валютные платежи",
                        "Платежи физическим лицам", "Онлайн-касса"))
        );
    }

    @MethodSource()
    @ParameterizedTest(name = "Для тарифа {1} должны отображаться опции {2}")
    void tariffShouldHaveListOfOptions(String business, String tariff, List<String> listOfOptions) {
        open("/malyj-biznes/raschetnoe-obsluzhivanie/pakety-uslug/");
        sleep(4000);
        $(".calculator-rko-segmentsstyles__RadioGroupStyled-calculator-rko__sc-10ukgjb-1")
                .$(byText(business)).click();
        $(".ceLUtb")
                .shouldHave(exactText(tariff));
        $$(".calculator-switcherstyles__Text-foundation-kit__sc-wreaot-6")
                .filter(visible).shouldHave(texts(listOfOptions));
    }
}
