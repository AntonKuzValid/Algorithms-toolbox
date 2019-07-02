package ru;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Social network connectivity. Given a social network containing nn members and a log file containing mm timestamps at which
 * times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected
 * (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and
 * that friendship is an equivalence relation. The running time of your algorithm should be m \log nmlogn or
 * better and use extra space proportional to nn.
 **/
public class SocialNetworCconnectivity {
    private static final int PAIR_SIZE = 2;

    private UnionFind uf;
    private int[][] pairs;
    private int n;

    public SocialNetworCconnectivity(int n, int m, InputStream src) {
        this.uf = new UnionFind(n);
        this.n = n;
        try (Scanner sc = new Scanner(src)) {
            System.out.println("Type pairs of members");
            this.pairs = new int[m][PAIR_SIZE];
            for (int i = 0; i < m; i++) {
                String[] str_pair = sc.nextLine().split(" ");
                if (str_pair.length != PAIR_SIZE)
                    throw new IllegalArgumentException("Input data should be 2 digits seperated with 1 space");
                for (int j = 0; j < str_pair.length; j++) {
                    int member = Integer.parseInt(str_pair[j]);
                    if (member < 0 || member >= n)
                        throw new IllegalArgumentException("Input data should be > 0 and < n");
                    pairs[i][j] = member;
                }
            }
        }
    }

    public static void main(String[] args) {

        SocialNetworCconnectivity scn;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Type number of members - n");
            int n = Integer.parseInt(sc.nextLine());

            System.out.println("Type number of timestamps");
            int m = Integer.parseInt(sc.nextLine());
            scn = new SocialNetworCconnectivity(n, m, System.in);
        }
        scn.run();
    }

    public int run() {
        //Instead of timestamp return the number of log line
        for (int i = 0; i < pairs.length; i++) {
            int p = pairs[i][0];
            int q = pairs[i][1];
            if (!uf.connected(p, q)) {
                if (uf.union(p, q) == n) {
                    System.out.println("the earliest time - " + i);
                    return i;
                }
            }
        }
        return -1;
    }
}
