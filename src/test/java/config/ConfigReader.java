package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class ConfigReader {
    private static final Properties prop = new Properties();

    //    static {
//        try (InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
//            if (in == null) {
//                throw new RuntimeException("config.properties file not found");
//            }
//            prop.load(in);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
    static {
        String env = System.getProperty("env", "dev").toLowerCase();
        String fileName = "config/" + env + ".properties";

        System.out.println("Loading file: " + fileName);

        try (InputStream input =
                     ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {

            if (input == null) {
                throw new RuntimeException("Cannot find file: " + fileName);
            }

            prop.load(input);

            System.out.println("browser = " + prop.getProperty("browser"));
            System.out.println("baseUrl = " + prop.getProperty("baseUrl"));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return ConfigReader.prop.getProperty(key);
    }
}
