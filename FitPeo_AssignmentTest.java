package Fitpeo_Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class FitPeo_AssignmentTest {

	public static void main(String[] args) {
		// Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions(); // Customize Chrome browser settings.
        options.addArguments("--remote-allow-origins=*");
        options.setBinary("C:\\Users\\kanchan Lonarkar\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to the FitPeo homepage
            driver.get("https://www.fitpeo.com/home");
            driver.manage().window().maximize();

            // Navigate to the Revenue Calculator page
            driver.findElement(By.linkText("Revenue Calculator")).click();
            Thread.sleep(2000);

            // Scroll down to the slider section
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 300);");
            //Thread.sleep(2000);

            // Adjust the slider to the value 820
            WebElement slider = driver.findElement(By.xpath("//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-sy3s50']"));
            Actions actions = new Actions(driver);
            actions.clickAndHold(slider).moveByOffset(94, 0).release().perform();
            Thread.sleep(2000);

           
            
            // Update the text field to 560
            WebElement textField1 = driver.findElement(By.id(":r0:")); // Update this XPath as needed
            textField1.sendKeys(Keys.END);
            textField1.sendKeys(Keys.CONTROL + "a");
            textField1.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(2000);
            textField1.sendKeys("560");
            Thread.sleep(2000);

            // Validate the slider value
            String sliderValue = textField1.getAttribute("value");
            if (!sliderValue.equals("560")) {
                System.out.println("Slider value validation failed.");
            }

            // Scroll down by a certain amount of pixels
	           js.executeScript("window.scrollBy(0, 300);"); 
	           
            // Select CPT Codes checkboxes
            driver.findElement(By.xpath("//div[@class='MuiBox-root css-rfiegf']//div[1]//label[1]//span[1]//input[1]")).click();
         // Locate the checkbox element
            WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

            // Click the checkbox if it's not already selected
            if (!checkbox2.isSelected()) {
                checkbox2.click();
            }
            
         // Locate the checkbox element
            WebElement checkbox3 = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
            // Click the checkbox if it's not already selected
            if (!checkbox3.isSelected()) {
                checkbox3.click();
            }
           

            // Validate Total Recurring Reimbursement
            WebElement reimbursementHeader = driver.findElement(By.xpath("(//div[@class='MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular css-1lnu3ao'])[1]"));
            if (reimbursementHeader == null) {
                System.out.println("Total Recurring Reimbursement validation failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the WebDriver
           driver.quit();
        }
    }
}



