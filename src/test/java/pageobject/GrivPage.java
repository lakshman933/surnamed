package pageobject;



import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepdefination.BaseClass;

public class GrivPage extends BaseClass {

  public WebDriver ldriver;
  public GrivPage(WebDriver rdriver)
  {
	  ldriver = rdriver;
	  PageFactory.initElements(rdriver, this);
  }
//span[contains(text(), 'Panchayati Raj, Rural Development & Rural Water Supply; Environment, Forest, Science & Technology (GOAP)')]

  
  @FindBy(xpath="//a[@aria-controls=\"Grievances\"]")
  WebElement clickGrievances;
  
  @FindBy (xpath="//*[@id=\"Grievances\"]/ul/a/a/span")
  WebElement clickonMYGrievances;
  
  @FindBy (xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[1]/div/div/div[1]/div[2]")
  WebElement complaintcategory;
  
  @FindBy (xpath="//*[@id=\"app\"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[3]/div/div[1]/div/div/div[1]/div[2]")
  WebElement Mandal;
  
  @FindBy (xpath="//*[@id=\"app\"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[4]/div/div[1]/div/div/div[1]/div[2]")
  WebElement Area;
  
  @FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div[1]/div[1]/div[2]/div[3]/div[2]/div/div[1]")
  WebElement Fullname;
  
  @FindBy(xpath= "event-organizer")
  WebElement Mobileno;
  
  @FindBy(xpath="//*[@id=\"event-organizer\"]")
  WebElement Gemail;
  
  @FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div[1]/form/div[2]/div[1]")
  WebElement complaintDetails;

  @FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div[2]/div/button[1]")
  WebElement Record;
  
  @FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div[2]/div/button[2]/svg")
  WebElement Upload;
  
  @FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/submit")
  WebElement complaint;
  
  
  public void click_Grievance() throws InterruptedException {
	  Thread.sleep(5000);
	  clickGrievances.click();
	  
  }
  public void clickon_MYGrievances() throws InterruptedException {
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  Thread.sleep(3000);
	  clickonMYGrievances.click();
	  
  }
  
  
  
 
  public void complaint_category() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, 15);
	    
	    try {
	        // Locate the drop down element and wait until it's visible
	        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'el-select__selected-item') and contains(@class, 'el-select__placeholder')]")));
	        
	        // Click the drop down to open it
	        dropdownElement.click();
	        Thread.sleep(3000);       
	        // Wait for the options to be present after clicking the dropdown
	        WebElement complaintCategory = driver.findElement(By.cssSelector("#app > div > div.main-content > div > div.content-wrapper > div:nth-child(1) > div.px-3 > div.row.justify-content-around > div > div > div.has-label > div > div > div.el-select__selection > div.el-select__selected-item.el-select__placeholder.is-transparent:"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", complaintCategory);

	        List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class, 'el-select__selected-item') and contains(@class, 'el-select__placeholder')]")); // Adjust this selector
	      //div[contains(@class, 'el-select__selected-item') and contains(@class, 'el-select__placeholder')]

	        // Check the number of options available
	        int numberOfOptions = options.size();
	        System.out.println("Number of options: " + numberOfOptions);
	        
	        if (numberOfOptions > 1) {
	            // Generate a random index to select a random option
	            int randomIndex = new Random().nextInt(numberOfOptions);
	            
	            // Click the randomly selected option
	            options.get(randomIndex).click();
	            
	            // Log the selected index
	            System.out.println("Selected Index: " + randomIndex);
	        } else if (numberOfOptions == 1) {
	            // If there's only one option, click it
	            options.get(2).click();
	            System.out.println("Only one option available, selected Index: 0");
	        } else {
	            // If no options are available
	            System.out.println("No options available in the dropdown");
	        }
	        
	    } catch (TimeoutException e) {
	        // Handle timeout exception
	        System.err.println("Timeout waiting for dropdown element: " + e.getMessage());
	    } catch (Exception e) {
	        // Handle other exceptions and log errors
	        System.err.println("Error in complaint_category: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	  
	

  public void M_andal() throws InterruptedException {
	  Thread.sleep(3000);
	  Mandal.click();
  }
  public void A_rea() throws InterruptedException {
	  Thread.sleep(3000);
	  Area.click();
  }
  public void Full_name(String fullname) throws InterruptedException {
	  Thread.sleep(3000);
	 Fullname.sendKeys(fullname);
	  
   }
  public void Mobile_no(String phoneno) throws InterruptedException {
	  Thread.sleep(3000);
	  Mobileno.sendKeys(phoneno);
  }
  
  public void Ge_mail(String email) throws InterruptedException {
	  Thread.sleep(3000);
	  Gemail.sendKeys(email);
  }
  
  public void complaint_Details(String Details) throws InterruptedException {
	  Thread.sleep(3000);
	  complaintDetails.sendKeys(Details);
  }
  
  public void R_ecord() throws InterruptedException {
	  Thread.sleep(3000);
	  Record.click();
  }
  public void U_pload() throws InterruptedException {
	  Thread.sleep(3000);
	  Upload.click();
  }
  
  public void compla_int() throws InterruptedException {
	  Thread.sleep(3000);
	  complaint.click();
  }

}
