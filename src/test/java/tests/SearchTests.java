package tests;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SearchTests extends TestBase {

    @DisplayName("Search on Android")
    @Tag("Android")
    @Test
    void successfulSearchAndroidTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("java");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @DisplayName("Check information on the link click")
    @Tag("Android")
    @Test
    void openTheLinkTest() {
        step("click on the link on the main page", () -> {
            $(id("org.wikipedia.alpha:id/horizontal_scroll_list_item_text")).click();
        });
        step("Verify content found", () ->
                $(id("org.wikipedia.alpha:id/view_news_fullscreen_story_text"))
                        .shouldHave(text(
                                "Former President of the United States Donald Trump (pictured) is arraigned on 34 charges of falsifying business records.")));
    }

    @DisplayName("Search IOS")
    @Tag("IOS")
    @Test
    void checkInputIOS() {
        step("Click button Text", () -> {
            $(accessibilityId("Text Button")).click();
        });
        step("Check Text Input", () -> {
            $(accessibilityId("Text Input")).shouldBe(visible);
        });
    }
}