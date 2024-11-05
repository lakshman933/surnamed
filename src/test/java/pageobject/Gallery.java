package pageobject;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import stepdefination.BaseClass;

public class Gallery extends BaseClass {
	 public WebDriver ldriver;
	  public Gallery(WebDriver rdriver)
	  {
		  ldriver = rdriver;
		  PageFactory.initElements(rdriver, this);
	  }
	  @FindBy(xpath="//*[@id=\"app\"]/div/div[1]/div[1]/div[2]/ul/li[2]/a")
	  WebElement gallery;
	  
	  @FindBy(xpath="//*[@id=\"Gallery\"]/ul/a[1]/a/span")
	  WebElement galleryAdd;
	  
	  @FindBy(xpath="/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div/div[1]/div/div/div[1]/div[1]/input")
	  WebElement galleryManadal;
	  
	  @FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/div/div[2]/div[1]/div[4]/div/div[1]/div/div/div[1]/div[2]")
	  WebElement galleryArea;
	  
	  @FindBy(id="gallery-name")
	  WebElement galleryName;
	  
	  @FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[1]/select/option[2]")
	  WebElement galleryEvent;
	  
	  @FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/div/div[2]/div[3]/div/div/div[1]")
	  WebElement galleryDesciption;
	  
	  @FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/div/div[2]/div[4]/div/div/button")
	  WebElement galleryDropfile;
	  
	  @FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/div/div[2]/div[5]/submit")
	  WebElement gallerySave;
	  
	  
	  public void g_allery() throws InterruptedException {
		  Thread.sleep(3000);
		//driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
		  gallery.click();
	  }
	  
	  public void gallery_Add() throws InterruptedException {
		  Thread.sleep(5000);
		  galleryAdd.click();
	  }
	  
	  
	  public void gallery_mandal(int iteration)throws InterruptedException {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  try {
			    WebDriverWait wait1 = new WebDriverWait(driver, 10);  // Wait for 10 seconds
			    WebElement dropdownElement = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div > div.main-content > div > div > div > div.px-3 > div:nth-child(1) > div:nth-child(3) > div > div.has-label > div > div > div.el-select__selection > div.el-select__selected-item.el-select__placeholder.is-transparent")));
			    
			    // Optionally use JavaScript to make the element visible if still hidden
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("arguments[0].style.display='block';", dropdownElement);
			    
			    // Click or select from the drop down
			    dropdownElement.click();
			} catch (Exception e) {
			    System.out.println("Element not found or not interactable: " + e.getMessage());
			}
	  }
		  
		  
	  public void galley_area() throws InterruptedException {
		  driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		    WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"app\\\"]/div/div[2]/div/div/div/div[2]/div[1]/div[4]/div/div[1]/div/div/div[1]/div[2]")));

		    // Use Select class for standard drop downs
		    Select dropdown = new Select(dropdownElement);
		    WebElement dropdownElement1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"app\\\"]/div/div[2]/div/div/div/div[2]/div[1]/div[4]/div/div[1]/div/div/div[1]/div[2]")));

		    // Use Select class for standard drop downs
		    Select dropdown1 = new Select(dropdownElement1);
		    dropdown1.selectByVisibleText("Nandigam");
		}
	  
	  

	  public void gallery_name() throws InterruptedException {
		  driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		  Thread.sleep(2000);
		  galleryName.sendKeys("Air polluation");
	  }
	  
	  public void gallery_event() {
		  driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		  galleryEvent.click();
		  
	  }
	  public void gallery_decrition() throws InterruptedException {
		  Thread.sleep(2000);
		  galleryDesciption.click();
	  }
	  
	  public void gallery_dropfile() throws InterruptedException {
		  Thread.sleep(2000);
		  galleryDropfile.click();
	  }
	  public void gallery_save() throws InterruptedException {
		Thread.sleep(3000);
		gallerySave.click();
		  
	  }
	  
	  
}
