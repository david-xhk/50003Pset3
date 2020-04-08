package esc.problemset3.homework01;


public class TrimOperator extends AbstractOperator
{
    public TrimOperator()
    {
        super(0.0);
    }
    
    @Override
    public final void operate(char[] inputCharArray)
    {
        int trimPosition = RANDOM.nextInt(inputCharArray.length - 1);
        
        inputCharArray[trimPosition] = '\0';
    }
}
