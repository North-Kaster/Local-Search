package core_algorithms;

import java.util.Random;

/**
 * An implementation of the simulated annealing algorithm
 * Assume that the optimal solution has the *lowest* cost.
 *
 * S: the data type of states;
 */
public abstract class SimulatedAnnealing<S> {
    private long time;
    private double temp;

    private final Problem<S> problem;

    public SimulatedAnnealing(long initTime, double initTemp, Problem<S> p){
        this.time = initTime;
        this.temp = initTemp;
        this.problem = p;
    }

    //generate the new (lower) temperature
    public abstract double schedule(long time, double temp);

    public void search(){
        /* TODO */
        S state = problem.getInitState();
    }

    public boolean accept(double delta, double temp){
        /* TODO */
    }

}
