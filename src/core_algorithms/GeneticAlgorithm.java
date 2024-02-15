package core_algorithms;
// Implement generic elements of the algorithm that are independent of any specific problem
// <G> represents generic type for

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class GeneticAlgorithm<G> {
    private final int MAX_GEN;
    private final double MUTATION_RATE;
    private final double ELITISM;

    public GeneticAlgorithm(int maxGen, double mRate, double elitism) {
        this.MAX_GEN = maxGen;
        this.MUTATION_RATE = mRate;
        this.ELITISM = elitism;
    }

    public Individual<G> evolve (List<Individual<G>> initPopulation){
        List<Individual<G>> population = initPopulation;

        // Build offspring list and generate child to add to list
        for (int generation=1; generation<=MAX_GEN; generation++){
            List<Individual<G>> offspring = new ArrayList<>();
            for(int i=0; i<population.size(); i++){
                Individual<G> parent1 = selectParent(population);
                // Implement same method again, but this time we take parent1 as a second argument, allowing us to
                // choose a second parent that is NOT parent1
                Individual<G> parent2 = selectParent(population, parent1);
                Individual<G> child = reproduce(parent1, parent2);
                if (new Random().nextDouble() <= MUTATION_RATE){
                    child = mutate(child);
                }
                offspring.add(child);
            }
            Collections.sort(population);
            Collections.sort(offspring);
            List<Individual<G>> newPopulation = new ArrayList<>();
            int e = (int) (ELITISM * population.size()); // select a percentage of the population, using our ELITISM %
            for(int i=0; i<e; i++){
                newPopulation.add(population.get(i));
            }
            for(int i=0; i<population.size()-e; i++) {
                newPopulation.add(offspring.get(i));
            }
            population = newPopulation;
        }
        Collections.sort(population);
        return population.getFirst();
    }

    // TODO: implement reproduce, mutate, and calculateFitnessScore abstract methods
    // Should be in the problem specific class (GeneticAlgorithm_TSP)
    public abstract Individual<G> reproduce(Individual<G> parent1, Individual<G> parent2);
    public abstract Individual<G> mutate(Individual<G> i );
    public abstract double calculateFitnessScore(List<G> chromosome);
    public Individual<G> selectParent(List<Individual<G>> population){
        // TODO: Implement this method here
    }

    // Reload: Should check that the second selected parent is not the same as the first selected parent
    // THIS SECTION IS OPTIONAL
    public Individual<G> selectParent(
            List<Individual<G>> population, Individual<G> parent1){
    }
}
