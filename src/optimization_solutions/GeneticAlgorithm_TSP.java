package optimization_solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import core_algorithms.GeneticAlgorithm;
import core_algorithms.Individual;
import optimization_problems.TSP;

// Implement elements of the algorithm that are problem specific (In this case, Traveling Salesperson Problem specific)
public class GeneticAlgorithm_TSP extends GeneticAlgorithm<Integer>{
    private final TSP problem;
    public GeneticAlgorithm_TSP(
            int maxGen, double mRate, double elitism, TSP problem){
        super(maxGen, mRate, elitism);
        this.problem = problem;
    }

    // TODO: Implement reproduce method here:
    public Individual<Integer> reproduce(Individual<Integer> parent1, Individual<Integer> parent2) {
        return null;
    }

    // TODO: implement mutate method here
    public Individual<Integer> mutate(Individual<Integer> i) {
        return null;
    }

    public double calculateFitnessScore(List<Integer> chromosome){
        return 1/problem.cost(chromosome);
    }

    public List<Individual<Integer>> generateInitPopulation(
            int populationSize, int numberOfCities){
        // Create new empty ArrayList the same size as the population size
        List<Individual<Integer>> population =
                new ArrayList<>(populationSize);
        for(int i=0; i<populationSize; i++){
            List<Integer> chromosome = new ArrayList<>(numberOfCities);
            for(int j=0; j<numberOfCities; j++){
                chromosome.add(j);
            }
            Collections.shuffle(chromosome);
            Individual<Integer> individual = new Individual<>(
                    chromosome, calculateFitnessScore(chromosome));
            population.add(individual);
        }
        return population;
    }

    public static void main(String[] args) {
        int MAX_GEN = 200;
        double MUTATION_RATE = 0.05;
        int POPULATION_SIZE = 1000;
        int NUMBER_OF_CITIES = 26; // choose from 5, 6, 17, and 26. This chooses the case for the problem in TSP switch
        double ELITISM = 0.2;

        TSP problem = new TSP(NUMBER_OF_CITIES);

        GeneticAlgorithm_TSP agent = new GeneticAlgorithm_TSP(
                MAX_GEN, MUTATION_RATE, ELITISM, problem);
        Individual<Integer> best = agent.evolve(agent.generateInitPopulation(NUMBER_OF_CITIES, POPULATION_SIZE));

        System.out.println("Best solution: " + best);
        System.out.println("Total tour distance: " + problem.cost(best.getChromosome()));
    }
}
