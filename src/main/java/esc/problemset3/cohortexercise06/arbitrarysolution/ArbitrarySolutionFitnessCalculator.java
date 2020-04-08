package esc.problemset3.cohortexercise06.arbitrarysolution;

import esc.problemset3.cohortexercise06.FitnessCalculator;
import esc.problemset3.cohortexercise06.Individual;


public class ArbitrarySolutionFitnessCalculator
    implements FitnessCalculator
{
    static int solutionLength = 64;
    char[] solution;
    
    ArbitrarySolutionFitnessCalculator(char[] solution)
    {
        this.solution = new char[solutionLength];
        
        setSolution(solution);
    }
    
    ArbitrarySolutionFitnessCalculator(String newSolution)
    {
        this(newSolution.toCharArray());
    }
    
    public static void setSolutionLength(int length)
    {
        solutionLength = length;
    }
    
    public void setSolution(char[] newSolution)
    {
        for (int i = 0; i < solutionLength; i++)
            solution[i] = (i < newSolution.length)
                ? newSolution[i]
                : ' ';
    }
    
    // Calculate fitness of individual by comparing it to our candidate solution
    @Override
    public int getFitness(Individual individual)
    {
        int fitness = 0;
        
        // Loop through our individuals genes and compare them to our candidates
        for (int i = 0; i < individual.size(); i++)
            fitness -= Math.abs(individual.getGene(i) - solution[i]);
        
        return fitness;
    }
    
    // Get optimum fitness
    @Override
    public int getMaxFitness()
    {
        return 0;
    }
}
