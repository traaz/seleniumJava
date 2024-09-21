import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Test1 {


    public static void main(String[] args) {
        //Bu anahtar, Selenium WebDriver'a hangi ChromeDriver'ın kullanılacağını belirtir.
        System.setProperty("webdriver.chrome.driver", "drivers/chromeDriverbeta.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe"); // Chrome Beta'nın yolu
        WebDriver driver = new ChromeDriver(options);


        //-------checkbox---------ilk basta hata verince kutucuga basınca. onu da isme basinca ile secmesiyle yaptik.
       /*
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        WebElement sportCheckBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[7]/div[2]/div[1]/input"));
        boolean isEnabled = sportCheckBox.isEnabled();
        System.out.println(isEnabled);

        WebElement sportLabel = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[7]/div[2]/div[1]/label"));

        try {
            sportCheckBox.click();
        }catch (ElementClickInterceptedException e){
            sportLabel.click();
        }
        boolean isSelected = sportCheckBox.isSelected();
        System.out.println(isSelected);*/







        //----------radiobutton  ilk enable-disable sonra selected nonselected
      /*  driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
        WebElement radioButton = driver.findElement(By.id("impressiveRadio"));
        boolean isEnabled = radioButton.isEnabled();
        System.out.println(isEnabled);

        WebElement radioButtonText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[3]/label"));
        if(isEnabled){
            try {
                radioButton.click();
            }catch (ElementClickInterceptedException e){
                radioButtonText.click();
            }
        } //selected islemini button üzerinden yaparız label üzerinden değil
        if(radioButton.isSelected()){
            System.out.println("Seçildi");
        }

        WebElement noRadioButton = driver.findElement(By.id("noRadio"));
        System.out.println(noRadioButton.isEnabled()); //false

       */


        //-----dinamik elementler
        //driver.get("https://demoqa.com/dynamic-properties");
        //driver.manage().window().maximize();




        // 5 saniye bekleyince enabled olan buton
      /*  WebElement firstButton = driver.findElement(By.id("enableAfter"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(firstButton));
        firstButton.click();
        System.out.println("butona tiklandi");*/




        //rengi 5 saniyeden sonra değişen
       /* WebElement secondButton = driver.findElement(By.id("colorChange"));
        String className = secondButton.getAttribute("class");
        System.out.println(className);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeToBe(secondButton, "class", "mt-4 text-danger btn btn-primary"));
        className = secondButton.getAttribute("class");
        System.out.println(className);*/




        //5 saniye sonra gelen butona tıklama
      /*  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        driver.findElement(By.id("visibleAfter")).click();*/







        // listedeki isimleri alma ve click yapma
        /*driver.get("https://demoqa.com/elements");
        List<WebElement> listItems = driver.findElements(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li"));

        for (WebElement item : listItems) {

            // Öğeye tıkla
            item.click();
            // Bekleme süresi
            timeWait(3000);
            driver.navigate().back();
            timeWait(2000);
        }*/





        //download islemi

        /*  driver.get("https://demoqa.com/upload-download");
        WebElement download = driver.findElement(By.id("downloadButton"));
        download.click();
        timeWait(3000);

        String path = "C:\\Users\\trka8\\Downloads";
        String file = "sampleFile.jpeg";

       System.out.println(isDownload(path,file));*/







        //------yeni sekme
       /* driver.get("https://demoqa.com/browser-windows");
        WebElement button = driver.findElement(By.id("tabButton"));
        button.click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs.size()); //2

        driver.switchTo().window(tabs.get(1));  //1 çünkü index geriyoz.
        System.out.println(driver.getCurrentUrl());
        timeWait(2000);
        driver.close();*/







        //--alerts

    /*   driver.get("https://demoqa.com/alerts");
       driver.manage().window().maximize();
        timeWait(5000);
        WebElement  button = driver.findElement(By.id("promtButton"));

       button.click();
       timeWait(2000);
       driver.switchTo().alert().sendKeys("Ali");
       timeWait(5000);
       driver.switchTo().alert().accept();
       timeWait(2000);

       // driver.switchTo().alert().accept();
        //driver.switchTo().alert().dismiss();*/





        //-----------datepicker and dropdown
      /*  driver.get("https://demoqa.com/date-picker");
        timeWait(5000);
        WebElement dateSelection = driver.findElement(By.id("datePickerMonthYearInput"));
        dateSelection.click();
        timeWait(5000);

        WebElement monthDropdown = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
        Select select = new Select(monthDropdown);
        select.selectByVisibleText("December");
        timeWait(5000);


        WebElement yearDropdown = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));
        Select select2 = new Select(yearDropdown);
        select2.selectByVisibleText("1995");
        timeWait(5000);

        WebElement dayToSelect = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[7]")); // 9. günü seç
        dayToSelect.click();*/






        //------------------formlar
       /* driver.get("https://demoqa.com/automation-practice-form");
        timeWait(2000);

        WebElement name = driver.findElement(By.id("firstName"));
        name.sendKeys("Servet");
        timeWait(2000);

        WebElement surname = driver.findElement(By.id("lastName"));
        surname.sendKeys("Çetin");
        timeWait(2000);


        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("servetcetin@gmail.com");
        timeWait(2000);

        WebElement gender = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[3]/div[2]/div[1]/label"));
        gender.click();
        timeWait(1000);


        WebElement phoneNumber = driver.findElement(By.id("userNumber"));
        phoneNumber.sendKeys("05056116161");
        timeWait(2000);

      WebElement subject = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[6]/div[2]/div/div/div[1]"));
        subject.sendKeys("Computer Science");
        timeWait(2000);

        WebElement dateDropdown = driver.findElement(By.id("dateOfBirthInput"));
        dateDropdown.click();
        timeWait(2000);



        WebElement monthSelected = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
        Select select = new Select(monthSelected);
        select.selectByVisibleText("July");
        timeWait(5000);

        WebElement yearSelected = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));
        Select select2 = new Select(yearSelected);
        select2.selectByVisibleText("1995");
        timeWait(5000);


        WebElement daySelected = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[4]"));
        daySelected.click();



        WebElement checkBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[7]/div[2]/div[1]/label"));
        checkBox.click();
        timeWait(1000);

        WebElement checkBox2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[7]/div[2]/div[3]/label"));
        checkBox2.click();
        timeWait(1000);

        WebElement currentAdress = driver.findElement(By.id("currentAddress"));
        currentAdress.sendKeys("Yeni Mahalle Ankara Türkiye");
        timeWait(2000);


        //div tabanlı olduğu için select yok html kodunda o yüzden boyle yaptik
       WebElement stateDropdown = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[10]/div[2]"));
        stateDropdown.click();
        timeWait(3000);
        List<WebElement> stateList = driver.findElements(By.cssSelector(".css-2613qy-menu"));
        for(WebElement element : stateList){
            if(element.getText().equals("Haryana"));
            element.click();
            break;
        }


        WebElement cityDropdown = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[10]/div[3]/div/div/div[1]/div[1]"));
        cityDropdown.click();
        timeWait(3000);
        List<WebElement> cityList = driver.findElements(By.cssSelector(".css-2613qy-menu"));
        for(WebElement element : cityList){
            if(element.getText().equals("Karnal"));
            element.click();
            break;
        }

        WebElement buton = driver.findElement(By.id("submit"));
        buton.click();

        WebElement modalButon = driver.findElement(By.id("closeLargeModal"));
        modalButon.click();
*/










        //-------------------web tables


























       /* driver.get("https://www.hepsiburada.com/");

        timeWait(2000);
        WebElement element = driver.findElement(By.id("onetrust-accept-btn-handler"));
        element.click();

       timeWait(2000);
        WebElement dropdown = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div[5]/div/div/div/div[1]/div[2]/div[3]/div[2]/span/span[1]"));
        dropdown.click();

        timeWait(2000);

        WebElement login = driver.findElement(By.id("register"));
        login.click();

        timeWait(2000);
        WebElement eMail = driver.findElement(By.id("txtUserName"));
        eMail.sendKeys("aztr01@hotmail.com");

        timeWait(2000);
        WebElement button = driver.findElement(By.id("btnSignUpSubmit"));
        button.click();*/


    }
    public static void timeWait(int number){
        try {
            Thread.sleep(number);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isDownload(String pathName, String fileName){
        File file = new File(pathName);
        File[] files = file.listFiles();
        for(File item : files){
            if(item.getName().equals(fileName)){
                item.delete();
                return true;
            }
        }
        return false;


    }
}
