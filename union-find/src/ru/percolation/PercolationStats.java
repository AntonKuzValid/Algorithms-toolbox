package ru.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] results;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        results = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation pc = new Percolation(n);
            do {
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;
                pc.open(row, col);
            } while (!pc.percolates());

            results[i] = pc.numberOfOpenSites() / (double) (n * n);
        }
    }

    // sample mean of ru.percolation threshold
    public double mean() {
        return StdStats.mean(results);

    }

    // sample standard deviation of ru.percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96 * Math.sqrt(stddev()) / Math.sqrt(results.length));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96 * Math.sqrt(stddev()) / Math.sqrt(results.length));
    }

    // test client (described below)
    public static void main(String[] args) {
        PercolationStats ps = new PercolationStats(200, 100);
        System.out.println(ps.mean());
        System.out.println(ps.stddev());
        System.out.println("[" + ps.confidenceLo() + "," + ps.confidenceHi() + "]");
    }
}
