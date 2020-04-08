package esc.problemset3.homework01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class MutationFuzzing
{
    private static final Random RANDOM = ThreadLocalRandom.current();
    List<Operator> operators = new ArrayList<>();
    
    public final MutationFuzzing addOperator(Operator operator)
    {
        operators.add(operator);
        
        return this;
    }
    
    public int numberOfOperators()
    {
        return operators.size();
    }
    
    private Operator chooseRandomOperator()
    {
        int numberOfOperators = operators.size();
        
        if (numberOfOperators == 0)
            throw new IllegalStateException("no operators added yet");
        
        int operatorIndex = (numberOfOperators == 1)
            ? 0 : RANDOM.nextInt(numberOfOperators);
        
        return operators.get(operatorIndex);
    }
    
    public void fuzzify(String inputFilename, String outputFilename)
        throws IOException
    {
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename));
        ) {
            while (reader.ready()) {
                char[] charBuffer = reader.readLine().toCharArray();
                
                Operator operator = chooseRandomOperator();
                
                operator.operate(charBuffer);
                
                writer.write(charBuffer);
                
                writer.newLine();
            }
        }
        
        catch (FileNotFoundException exception) {
            throw new IllegalArgumentException("file not found: " + inputFilename);
        }
    }
}
