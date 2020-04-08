package esc.problemset3.cohortexercise06;


public class Population
{
    Individual[] individuals;
    
    public Population(int populationSize)
    {
        individuals = new Individual[populationSize];
    }
    
    public Population(int populationSize, FitnessCalculator fitnessCalculator)
    {
        this(populationSize);
        
        // Loop and create individuals
        for (int i = 0; i < size(); i++) {
            Individual newIndividual = new Individual();
            
            newIndividual.initializeGenes();
            
            newIndividual.setFitnessCalculator(fitnessCalculator);
            
            saveIndividual(i, newIndividual);
        }
    }
    
    public Individual getIndividual(int index)
    {
        return individuals[index];
    }
    
    public Individual getFittest()
    {
        Individual fittest = individuals[0];
        
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness())
                fittest = getIndividual(i);
        }
        
        return fittest;
    }
    
    public int size()
    {
        return individuals.length;
    }
    
    public void saveIndividual(int index, Individual individual)
    {
        individuals[index] = individual;
    }
}
