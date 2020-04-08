package esc.problemset3.cohortexercise06.palindromicsolution;

import esc.problemset3.cohortexercise06.FitnessCalculator;
import esc.problemset3.cohortexercise06.GeneticAlgorithm;
import esc.problemset3.cohortexercise06.Individual;
import esc.problemset3.cohortexercise06.Population;


public class PalindromicSolutionGA
{
    public static void main(String[] args)
    {
        final int POPULATION_SIZE = 1000;
        
        Individual.setGeneLength(64);
        GeneticAlgorithm.crossoverRate = 0.5;
        GeneticAlgorithm.mutationRate = 0.01;
        GeneticAlgorithm.tournamentSize = 20;
        
        // Create an instance of the fitness calculator
        FitnessCalculator fitnessCalculator = new PalindromicSolutionFitnessCalculator();
        
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
