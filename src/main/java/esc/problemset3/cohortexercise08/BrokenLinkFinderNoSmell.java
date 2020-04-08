package esc.problemset3.cohortexercise08;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrokenLinkFinderNoSmell
{
    // this is a function which connects to a hyperlink and returns the response message
    public static String getResponseMessage(URL hyperLink)
        throws IOException
    {
        HttpURLConnection linkConnection = (HttpURLConnection) hyperLink.openConnection();
        
        // initiate an HTTP connection
        linkConnection.connect();
        
        // check whether the connection is responding
        String response = linkConnection.getResponseMessage();
        
        // disconnect the connection link
        linkConnection.disconnect();
        
        // return response message
        return response;
    }
    
    // this is a function which checks whether a given hyper link in a web page is broken
    public static void brokenLinkChecker(URL hyperLink)
    {
        try {
            System.out.println("*** Checking link " + hyperLink.toString());
            
            String acknowledge = getResponseMessage(hyperLink);
            
            System.out.println("*** The link " + "returned " + acknowledge);
        }
        
        catch (Exception exception) {
            System.out.println("*** The link " + "is broken, message = " + null);
        }
    }
    
    // check URLs if permanently redirected
    public static boolean printIfRedirected(URL hyperLink)
    {
        try {
            String acknowledge = getResponseMessage(hyperLink);
            
            // print if redirected permanently
            return acknowledge.equals("Moved Permanently");
        }
        
        catch (Exception exception) {
            return false;
        }
    }
    
    public static void main(String[] args)
        throws Exception
    {
        System.setProperty("webdriver.gecko.driver",
            "/Users/user/Desktop/50.003 Elements of Software Construction/problem_set_3/bin/geckodriver");
        
        WebDriver driver = new FirefoxDriver();
        
        driver.get("https://sudiptac.bitbucket.io");
        
        // get all the links
        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
                
        // print all the links
        for (int i = 0; i < links.size(); i=i+1) {
            System.out.println(i + " " + links.get(i).getText());
            System.out.println(i + " " + links.get(i).getAttribute("href"));
        }
        
        // call broken link checker for all the links found
        for (int i = 0; i < links.size(); i=i+1) {
            try {
                brokenLinkChecker(new URL(links.get(i).getAttribute("href")));
            }
            
            catch (Exception exception) {
                System.out.println("This is not a proper URL to connect to " + links.get(i).getAttribute("href"));
            }
        }
    }
}
