package esc.problemset3.cohortexercise12;

import java.util.Calendar;
import java.util.Date;


/*
 * The programmer has committed a refused bequest, which refers to the inappropriate use of inheritance.
 * 
 * Instead of making CalendarSubclass a subclass of Calendar, he could implement it as a normal class that
 * wraps a Calendar and implements Comparable<CalendarSubclass>. The required behavior for after() can be
 * implemented in an instance method.
 * 
 * Also, the programmer has chosen to compare the first day of the week. This is problematic because every
 * day of the week shares the same first day of week. This will lead to false positives. Instead, the day
 * of year should be used as each day of year represents a unique date.
 */
class CalendarSubclass
    implements Comparable<CalendarSubclass>
{
    private Calendar calendar = Calendar.getInstance();
    
    public void setTime(Date date)
    {
        calendar.setTime(new Date(date.getTime()));
    }
    
    public int getDayOfYear()
    {
        return calendar.get(Calendar.DAY_OF_YEAR);
    }
    
    public boolean after(CalendarSubclass otherCalendarSubclass)
    {
        if (compareTo(otherCalendarSubclass) == 0) {
            System.out.println("lala");
            
            return true;
        }
        
        return calendar.after(otherCalendarSubclass.calendar);
    }
    
    @Override
    public int compareTo(CalendarSubclass otherCalendarSubclass)
    {
        return compareDays(getDayOfYear(), otherCalendarSubclass.getDayOfYear());
    }
    
    private int compareDays(int currentFirstDayOfWeek, int anotherFirstDayOfWeek)
    {
        return (currentFirstDayOfWeek > anotherFirstDayOfWeek) ? 1
                : (currentFirstDayOfWeek == anotherFirstDayOfWeek) ? 0 : -1;
    }
}
