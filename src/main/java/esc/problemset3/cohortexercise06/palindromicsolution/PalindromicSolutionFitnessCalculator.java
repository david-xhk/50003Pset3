package esc.problemset3.cohortexercise06.palindromicsolution;

import esc.problemset3.cohortexercise06.FitnessCalculator;
import esc.problemset3.cohortexercise06.Individual;


public class PalindromicSolutionFitnessCalculator
    implements FitnessCalculator
{
    // Calculate fitness of individual by checking how palindromic it is
    @Override
    public int getFitness(Individual individual)
    {
        int fitness = 0;
        
        // Loop through our individuals genes and check how palindromic it is
        for (int i = 0, j = individual.size() - 1; i < individual.size() / 2; i++, j--)
            fitness -= Math.abs(individual.getGene(i) - individual.getGene(j));
        
        return fitness;
    }
    
    // Get optimum fitness
    @Override
    public int getMaxFitness()
    {
        return 0;
    }
}
