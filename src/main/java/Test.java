
import com.epam.framework.page.CalculatorPage;
import com.epam.framework.page.CloudPage;
import com.epam.framework.page.TenMinutesMailPage;
import com.epam.framework.user.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Test {

    private static WebDriver driver;


    public static void main(String[] args) {

        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        CloudPage cloud = new CloudPage(driver);
        CalculatorPage calculator = new CalculatorPage(driver);
        TenMinutesMailPage tenMinutes = new TenMinutesMailPage(driver);

        //cloud.search();
        //calculator.fillingTheForm();
        //calculator.sentEmail();
        //tenMinutes.openTenMinuteMail();
        //tenMinutes.comeToGooglePage();
       // tenMinutes.waitEmailFromGoogle();



    }

}
