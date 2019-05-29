package ru;

/**
 * Union-find with specific canonical element. Add a method find() to the union-find data type so that find(i)
 * returns the largest element in the connected component containing i.
 * The operations, union(), connected(), and find() should all take logarithmic time or better.
 * <p>
 * For example, if one of the connected components is {1,2,6,9},
 * then the find() method should return 9 for each of the four elements in the connected components.
 */
public class UFSpecificCanonicalElement {

    private int[] id;
    private int[] sz;
    private int[] max;

    public UFSpecificCanonicalElement(int N) {
        id = new int[N];
        sz = new int[N];
        max = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            max[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        if (sz[pid] < sz[qid]) {
            id[pid] = qid;
            sz[qid] += sz[pid];
        } else {
            id[qid] = pid;
            sz[pid] += sz[qid];
        }
        updateMax(pid, qid);
    }

    public int find(int i) {
        return max[root(i)];
    }

    private void updateMax(int p, int q) {
        int maxp = max[p];
        int maxq = max[q];
        if (maxp > maxq) max[q] = maxp;
        else if (maxq > maxp) max[p] = maxq;
    }
}
