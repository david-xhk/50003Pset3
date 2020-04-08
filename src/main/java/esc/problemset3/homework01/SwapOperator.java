package esc.problemset3.homework01;


public class SwapOperator extends AbstractOperator
{
    public SwapOperator(double successRate)
    {
        super(successRate);
    }
    
    @Override
    public final void operate(char[] inputCharArray)
    {
        for (int i = 0; i < inputCharArray.length - 1; i++) {
            
            if (RANDOM.nextFloat() <= successRate) {
                int swapPosition = i + RANDOM.nextInt(inputCharArray.length - 1 - i);
                
                char temp = inputCharArray[swapPosition];
                
                inputCharArray[swapPosition] = inputCharArray[i];
                
                inputCharArray[i] = temp;
            }
        }
    }
}
