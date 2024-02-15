package core_algorithms;

import java.util.List;

// <G> Represents the data type of gene

public class Individual <G> implements Comparable<Individual<G>>{
    private List<G> chromosome; // Might want to make these final?
    private double fitnessScore;

    public Individual(List<G> chromosome, double fitnessScore){
        this.chromosome = chromosome;
        this.fitnessScore = fitnessScore;
    }

    public List<G> getChromosome() {
        return chromosome;
    }

    public double getFitnessScore() {
        return fitnessScore;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "chromosome=" + chromosome +
                ", fitnessScore=" + fitnessScore +
                '}';
    }

    public int compareTo(Individual<G> i){
        return Double.compare(i.getFitnessScore(), this.getFitnessScore());
    }
}

