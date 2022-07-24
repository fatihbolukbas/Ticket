package Ticket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class PlaneTicket {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fatih\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        //Buying plane ticket
        driver.findElement(By.xpath("//input[@title='Ara']")).sendKeys("uçak bileti");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).click();
        driver.findElement(By.xpath("//h3[contains(text(),'Uçak Bileti Bul, Ucuz Uçak Bileti Fiyatları | ENUY')]")).click();
        driver.findElement(By.xpath("//input[@id='OriginInput']")).sendKeys("istanbul");

        //Destinations
        driver.findElement(By.xpath("//li[@id='react-autowhatever-OriginInput-section-0-item-0']//div[@class='suggestion_item']")).click();
        driver.findElement(By.xpath("//input[@id='DestinationInput']")).click();
        driver.findElement(By.xpath("//div[normalize-space()='Londra']")).click();

        //Departure date
        driver.findElement(By.id("DepartureDate")).click();
        for ( int i = 1; i <= 3; i++){
            driver.findElement(By.xpath("//div[@aria-label='Move forward to switch to the next month.']")).click();
        }
        driver.findElement(By.xpath("//div[@data-description-rendered='true'][normalize-space()='28']")).click();

        //Transit flight filter
        driver.findElement(By.xpath("//input[@id='transitFilter']")).click();

        //Passenger number
        driver.findElement(By.xpath("//button[@class='default-btn block passenger-select-button']")).click();
        for (int j = 1; j <= 4; j++){
            driver.findElement(By.xpath("//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//form[1]//div[1]//div[3]//div[1]//div[3]//div[1]//div[1]//div[1]//div[2]//button[2]")).click();
        }
        driver.findElement(By.xpath("//button[normalize-space()='Tamam']")).click();

        //Search
        driver.findElement(By.xpath("//button[@class='primary-btn block']")).click();

        //Waiting for the page to load completely
        Thread.sleep(6000);

        //Change the listing
        driver.findElement(By.xpath("//select[@class='custom-select ctx-sort']")).click();
        for (int k = 1; k <= 1; k++){
            driver.findElement(By.xpath("//select[@class='custom-select ctx-sort']")).sendKeys(Keys.ARROW_DOWN);
        }
        driver.findElement(By.xpath("//select[@class='custom-select ctx-sort']")).sendKeys(Keys.ENTER);

        //Choosing flight
        driver.findElement(By.xpath("//div[@class='flight-list flight-list-departure isOneWay domesticList']//div[1]//div[1]//div[2]//div[1]//div[5]//button[1]//span[1]")).click();







    }
}
