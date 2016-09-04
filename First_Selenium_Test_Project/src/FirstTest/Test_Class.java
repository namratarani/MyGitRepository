package FirstTest;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Test_Class {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		// objects and variables instantiation

		System.setProperty("webdriver.chrome.driver", "C:\\LearnSelenium\\chromedriver.exe");
		WebDriver	driver = new ChromeDriver();

        String appUrl = "https://preview.debijenkorf.nl";        

//launch the Chrome browser and open the application url
        driver.get(appUrl);       

//maximize the browser window
        driver.manage().window().maximize();        

//declare and initialize the variable to store the expected title of the webpage.

        driver.findElement(By.cssSelector("input.dbk-form--field")).clear();
        driver.findElement(By.cssSelector("input.dbk-form--field")).sendKeys("jeans");
        
        driver.findElement(By.cssSelector("button.dbk-form--submit")).click();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
      //select 2nd search result
        driver.findElement(By.cssSelector("ul > li:nth-child(2) > div > a")).click();
        
        // select size from the dropdown
        Select jeanssize = new Select(driver.findElement(By.xpath("html/body/div[2]/section[2]/div[2]/div/div[3]/div[3]/div/select")));
        //jeanssize.selectByIndex(1);
        List<WebElement> alloptions = jeanssize.getOptions();
        WebElement button = driver.findElement(By.xpath("//div[@class='dbk-btn-group--dual dbk-btn-group--dual_visible-xs-condensed']/button"));
        
        for(int i=1 ;i<=alloptions.size();i++)
        {
            jeanssize.selectByIndex(i);
            if (button.getText().equalsIgnoreCase("in winkelmand"))
            {
            	System.out.println(button.getText());
            	button.click();
            	break;
            }
            
        }
        
//close the web browser

        driver.close();

        System.out.println("Test script executed successfully.");
       

        

//terminate the program

        System.exit(0);
		
	}

}
