package esc.problemset3.cohortexercise06;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Individual
{
    private static final Random RANDOM = ThreadLocalRandom.current();
    static int geneLength = 64;
    
    private char[] genes;
    private FitnessCalculator fitnessCalculator;
    private int fitness; // To cache the fitness
    
    public Individual()
    {
        genes = new char[geneLength];
    }
    
    public static void setGeneLength(int length)
    {
        geneLength = length;
    }
    
    public void initializeGenes()
    {
        for (int i = 0; i < size(); i++)
            genes[i] = (char) (RANDOM.nextInt(95) + 32);
        
        fitness = 0;
    }
    
    public char getGene(int index)
    {
        return genes[index];
    }
    
    public void setGene(int index, char value)
    {
        genes[index] = value;
        
        fitness = 0;
    }
    
    public int size()
    {
        return genes.length;
    }
    
    public FitnessCalculator getFitnessCalculator()
    {
        return fitnessCalculator;
    }
    
    public void setFitnessCalculator(FitnessCalculator fitnessCalculator)
    {
        this.fitnessCalculator = fitnessCalculator;
    }
    
    public int getFitness()
    {
        if (fitnessCalculator == null)
            throw new IllegalStateException("FitnessCalculator not set");
        
        if (fitness == 0)
            fitness = fitnessCalculator.getFitness(this);
        
        return fitness;
    }
    
    @Override
    public String toString()
    {
        return String.valueOf(genes);
    }
}
