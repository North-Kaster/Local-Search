package core_algorithms;

import java.util.List;

/* <G> Represents the data type of a gene
 */
public abstract class Individual <G> {
    private List<G> chromosome; // Might want to make these final?
    private double fitnessScore;

    public Individual(List<G> chromosome){
        this.chromosome = chromosome;
        this.fitnessScore =
                calcFitnessScore(this.chromosome);
    }

    public abstract double calcFitnessScore(List<G> chromosome);

    public List<G> getChromosome() {
        return chromosome;
    }

    public double getFitnessScore() {
        return fitnessScore;
    }
}
