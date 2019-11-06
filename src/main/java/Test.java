import com.epam.framework.driver.DriverSingleton;
import com.epam.framework.page.CalculatorPage;
import com.epam.framework.page.CloudPage;
import com.epam.framework.page.TenMinutesMailPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

    private static WebDriver driver;


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        CloudPage cloud = new CloudPage(driver);
        CalculatorPage calculator = new CalculatorPage(driver);
        TenMinutesMailPage tenMinutes = new TenMinutesMailPage(driver);


        cloud.search();
        calculator.fillingTheForm();
        calculator.sentEmail();
        tenMinutes.openTenMinuteMail();
        tenMinutes.comeToGooglePage();
        tenMinutes.waitEmailFromGoogle();
        driver.switchTo().window("6442450945");


    }

}
