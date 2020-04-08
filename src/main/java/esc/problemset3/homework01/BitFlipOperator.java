package esc.problemset3.homework01;


public class BitFlipOperator extends AbstractOperator
{
    public BitFlipOperator(double successRate)
    {
        super(successRate);
    }
    
    @Override
    public final void operate(char[] inputCharArray)
    {
        for (int i = 0; i < inputCharArray.length - 1; i++) {
            
            if (RANDOM.nextFloat() <= successRate) {
                int flipPosition = RANDOM.nextInt(7);
                
                inputCharArray[i] ^= (1 << flipPosition);
            }
        }
    }
}
