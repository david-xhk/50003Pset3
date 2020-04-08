package esc.problemset3.cohortexercise11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.Normalizer;
import java.text.Normalizer.Form;


public class XSSFixed
{
    /*
     * This approach is still susceptible to XSS attacks as non-ASCII characters can be inserted into
     * the script tag. This will cause the malicious code to bypass the validation as it does not fall
     * into the blacklist. Then, after the validation, when all non-valid ASCII characters are deleted,
     * the script tag is "revived" and the malicious code can be injected into the website.
     * 
     * A possible fix is to delete all non-valid ASCII characters before normalizing the input. This way,
     * a malicious user will not be able to use the above approach to mount an XSS injection.
     * 
     * A better way to prevent XSS attacks is to use whitelisting to validate input. This means that inputs
     * that do not conform to the space of expected inputs will be invalidated by default.
     */
    public static void main(String args[])
    {
        // assume "s" is the input that may be susceptible to XSS attacks
        String s = "<Îscript>";
        //String s = "<Îscript> alert('hey there, you have been hacked') </script> ";
        //String s = "\uFE64" + "Îscript" + "\uFE65";
        
        // Delete all non-valid characters here
        s = s.replaceAll("[^\\p{ASCII}]", "");
        
        s = Normalizer.normalize(s, Form.NFKC);
        
        Pattern pattern = Pattern.compile("<script>");
        
        Matcher matcher = pattern.matcher(s);
        
        if (matcher.find()) {
            System.out.println("blacklisted tag");
        }
        
        else {
            // . . .
        }
        
        // Do not delete here
        // s = s.replaceAll("[^\\p{ASCII}]", "");
        
        System.out.println(s);
    }
}
