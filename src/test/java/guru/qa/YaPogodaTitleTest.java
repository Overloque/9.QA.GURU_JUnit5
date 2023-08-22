package guru.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class YaPogodaTitleTest extends BaseTest {
    @BeforeEach
    public void beforeEach() {
        open("https://www.gismeteo.ru");
    }

    @CsvFileSource(
            resources = "/successfullSearchWeather.csv"
    )
    @Tag("web")
    @DisplayName("Проверка заголовка для сайта с погодой")
    @ParameterizedTest(name = "После поискового запроса в заголовке должно отображаться название запроса {0}")
    void selenideJavaScriptLocaleTest(String city, String cityTitle) {
        $(".js-input").setValue(city).pressEnter();
        $(".page-title").shouldHave(text(cityTitle));
    }
}
