package esc.problemset3.cohortexercise06;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class GeneticAlgorithm
{
    private static final Random RANDOM = ThreadLocalRandom.current();
    public static double crossoverRate = 0.5;
    public static double mutationRate = 0.015;
    public static int tournamentSize = 5;
    public static boolean isElitist = true;
    
    public static Population evolvePopulation(Population population, FitnessCalculator fitnessCalculator)
    {
        Population newPopulation = new Population(population.size());
        
        // Keep our best individual
        if (isElitist)
            newPopulation.saveIndividual(0, population.getFittest());
        
        int elitismOffset = isElitist ? 1 : 0;
        
        for (int i = elitismOffset; i < population.size(); i++) {
            
            // Loop over the population size and create new individuals with
            // crossover
            Individual newIndividual = crossover(
                tournamentSelection(population), 
                tournamentSelection(population));
            
            newIndividual.setFitnessCalculator(fitnessCalculator);
            
            newPopulation.saveIndividual(i, newIndividual);
        }
        
        // Mutate population
        for (int i = elitismOffset; i < newPopulation.size(); i++)
            mutate(newPopulation.getIndividual(i));
        
        return newPopulation;
    }
    
    private static Individual crossover(Individual individual1, Individual individual2)
    {
        Individual newSol = new Individual();
        
        for (int i = 0; i < individual1.size(); i++)
            
            // Crossover
            newSol.setGene(i, (RANDOM.nextFloat() <= crossoverRate)
                ? individual1.getGene(i)
                : individual2.getGene(i));
        
        return newSol;
    }
    
    private static void mutate(Individual individual)
    {
        for (int i = 0; i < individual.size(); i++) {
            
            if (RANDOM.nextFloat() <= mutationRate)
                // Create random gene
                individual.setGene(i, (char) (RANDOM.nextInt(95) + 32));
        }
    }
    
    private static Individual tournamentSelection(Population population)
    {
        // Create a tournament population
        Population tournament = new Population(tournamentSize);
        
        for (int i = 0; i < tournamentSize; i++)
            
            // For each place in the tournament get a random individual
            tournament.saveIndividual(i,
                population.getIndividual(RANDOM.nextInt(population.size())));
        
        // Return fittest individual
        return tournament.getFittest();
    }
}
