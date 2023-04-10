package config;
import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"
})
public interface MobileDriverConfig extends Config {

    @Key("browserstack.user")
    String getUser();

    @Key("browserstack.key")
    String getKey();

    @Key("apps")
    String getApp();

    @Key("device")
    String getDevice();

    @Key("baseurl")
    String getBaseUrl();

    @Key("version")
    String getVersion();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("deviceName")
    String getDeviceName();

    @Key("appURL")
    String getAppURL();

    @Key("appPath")
    String getAppPath();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

    @Key("appiumUrl")
    String getAppiumUrl();
}