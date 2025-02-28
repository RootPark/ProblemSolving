package Graph1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
  static int N;
  static int M;
  static int V;

  static int[][] graph;

  // DFS
  static boolean[] visitedDfs = new boolean[1001];
  static StringBuilder stringBuilderDfs = new StringBuilder();

  // BFS
  static boolean[] visitedBfs = new boolean[1001];
  static Queue<Integer> queue = new LinkedList<>();
  static StringBuilder stringBuilderBfs = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    N = Integer.parseInt(stringTokenizer.nextToken());
    M = Integer.parseInt(stringTokenizer.nextToken());
    V = Integer.parseInt(stringTokenizer.nextToken());

    graph = new int[N+1][N+1];

    for (int i = 0; i < M; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());

      int a = Integer.parseInt(stringTokenizer.nextToken());
      int b = Integer.parseInt(stringTokenizer.nextToken());

      graph[a][b] = graph[b][a] = 1;
    }

    dfs(V);
    bfs(V);
    System.out.println(stringBuilderDfs);
    System.out.println(stringBuilderBfs);

  }

  public static void dfs(int v) {
    visitedDfs[v] = true;
    stringBuilderDfs.append(v).append(" ");

    for (int i = 0; i <= N; i++) {
      if(graph[v][i] == 1 && !visitedDfs[i]){
        dfs(i);
      }
    }
  }

  public static void bfs(int v){
    queue.add(v);
    visitedBfs[v] = true;

    while(!queue.isEmpty()){
      v = queue.poll();
      stringBuilderBfs.append(v).append(" ");

      for(int i = 1; i<= N; i++){
        if(graph[v][i] == 1 & !visitedBfs[i]){
          queue.add(i);
          visitedBfs[i] = true;
        }
      }
    }
  }
}
