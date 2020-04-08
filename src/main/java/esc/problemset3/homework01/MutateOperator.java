package esc.problemset3.homework01;


public class MutateOperator extends AbstractOperator
{
    public MutateOperator(double successRate)
    {
        super(successRate);
    }
    
    @Override
    public final void operate(char[] inputCharArray)
    {
        for (int i = 0; i < inputCharArray.length - 1; i++) {
            
            if (RANDOM.nextFloat() <= successRate)
                inputCharArray[i] = (char) (RANDOM.nextInt(95) + 32);
        }
    }
}
