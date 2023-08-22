package guru.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JavaScriptLanguageTest extends BaseTest {
    @BeforeEach
    public void beforeEach() {
        open("https://learn.javascript.ru");
    }

    static Stream<Arguments> selenideJavaScriptLocaleTest() {
        return Stream.of(
                Arguments.of(Locale.ES, "El Tutorial de JavaScript Moderno"),
                Arguments.of(Locale.EN, "The Modern JavaScript Tutorial")
        );
    }

    @Tags({
            @Tag("web"),
            @Tag("locale")
    })
    @MethodSource
    @DisplayName("Проверка заголовков в зависимости от локали")
    @ParameterizedTest(name = "При смене локали на {0} на странице отображается заголовк {1}")
    void selenideJavaScriptLocaleTest(Locale locale, String title) {
        $(".sitetoolbar__lang-switcher").click();
        $$(".supported-langs__container ul li").find(text(locale.name())).click();
        $(".frontpage-banner__title").shouldHave(text(title));
    }
}
