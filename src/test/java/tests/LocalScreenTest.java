package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class LocalScreenTest extends TestBase {
    @Tag("emulator")
    @DisplayName("Screen test")
    @Test
    void gettingStartedTest() {

        String
        textView = "org.wikipedia.alpha:id/primaryTextView",
        forwardButton = "org.wikipedia.alpha:id/fragment_onboarding_forward_button",
        acceptButton = "org.wikipedia.alpha:id/acceptButton";

        step("Text checking on the first page", () -> {
            $(id(textView)).shouldHave(text("The Free Encyclopedia …in over 300 languages"));
            $(id(forwardButton)).click();
        });
        step("Text checking on the second page", () -> {
            $(id(textView)).shouldHave(text("New ways to explore"));
            $(id(forwardButton)).click();
        });
        step("Text checking on the third page", () -> {
            $(id(textView)).shouldHave(text("Reading lists with sync"));
            $(id(forwardButton)).click();
        });
        step("Text checking on the fourth page and accepting", () -> {
            $(id(textView)).shouldHave(text("Send anonymous data"));
            $(id(acceptButton)).click();
        });
    }
}