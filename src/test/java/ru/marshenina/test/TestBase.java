package ru.marshenina.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
    void screenResolution() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.vtb.ru";
    }
}
