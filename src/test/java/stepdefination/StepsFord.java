package stepdefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Gallery;
import pageobject.GrivPage;
import pageobject.SignPage;

public class StepsFord extends BaseClass {
    long start = System.currentTimeMillis(); // For page load

    @Before(order = 1)
    public void setUp() throws IOException {

        configProp = new Properties(); // Reading Config Properties File
        FileInputStream configPropfile = new FileInputStream("config.properties"); // Loading Config Properties File
        configProp.load(configPropfile);

        String br = configProp.getProperty("browser");
        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            System.out.println("Chrome Browser Launched Successfully");
        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpth"));
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            System.out.println("Firefox launched successfully");
        } else if (br.equals("edge")) {
            System.setProperty("webdriver.edge.driver", configProp.getProperty("edge"));
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
            driver.manage().window().maximize();
            System.out.println("Edge driver launched successfully");
        }
    }

    @After(order = 0)
    public void teardownPageloadtime() {
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        System.out.println("Total time to page load - " + totalTime);
    }

    // Sign Page Object
    SignPage sp;

    @Given("User Launch Chrome Browser")
    public void user_launch_chrome_browser() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InterruptedException {
        sp = new SignPage(driver);
        Gv =new GrivPage(driver);
        Gr =  new Gallery(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String Url) throws InterruptedException {
        Thread.sleep(1000);
        driver.get(Url);
        System.out.println("URL opened successfully");

        // Assertion: Verify that the correct URL is opened
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, Url, "URL does not match!");
    }

    @When("User enters Username as {string} and Password as {string}")
    public void user_enters_username_as_and_password_as(String Email, String Password) throws InterruptedException {
        sp.set_email(Email);
        sp.set_password(Password);
        System.out.println("Username and Password entered");

        // Assertion: Verify the fields are not empty
        Assert.assertFalse(Email.isEmpty(), "Email field is empty");
        Assert.assertFalse(Password.isEmpty(), "Password field is empty");
    }

    @When("click on signin button")
    public void click_on_signin_button() throws InterruptedException {
        System.out.println("Inside Step - clicks on signin button");
        sp.Set_submit();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }
        


       @Then("User should redirect to dashboard")
       public void user_should_redirect_to_dashboard() {
            // Add assertions to verify if the user is redirected to the dashboard
            String expectedUrl = "https://example.com/dashboard";
            Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User did not redirect to dashboard.");
        
        

        // Alternatively, you can check for an element specific to the dashboard:
        // Assert.assertTrue(sp.dashboardElement.isDisplayed(), "Dashboard is not visible");
    }

    //lg3
       

@When("User enters Username as {string}")
public void user_enters_username_as(String Email) {
   sp.set_email("Dilli");
}
@Then("User should see Invlid error msg")
public void user_should_see_invlid_error_msg() {
    String expectedURl = "Alert mess";
    String actualURL ="Alert mess";
    Assert.assertEquals(driver.getCurrentUrl(), expectedURl,"message");
    
}

//lg4


@When("User enters Password as {string}")
public void user_enters_password_as(String string) throws InterruptedException {
   sp.set_password("Pass@123");
}


@Then("User verifies the alert message is {string}")
public void user_verifies_the_alert_message_is(String string) {
	Alert alert = driver.switchTo().alert();
    String alertText = alert.getText();
    System.out.println("Alert message: " + alertText);
    alert.accept(); // Accepting the alert
}
@Then("User accepts the alert")
public void user_accepts_the_alert() {
	 Alert alert = driver.switchTo().alert();
     String alertText = alert.getText();
     System.out.println("Alert message: " + alertText);
     alert.accept(); // Accepting the alert
}



//Giverance


@Then("click on Grievance")
public void click_on_grievance() throws InterruptedException {
	System.out.println("click on  Grev");
    Gv.click_Grievance();
}

@Then("click on My Grievance")
public void click_on_my_grievance() throws InterruptedException {
	System.out.println("click on my grivence");
    Gv.clickon_MYGrievances();
   
   
}

@Given("I open Chrome with microphone permissions")
public void i_open_chrome_with_microphone_permissions() {
	 {
	        // Create a ChromeOptions instance
		 ChromeOptions options = new ChromeOptions();

	        // Use ChromeOptions to set the microphone permission directly
	        options.addArguments("--use-fake-ui-for-media-stream"); // Automatically allow microphone

	        // Set up WebDriver with ChromeOptions
	    //    System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
	      //  driver = new ChromeDriver(options);

	        // Open the web site that requires microphone access
	     //   driver.get("https://central-grievance-web-app.pages.dev/dashboard");

	        // Now Chrome will automatically accept microphone permission requests
	    }
	}



	


@Then("click on complaint category")
public void click_on_complaint_category() throws InterruptedException {
	Thread.sleep(3000);
	WebElement dropdown = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/div/div[1]/div/div/div[1]/div[2]"));  // Adjust the locator
	Select dropdown1 = new Select(dropdown);
	
	dropdown1.selectByIndex(1);
	System.out.println("click on complaint");
	Gv.complaint_category();
}
	



@Then("click on Mandal")
public void click_on_mandal() throws InterruptedException {
	System.out.println("clcik on mandal");
	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\\\"app\\\"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[3]/div/div[1]/div/div/div[1]/div[2]"));  // Adjust the locator
	Select dropdown1 = new Select(dropdown);
	
	dropdown1.selectByIndex(1);
	Thread.sleep(3000);
    
    System.out.println("Selected option: " +dropdown);
    
}

@Then("click on Area")
public void click_on_area() throws InterruptedException {
	System.out.println("clcik on complaint");
	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\\\"app\\\"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[4]/div/div[1]/div/div/div[1]/div[2]"));  // Adjust the locator
	Select dropdown1 = new Select(dropdown);
	
	dropdown1.selectByIndex(1);
	Thread.sleep(3000);
    
    System.out.println("Selected option: " +dropdown);
   
}

@When("User enter the Name {string}")
public void user_enter_the_name(String string) throws InterruptedException {
	Thread.sleep(3000);
    Gv.Full_name("sai");
}

@Then("User enter the  Phone No {string}")
public void user_enter_the_phone_no(String string) throws InterruptedException {
    Thread.sleep(5000);
    Gv.Mobile_no("855584247");
}

@Then("User enter the Complaint Deatails {string}")
public void user_enter_the_complaint_deatails(String string) throws InterruptedException {
  Gv.complaint_Details("cleaning");

}

@Then("click on Record")
public void click_on_record() throws InterruptedException {
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	

    Gv.R_ecord();
}

@Then("click on the upload the photo")
public void click_on_the_upload_the_photo() throws InterruptedException {
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

   Gv.U_pload();
}

@Then("click on  create on complaint")
public void click_on_create_on_complaint() throws InterruptedException {

	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	Gv.compla_int();

}

//gallery------


@Then("click on Gallery")
public void click_on_gallery() throws InterruptedException {
   System.out.println("click on gallery");
   driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
   Gr.g_allery();
   
}

@Then("click on Gallery Add")
public void click_on_gallery_add() throws InterruptedException {
   System.out.println("click on gallery");
   Gr.gallery_Add();
}

@Then("click on a Gallery Mandal name for iteration {int}")
public void click_on_a_gallery_mandal_name_for_iteration( int iteration ) throws InterruptedException {
	    Gr.gallery_mandal(iteration);
	    System.out.println("gallery mandal");
}



@Then("click on a  Gallery Area")
public void click_on_a_gallery_area() throws InterruptedException {
    System.out.println("click on gallery area");
    Gr.galley_area();
}

@When("User enter the Gallery Name {string}")
public void user_enter_the_gallery_name(String string) throws InterruptedException {
   System.out.println("Gallery name");
   Gr.gallery_name();
}

@Then("User enter the  Gallery Event")
public void user_enter_the_gallery_event() {
	System.out.println("Gallery event");
	Gr.gallery_event();
   
}

@Then("User enter the Gallery Description {string}")
public void user_enter_the_gallery_description(String string) throws InterruptedException {
   System.out.println("Gallery discription");
   Gr.gallery_decrition();
}

@Then("click on Gallery Dropdown file")
public void click_on_gallery_dropdown_file() throws InterruptedException {
    System.out.println("Galler drop down file");
    Gr.gallery_dropfile();
}

@Then("click on the Gallery save")
public void click_on_the_gallery_save() throws InterruptedException {
    System.out.println("Gallery save");
    Gr.gallery_save();
}



	
   
   
}
