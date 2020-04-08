package esc.problemset3.homework01;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public abstract class AbstractOperator
    implements Operator
{
    protected static final Random RANDOM = ThreadLocalRandom.current();
    
    public AbstractOperator(double successRate)
    {
        setSuccessRate(successRate);
    }
    
    protected double successRate;
    
    public double getSuccessRate()
    {
        return successRate;
    }
    
    public void setSuccessRate(double successRate)
    {
        this.successRate = successRate;
    }
}
