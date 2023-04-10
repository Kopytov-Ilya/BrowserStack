package config;
import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${deviceHost}.properties"})

public interface BrowserstackConfig extends Config {
    @Key("browserstack.user")
    String user();

    @Key("browserstack.key")
    String key();

    @Key("app")
    String app();

    @Key("device")
    String device();

    @Key("baseurl")
    String getBaseUrl();

    @Key("version")
    String version();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();

    @Key("platform_version")
    String getPlatformVersion();

    @Key("device_name")
    String getDeviceName();

    @Key("app_activity")
    String getAppActivity();

    @Key("app_package")
    String getAppPackage();

    @Key("device_url")
    String getDeviceUrl();
}
