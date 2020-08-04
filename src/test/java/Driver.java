import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    public static WebDriver driver;
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
    }
    static void setUp() {
        driver = new ChromeDriver();
    }
    static void tearDown() {
        driver.quit();
        driver = null;
    }
}
