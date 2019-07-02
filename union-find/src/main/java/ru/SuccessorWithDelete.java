package ru;

/**
 * Successor with delete. Given a set of n integers S={0,1,...,n−1} and a sequence of requests of the following form:
 * <p>
 * Remove x from S
 * Find the successor of x: the smallest y in S such that y≥x.
 * design a data type so that all operations (except construction) take logarithmic time or better in the worst case.
 */
public class SuccessorWithDelete {

    private boolean data[]; // data[i] == false if removed
    private UFSpecificCanonicalElement uf; // used to find largest unremoved element
    private int N; // N integers in S

    public SuccessorWithDelete(int N) {
        this.N = N;
        data = new boolean[N];
        for (int i = 0; i < N; ++i)
            data[i] = true;
        uf = new UFSpecificCanonicalElement(N);
    }

    public void remove(int x) {
        data[x] = false;
        if (x > 0 && !data[x - 1])
            uf.union(x, x - 1);
        if (x < N - 1 && !data[x + 1])
            uf.union(x, x + 1);
    }

    public int successor(int x) {
        if (data[x]) {
            return x;
        } else {
            int res = uf.find(x) + 1;
            if (res >= N) {
                System.out.println("Error, no successor can be found");
                return -1;
            } else {
                return res;
            }
        }
    }
}
