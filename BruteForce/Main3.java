package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
  static int N;
  static int S;
  static int count;
  static int arr[];
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    N = Integer.parseInt(stringTokenizer.nextToken());
    S = Integer.parseInt(stringTokenizer.nextToken());

    arr = new int[N];

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i=0;i<N;i++){
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    count = 0;
    dfs(0,0);
    if(S == 0){
      count--;
    }

    System.out.println(count);
  }

  public static void dfs(int depth, int num){
    if(depth == N){
      if(num == S){
        count++;
      }
      return;
    }

    dfs(depth+1, num+arr[depth]);
    dfs(depth+1, num);
  }
}
