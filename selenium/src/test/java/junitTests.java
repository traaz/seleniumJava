import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class junitTests {

  static WebDriver driver ;

  @BeforeAll  //before class olduğu için static
  public static void setUp(){
    System.setProperty("webdriver.chrome.driver", "drivers/chromeDriverbeta.exe");
    ChromeOptions options = new ChromeOptions();
    options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe"); // Chrome Beta'nın yolu
    driver = new ChromeDriver(options);
    driver.get("https://www.hepsiburada.com/");
    driver.manage().window().maximize();
    timeWait(2000);
  }

  @Test
  @Order(1)
  public void siteyeGidilMi(){
    String gidilecekSiteUrl = "https://www.hepsiburada.com/";
    assertEquals(gidilecekSiteUrl, driver.getCurrentUrl());
  }

  @Test
  @Order(2)
  public void uyeOlButonunaTiklanarakYeniSayfa(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
    element.click();

    timeWait(5000);

    WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[4]/div[5]/div/div/div/div[1]/div[2]/div[3]/div[2]/span/span[1]")));
    dropdown.click();

    WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register")));
    login.click();


    WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]")));
   // WebElement text = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]"));
    String expextedText = "Üye ol";
    assertEquals(expextedText, text.getText());

  }

  @Test
  @Order(3)
  public void emailGirilipButonaTiklandiMi(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUserName")));
    userNameField.sendKeys("aztr01@hotmail.com");

    WebElement buton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSignUpSubmit")));
    buton.click();

    WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[2]")));
    System.out.println(text.getText());
    String expectedText = "Doğrulama maili gönderildi";
    assertEquals(expectedText, text.getText());

  }


  @AfterAll
    public static void finish(){
    if (driver != null) {
      driver.quit(); // Tarayıcıyı kapat
    }
  }

  public static void timeWait(int number){
    try {
      Thread.sleep(number);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}


