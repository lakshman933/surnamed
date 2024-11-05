package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignPage {
	public WebDriver ldriver;
	public SignPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement pwd;
	
	@FindBy (xpath="//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/div/div[2]/form/div[4]/button")//button[@id='submitButton']   // If the button has an id

    WebElement submit;
	
	@FindBy(xpath="//*[@id=\"reportedByLocation\"]")
	WebElement Dashboard;
	
	
	
	//email
	

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/div/div[2]/h3")
	WebElement LoginPage;
	
	public void getloginpage() throws Exception {
		
		Thread.sleep(2000);
    	String expected="Please enter your Customer login credentials.";
    	String actual=LoginPage.getText();
    	Assert.assertEquals(actual,expected);
    	Thread.sleep(2000);
	}
	
	
	public void set_email(String Email) {
		
		email.sendKeys(Email);
		
	}
	
	public void set_password(String Password) {
		pwd.sendKeys(Password);
	}
	
	public void Set_submit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(ldriver, 5);  // 5 seconds timeout
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/div/div[2]/form/div[4]/button")));
		
				                                                                                                                                         

		submit.click();
	}
	
	public void Dash_board() throws InterruptedException {
		Thread.sleep(5000);
		String expected = "Dashboard";
		String actual = Dashboard.getText();
		Assert.assertEquals(actual, expected);
	}

}
