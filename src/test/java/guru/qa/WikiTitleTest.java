package guru.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.ValueSource;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class WikiTitleTest extends BaseTest {
    @BeforeEach
    public void beforeEach() {
        open("https://www.wikipedia.org");
    }

    @ValueSource(
            strings = {"Apple", "Android"}
    )
    @Tag("web")
    @DisplayName("Проверка, что выдача не пустая")
    @ParameterizedTest(name = "После поискового запроса в заголовке должно отображаться название запроса {0}")
    void selenideJavaScriptLocaleTest(String request) {
        $("#searchInput").setValue(request).pressEnter();
        $(".mw-page-title-main").shouldHave(text(request));
    }
}
