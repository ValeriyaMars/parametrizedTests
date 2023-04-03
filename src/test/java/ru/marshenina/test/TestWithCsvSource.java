package ru.marshenina.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestWithCsvSource extends TestBase {

    @CsvSource(value = {
            "Новый бизнес, На старте",
            "Малый бизнес, Самое важное",
            "Средний бизнес, Всё включено",
            "Крупный бизнес, Большие обороты"
    }
    )

    @ParameterizedTest(name = "По нажатию на кнопку {0} отображается тариф {1}")
    void checkRateForBusiness(String business, String tariff) {
        open("/malyj-biznes/raschetnoe-obsluzhivanie/pakety-uslug/");
        sleep(4000);
        $(".calculator-rko-segmentsstyles__RadioGroupStyled-calculator-rko__sc-10ukgjb-1")
                .$(byText(business)).click();
        $(".ceLUtb")
                .shouldHave(exactText(tariff));
    }
}
