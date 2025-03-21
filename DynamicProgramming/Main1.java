package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
  static int[][] arr = new int[30][30];
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    StringBuilder stringBuilder = new StringBuilder();

    int T = Integer.parseInt(stringTokenizer.nextToken());


    for(int i=0;i<T;i++){
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int N = Integer.parseInt(stringTokenizer.nextToken());
      int M = Integer.parseInt(stringTokenizer.nextToken());
      
      stringBuilder.append(combination(M, N)).append("\n");
    }

    System.out.println(stringBuilder);

  }

  public static int combination(int n, int r){
    if(arr[n][r] > 0){
      return arr[n][r];
    }
    if(n == r || r == 0){
      return arr[n][r] = 1;
    }
    return arr[n][r] = combination(n-1, r-1) + combination(n-1, r);
  }

}
