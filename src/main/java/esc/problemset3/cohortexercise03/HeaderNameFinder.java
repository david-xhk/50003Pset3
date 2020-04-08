package esc.problemset3.cohortexercise03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HeaderNameFinder
{
    private static final String WEBPAGE_TO_VISIT = "https://istd.sutd.edu.sg/";
    private static final int TIMEOUT_MILLIS = 1000;
    
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
    public void checkIf_AllLinks_HaveTitle()
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
        
        // click all links in a web page
        for (int i = 0; i < links.size(); i++) {
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
                    
                    if (driver.getTitle() == null || driver.getTitle().isEmpty())
                        fail("Found link to webpage that has empty title: " + link);
                    
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
