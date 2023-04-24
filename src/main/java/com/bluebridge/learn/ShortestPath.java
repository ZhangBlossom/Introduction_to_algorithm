package main.java.com.bluebridge.learn;

import java.util.*;
/*
3
最短路径
 */
public class ShortestPath {
  private static final Scanner in = new Scanner(System.in);
  private static List<int[]> edges = new ArrayList<>();

  public static void main(String[] args) {
    add('A', 'C', 1);
    add('A', 'D', 1);
    add('A', 'E', 1);
    add('D', 'E', 1);
    add('E', 'I', 1);
    add('D', 'H', 1);
    add('H', 'I', 1);
    add('B', 'G', 1);
    add('F', 'G', 1);
    add('F', 'J', 1);
    add('K', 'N', 1);
    add('L', 'M', 1);
    add('N', 'P', 1);
    add('P', 'O', 1);
    add('O', 'Q', 1);
    add('Q', 'M', 1);
    add('L', 'R', 1);
    add('S', 'R', 1);
    add('M', 'S', 1);

    add('A', 'B', 2);
    add('B', 'J', 2);
    add('D', 'I', 2);
    add('D', 'G', 2);
    add('G', 'K', 2);
    add('K', 'P', 2);
    add('J', 'S', 2);
    add('M', 'N', 2);
    add('H', 'L', 2);

    add('E', 'I', 3);
    add('I', 'M', 3);
    add('G', 'I', 3);
    add('C', 'D', 3);
    add('C', 'G', 3);
    add('C', 'F', 3);
    add('O', 'R', 3);
    add('K', 'L', 3);

    int n = edges.size();

    int[] dist = new int[128];
    Arrays.fill(dist, Integer.MAX_VALUE >> 1);

    dist['A'] = 0;

    for (int i = 0; i < n - 1; i++) {
      for (int[] edge : edges) {
        int u = edge[0], v = edge[1], w = edge[2];
        dist[v] = Math.min(dist[v], dist[u] + w);
      }
    }

    System.out.println(dist['S']);
  }

  private static void add(char u, char v, int w) {
    edges.add(new int[] {u, v, w});
    edges.add(new int[] {v, u, w});
  }
}