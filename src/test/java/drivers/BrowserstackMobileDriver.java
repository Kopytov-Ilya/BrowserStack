package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {


        public static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
        @Nonnull
        @Override
        public WebDriver createDriver(@Nonnull Capabilities capabilities) {
            MutableCapabilities mutableCapabilities = new MutableCapabilities();
            mutableCapabilities.merge(capabilities);
            mutableCapabilities.setCapability("browserstack.user", config.user());
            mutableCapabilities.setCapability("browserstack.key", config.key());
            mutableCapabilities.setCapability("app", config.app());
            mutableCapabilities.setCapability("device", config.device());
            mutableCapabilities.setCapability("os_version", config.version());
            mutableCapabilities.setCapability("project", config.project());
            mutableCapabilities.setCapability("build", config.build());
            mutableCapabilities.setCapability("name", config.name());

            return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
        }
        public static URL getBrowserstackUrl() {
            try {
                return new URL(config.getBaseUrl());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }