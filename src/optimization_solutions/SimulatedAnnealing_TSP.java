package optimization_solutions;

import core_algorithms.Problem;
import core_algorithms.SimulatedAnnealing;
import optimization_problems.TSP;

import java.util.List;

public class SimulatedAnnealing_TSP extends SimulatedAnnealing<List<Integer>> {

    private final static long INIT_TIME = 1;
    private final static double INIT_TEMP = 1e13;
    private final static long MAX_TIME = 100_000_000;

    public SimulatedAnnealing_TSP(Problem<List<Integer>> p) {
        super(INIT_TIME, INIT_TEMP, p);
    }

    public double schedule(long time, double temp){
        /* TODO */
    }

    public static void main(String[] args) {
        SimulatedAnnealing_TSP agent = new SimulatedAnnealing_TSP(new TSP(26));
        agent.search();

    }
}
