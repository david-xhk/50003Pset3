package esc.problemset3.homework01.examples;

import java.io.IOException;
import esc.problemset3.homework01.*;


public class TrimSwapFuzzifier
{
    public static void main(String[] args)
        throws IOException
    {
        if (args.length != 2) {
            System.out.println("expected 2 arguments: inputFilename outputFilename");
            
            return;
        }
        
        double swapRate = 0.3;
        String inputFilename = args[0];
        String outputFilename = args[1];
        
        new MutationFuzzing()
            .addOperator(new TrimOperator())
            .addOperator(new SwapOperator(swapRate))
            .fuzzify(inputFilename, outputFilename);
    }
}
