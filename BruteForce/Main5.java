package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5 {
  static int N;
  static int[][] arr;
  static boolean[] visited;
  static int min = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bufferedReader.readLine());

  
    arr = new int[N][N];
    visited = new boolean[N];

    StringTokenizer stringTokenizer;
    for(int i=0;i<N;i++){
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      for(int j=0;j<N;j++){
        arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
      }
    }

    visited[0] = true;
    dfs(0, 0, 0,0);
    System.out.println(min);
  }

  public static void dfs(int start, int end, int depth, int time){
    if(depth == N-1 && arr[end][start] != 0){
      min = Math.min(min, time+arr[end][start]);
      return;
    }

    for(int i=0;i<N;i++){
      if(arr[end][i] > 0 && !visited[i]){
        visited[i] = true;
        dfs(start, i, depth+1, time+arr[end][i]);
        visited[i] = false;
      }
    }
  }
}
