package config;

public class Environment {
    public static String browser() {
        return System.getProperty("browser", ConfigReader.get("browser"));
    }

    public static boolean headless() {
        return Boolean.parseBoolean(System.getProperty("headless", ConfigReader.get("headless")));
    }

    public static String baseUrl() {
        return System.getProperty("baseUrl", ConfigReader.get("baseUrl"));
    }

    public enum EnvironmentType {
        DEV, QA, STAGING
    }

    public static int timeout() {
        String value = System.getProperty("timeout", ConfigReader.get("timeout"));
        System.out.println("Timeout value = " + value);
        return Integer.parseInt(System.getProperty("timeout", ConfigReader.get("timeout")));
    }
}
