package ru;

public class UnionFind {

    private int[] id;
    private int[] sz;

    public UnionFind(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
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

    //Return size for checking connectivity
    public int union(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        if (pid == qid) return sz[pid];
        if (sz[pid] < sz[qid]) {
            id[pid] = qid;
            sz[qid] += sz[pid];
            return sz[qid];
        } else {
            id[qid] = pid;
            sz[pid] += sz[qid];
            return sz[pid];
        }
    }
}
