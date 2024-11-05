package stepdefination;

import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import pageobject.Gallery;
import pageobject.GrivPage;
import pageobject.SignPage;

public class BaseClass {
	public static WebDriver driver;
	public SignPage sp;
	public GrivPage Gv;
	public Gallery Gr;
	public static Properties configProp;
	
	
	public String generateRandomAlphaNumeric(int length) 
    {
        char[] chars ="1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ/-.".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randomString = sb.toString();
        return randomString;
    }

 public String generateRandomNumber(int length) 
    {
        char[] chars ="1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randomString = sb.toString();
        return randomString;
    }
}


