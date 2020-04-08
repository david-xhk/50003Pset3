package esc.problemset3.cohortexercise06.arbitrarysolution;

import esc.problemset3.cohortexercise06.FitnessCalculator;
import esc.problemset3.cohortexercise06.GeneticAlgorithm;
import esc.problemset3.cohortexercise06.Population;


public class ArbitrarySolutionGA
{
    public static void main(String[] args)
    {
        final String SOLUTION = "http://www.ietf.org/rfc/rfc1738.txt";
        final int POPULATION_SIZE = 50;
        
        // Create an instance of the fitness calculator
        FitnessCalculator fitnessCalculator = new ArbitrarySolutionFitnessCalculator(SOLUTION);
        
        // Create an initial population
        Population myPopulation = new Population(POPULATION_SIZE, fitnessCalculator);
        
        // Evolve our population until we reach an optimum solution
        int generationCount = 0;
        
        while (myPopulation.getFittest().getFitness() < fitnessCalculator.getMaxFitness()) {
            generationCount++;
            
            System.out.println("Generation: " + generationCount + " Fittest: " + myPopulation.getFittest().getFitness());
            System.out.println("Current Fittest: " + myPopulation.getFittest());
            
            myPopulation = GeneticAlgorithm.evolvePopulation(myPopulation, fitnessCalculator);
        }
        
        System.out.println("\nSolution: " + myPopulation.getFittest());
    }
}
