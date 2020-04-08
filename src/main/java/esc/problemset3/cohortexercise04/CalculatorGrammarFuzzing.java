package esc.problemset3.cohortexercise04;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class CalculatorGrammarFuzzing
{
    private static final Random RANDOM = ThreadLocalRandom.current();
    static int maximumNumberOfRecursions = 100;
    int numberOfRecursions;
    
    public static void main(String[] args)
    {
        final int NUMBER_OF_INPUTS_TO_GENERATE = 10;
        
        CalculatorGrammarFuzzing calculatorFuzzer = new CalculatorGrammarFuzzing();
        
        for (int i = 0; i < NUMBER_OF_INPUTS_TO_GENERATE; i++) {
            Expression expression = calculatorFuzzer.generateInput();
            
            String expressionString = expression.toString();
            
            System.out.println(expressionString);
        }
    }
    
    public Expression generateInput()
    {
        Expression expression = generateRandomExpression();
        
        numberOfRecursions = 0;
        
        boolean nonzero = false;
        
        initializeExpression(expression, nonzero);
        
        return expression;
    }
    
    public Expression generateRandomExpression()
    {
        int numberOfTypes = Expression.Type.values().length;
        
        int randomTypeIndex = RANDOM.nextInt(numberOfTypes);
        
        Expression.Type randomType = Expression.Type.values()[randomTypeIndex];
        
        return new Expression(randomType);
    }
    
    public void initializeExpression(Expression expression, boolean nonzero)
    {
        numberOfRecursions++;
        
        boolean maximumNumberOfRecursionsReached = (numberOfRecursions >= maximumNumberOfRecursions);
        
        switch (expression.type)
        {
            case EXPRESSION_PLUS_TERM:
            case EXPRESSION_MINUS_TERM:
                expression.leftHandSide = maximumNumberOfRecursionsReached
                    ? new Expression(Expression.Type.TERM)
                    : generateRandomExpression();
                
                initializeExpression(expression.leftHandSide, false);
            
            case TERM:
            default:
                expression.rightHandSide = maximumNumberOfRecursionsReached
                    ? new Term(Term.Type.FACTOR)
                    : generateRandomTerm();
                
                initializeTerm(expression.rightHandSide, nonzero);
        }
    }
    
    public Term generateRandomTerm()
    {
        int numberOfTypes = Term.Type.values().length;
        
        int randomTypeIndex = RANDOM.nextInt(numberOfTypes);
        
        Term.Type randomType = Term.Type.values()[randomTypeIndex];
        
        return new Term(randomType);
    }
    
    public void initializeTerm(Term term, boolean nonzero)
    {
        numberOfRecursions++;
        
        boolean maximumNumberOfRecursionsReached = (numberOfRecursions >= maximumNumberOfRecursions);
        
        switch (term.type)
        {
            case TERM_MULTIPLY_FACTOR:
            case TERM_DIVIDE_FACTOR:
                term.leftHandSide = maximumNumberOfRecursionsReached
                    ? new Term(Term.Type.FACTOR)
                    : generateRandomTerm();
                
                initializeTerm(term.leftHandSide, nonzero);
                
                if (term.type == Term.Type.TERM_DIVIDE_FACTOR)
                    nonzero = true;
            
            case FACTOR:
            default:
                term.rightHandSide = maximumNumberOfRecursionsReached
                    ? new Factor(Factor.Type.INTEGER)
                    : generateRandomFactor();
                
                initializeFactor(term.rightHandSide, nonzero);
        }
    }
    
    public Factor generateRandomFactor()
    {
        int numberOfTypes = Factor.Type.values().length;
        
        int randomTypeIndex = RANDOM.nextInt(numberOfTypes);
        
        Factor.Type randomType = Factor.Type.values()[randomTypeIndex];
        
        return new Factor(randomType);
    }
    
    public void initializeFactor(Factor factor, boolean nonzero)
    {
        numberOfRecursions++;
        
        boolean maximumNumberOfRecursionsReached = (numberOfRecursions >= maximumNumberOfRecursions);
        
        switch (factor.type)
        {
            case EXPRESSION:
                factor.expression = maximumNumberOfRecursionsReached
                    ? new Expression(Expression.Type.TERM)
                    : generateRandomExpression();
                
                initializeExpression(factor.expression, nonzero);
                
                break;
            
            case FLOATING_INTEGER:
                factor.rightHandSide = maximumNumberOfRecursionsReached
                    ? new Integer(Integer.Type.DIGIT)
                    : generateRandomInteger();
                
                initializeInteger(factor.rightHandSide, nonzero);
            
            case NEGATIVE_INTEGER:
            case INTEGER:
            default:
                factor.leftHandSide = maximumNumberOfRecursionsReached
                    ? new Integer(Integer.Type.DIGIT)
                    : generateRandomInteger();
                
                initializeInteger(factor.leftHandSide, nonzero);
        }
    }
    
    public Integer generateRandomInteger()
    {
        int numberOfTypes = Integer.Type.values().length;
        
        int randomTypeIndex = RANDOM.nextInt(numberOfTypes);
        
        Integer.Type randomType = Integer.Type.values()[randomTypeIndex];
        
        return new Integer(randomType);
    }
    
    public void initializeInteger(Integer integer, boolean nonzero)
    {
        numberOfRecursions++;
        
        boolean maximumNumberOfRecursionsReached = (numberOfRecursions >= maximumNumberOfRecursions);
        
        switch (integer.type)
        {    
            case INTEGER_DIGIT:
                integer.leftHandSide = maximumNumberOfRecursionsReached
                    ? new Integer(Integer.Type.DIGIT)
                    : generateRandomInteger();
                
                boolean isDigit = integer.leftHandSide.type == Integer.Type.DIGIT;
                
                initializeInteger(integer.leftHandSide, isDigit);
            
            case DIGIT:
            default:
                integer.rightHandSide = generateRandomDigit(nonzero);
                
                break;
        }
    }
    
    public Digit generateRandomDigit(boolean nonzero)
    {
        int numberOfTypes = Digit.Type.values().length;
        
        int randomTypeIndex = nonzero
            ? RANDOM.nextInt(numberOfTypes - 1) + 1
            : RANDOM.nextInt(numberOfTypes);
        
        Digit.Type randomType = Digit.Type.values()[randomTypeIndex];
        
        return new Digit(randomType);
    }
}
