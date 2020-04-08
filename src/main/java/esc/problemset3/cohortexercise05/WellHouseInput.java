package esc.problemset3.cohortexercise05;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class WellHouseInput
{
    private static final Random RANDOM = ThreadLocalRandom.current();
    
    public static void main(String[] args)
    {
        final int NUMBER_OF_ITERATIONS = 1000;
        
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            foo();
        }
    }
    
    public static void foo()
    {
        float yesterday = WellHouseInput.readNumber();
        
        float today = WellHouseInput.readNumber();
        
        if (yesterday > today) {
            System.out.println("Covered: yesterday > today");
        }
        
        else {
            if (yesterday != today) {
                System.out.println("Covered: yesterday != today");
            }
            
            else {
                System.out.println("Covered: yesterday == today");
            }
        }
    }
          
    public static float readNumber()
    {
        return RANDOM.nextFloat();
    }
}

