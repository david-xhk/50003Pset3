package esc.problemset3.cohortexercise12;

import java.util.Date;


public class exercise4
{
    public static void main (String[] args)
        throws InterruptedException
    {
        CalendarSubclass cal1 = new CalendarSubclass();
        cal1.setTime(new Date());
        Thread.sleep(1000);
        
        CalendarSubclass cal2 = new CalendarSubclass();
        cal2.setTime(new Date());
        
        System.out.println(cal2.after(cal1));
        
        System.out.println(cal1.after(cal2));
        
        System.out.println(cal1.after(cal1));
        
        System.out.println(cal2.after(cal2));
    }
}
