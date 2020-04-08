package esc.problemset3.cohortexercise01;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class MonkeyTestISTD
{
    private static final Random RANDOM = ThreadLocalRandom.current();
    private static final String WEBPAGE_TO_VISIT = "https://istd.sutd.edu.sg/";
    private static final int TIMEOUT_MILLIS = 1000;
    private static final int NUMBER_OF_LINKS_TO_VISIT_RANDOMLY = -1; // set -1 to visit random links indefinitely
    
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
    public void visitWebpage_AndVisit_AllLinks_Randomly()
        throws InterruptedException
    {
        driver.get(WEBPAGE_TO_VISIT);
        
        // get all the links
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        
        // print all the links
        for (int i = 0; i < links.size(); i++) {
            System.out.println(i + " " + links.get(i).getText());
            System.out.println(i + " " + links.get(i).getAttribute("href"));
        }
        
        // maximize the browser window
        driver.manage().window().maximize();
        
        // click all links in a web page randomly
        for (int j = NUMBER_OF_LINKS_TO_VISIT_RANDOMLY; j != 0; j--) {
            int i = RANDOM.nextInt(links.size());
            
            String link = links.get(i).getAttribute("href");
            
            if (link == null)
                continue;
            
            System.out.println("*** Navigating to " + link);
            
            //the loop checks whether the elements is properly loaded
            while (true) {
                try {
                    //navigate to the link
                    driver.navigate().to(link);
                    pause();
                    
                    System.out.println("*** Navigated to " + link);
                    
                    //click the back button in browser
                    driver.navigate().back();
                    pause();
                    
                    links = driver.findElements(By.tagName("a"));
                    pause();
                    
                    break;
                }
                
                catch (StaleElementReferenceException exception) { }
            }
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
}
