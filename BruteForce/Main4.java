package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main4 {
  static int N;
  static int[] arr, newArr;
  static boolean[] visited;
  static int answer = Integer.MIN_VALUE;
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    N = Integer.parseInt(stringTokenizer.nextToken());
    arr = new int[N];
    newArr = new int[N];
    visited = new boolean[N];

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }
    dfs(0);
    System.out.println(answer);
  }

  public static void dfs(int depth){
    if(depth == N){
      int sum = 0;
      for(int i=0;i<N-1;i++){
        sum += Math.abs(newArr[i] - newArr[i+1]);
      }
      answer = Math.max(answer, sum);
      return;
    }

    for(int i=0;i<N;i++){
      if(!visited[i]){
        visited[i] = true;
        newArr[depth] = arr[i];
        dfs(depth+1);
        visited[i] = false;
      }
    }
  }
  
}
