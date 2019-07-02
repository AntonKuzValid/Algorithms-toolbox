package ru.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF uf;
    private boolean[][] grid;
    private final int TOP;
    private final int DOWN;
    private final int N;
    private int cntOfOpenSites = 0;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        TOP = 0;
        DOWN = n * n + 1;
        N = n;
        uf = new WeightedQuickUnionUF(DOWN + 1);
        grid = new boolean[n][n];

    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isOpen(row, col)) return;
        grid[row - 1][col - 1] = true;
        union(row, col, row + 1, col);
        union(row, col, row - 1, col);
        union(row, col, row, col + 1);
        union(row, col, row, col - 1);
        cntOfOpenSites++;

    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        int rowid = row - 1;
        int colid = col - 1;
        validate(rowid, colid);
        return grid[rowid][colid];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        if (!isOpen(row, col)) return false;
        int rowid = row - 1;
        int colid = col - 1;
        return uf.connected(TOP, getUfId(rowid, colid));
    }

    // number of open sites
    public int numberOfOpenSites() {
        return cntOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(TOP, DOWN);
    }

    private void validate(int i) {
        if (i < 0 || i > N - 1) throw new IllegalArgumentException("Wrong site index - " + i);
    }

    private void validate(int... ints) {
        for (int anInt : ints) {
            validate(anInt);
        }
    }

    private void union(int row1, int col1, int row2, int col2) {
        try {

            int ufId1 = getUfId(row1 - 1, col1 - 1);
            int ufId2 = getUfId(row2 - 1, col2 - 1);
            if (ufId2 <= TOP) uf.union(ufId1, TOP);
            else if (ufId2 >= DOWN) uf.union(ufId1, DOWN);
            else if (isOpen(row2, col2) && !uf.connected(ufId1, ufId2)) {
                uf.union(ufId1, ufId2);
            }
        } catch (IllegalArgumentException ex) {
            //do nothing
        }
    }

    private int getUfId(int row, int col) {
        return row * N + col + 1;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation pc = new Percolation(3);
        System.out.println(pc.percolates());
        pc.open(1, 1);
        System.out.println(pc.isOpen(1, 1));
        System.out.println(pc.isFull(1, 1));
        System.out.println(pc.percolates());
        pc.open(2, 1);
        System.out.println(pc.percolates());
        pc.open(3, 1);
        System.out.println(pc.percolates());
        System.out.println(pc.isFull(1, 2));
        pc.open(2, 3);
        System.out.println(pc.isFull(2, 3));
        pc.open(1, 3);
        System.out.println(pc.isFull(2, 3));
        System.out.println(pc.numberOfOpenSites());

    }
}
