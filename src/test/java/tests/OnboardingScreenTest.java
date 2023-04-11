package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class OnboardingScreenTest extends TestBase {
    @Tag("emulator")
    @DisplayName("Onboarding screen test")
    @Test
    void gettingStartedTest() {

        String textView = "org.wikipedia.alpha:id/primaryTextView";
        String forwardButton = "org.wikipedia.alpha:id/fragment_onboarding_forward_button";
        String acceptButton = "org.wikipedia.alpha:id/acceptButton";

        step("Check text on the first page and go forward", () -> {
            $(id(textView)).shouldHave(text("The Free Encyclopedia …in over 300 languages"));
            $(id(forwardButton)).click();
        });
        step("Check text on the second page and go forward", () -> {
            $(id(textView)).shouldHave(text("New ways to explore"));
            $(id(forwardButton)).click();
        });
        step("Check text on the third page and go forward", () -> {
            $(id(textView)).shouldHave(text("Reading lists with sync"));
            $(id(forwardButton)).click();
        });
        step("Check text on the fourth page and accept", () -> {
            $(id(textView)).shouldHave(text("Send anonymous data"));
            $(id(acceptButton)).click();
        });
    }
}