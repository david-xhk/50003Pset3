package esc.problemset3.cohortexercise02;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginBotWithInvalidValidUser
{
    private static final Random RANDOM = ThreadLocalRandom.current();
    private static final String WEBPAGE_TO_VISIT = "https://statcounter.com/login/";
    private static final int NUMBER_OF_INVALID_USERNAMES_TO_TEST = 1;
    private static final int USERNAME_MIN_LENGTH = 10;
    private static final int USERNAME_MAX_LENGTH = 50;
    private static final int TIMEOUT_MILLIS = 1000;
    private static final String MY_USERNAME = "escistd50.003";
    private static final String MY_PASSWORD = "SUTD@Singapore";
    private static final String ID_TO_CHECK = "project-name-p12207705";
    
    static WebDriver driver;
    
    @BeforeAll
    public static void setUpBeforeAll()
    {
        System.setProperty("webdriver.gecko.driver",
            "/Users/user/Desktop/50.003 Elements of Software Construction/problem_set_3/bin/geckodriver");
        
        driver = new FirefoxDriver();
    }
    
    @AfterAll
    public static void tearDownAfterAll()
    {
        driver.close();
    }
    
    @Test
    public void visitWebpage_AndLoginWith_InvalidUserName_N_Times()
    {
        driver.get(WEBPAGE_TO_VISIT);
        
        for (int i = 0; i < NUMBER_OF_INVALID_USERNAMES_TO_TEST + 1; i++) {
            // get the user name field of the account page
            WebElement username = driver.findElement(By.id("username"));
            pause();
            
            username.clear();
            pause();
            
            // send my user name to fill up the box
            String userNameToSend = (i == NUMBER_OF_INVALID_USERNAMES_TO_TEST
                ? MY_USERNAME : createRandomUserName());
            
            username.sendKeys(userNameToSend);
            pause();
            
            // locate the "Next" button in the account page
            WebElement password = driver.findElement(By.id("password"));
            pause();
            
            //write password
            password.sendKeys(MY_PASSWORD);
            pause();
            
            // login and submit
            WebElement submit = driver.findElement(By.className("submit"));
            pause();
            
            submit.click();
            pause();
        }
        
        // explicitly wait until element with the id to check is present in the page
        try {
            new WebDriverWait(driver, TIMEOUT_MILLIS / 1000)
                // wait only until the page loads
                .until(ExpectedConditions.elementToBeClickable(By.id(ID_TO_CHECK)));
            
            // click element with the id to check
            driver.findElement(By.id(ID_TO_CHECK)).click();
            pause();
        }
        
        catch (TimeoutException exception) {
            System.out.println("login/password name invalid");
        }
    }
    
    public static void pause()
    {
        try {
            Thread.sleep(TIMEOUT_MILLIS);
        }
        
        catch (InterruptedException exception) {
            return;
        }
    }
    
    public static String createRandomUserName()
    {
        int userNameLength = USERNAME_MIN_LENGTH + 
            RANDOM.nextInt(USERNAME_MAX_LENGTH - USERNAME_MIN_LENGTH);
        
        char[] userNameCharArray = new char[userNameLength];
        
        for (int i = 0; i < userNameLength; i++)
            userNameCharArray[i] = (char) (RANDOM.nextInt(95) + 32);
        
        return String.valueOf(userNameCharArray);
    }
}
