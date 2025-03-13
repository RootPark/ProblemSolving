package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    StringBuilder stringBuilder = new StringBuilder();

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    int[] arr = new int[N];

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    int[] prefixSum = new int[N+1];

    for (int i = 0; i < N+1; i++) {
      if(i==0){
        prefixSum[i] = 0;
      }
      else{
        prefixSum[i] = arr[i-1] + prefixSum[i-1];
      }
    }

    for (int i = 0; i < M; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int start = Integer.parseInt(stringTokenizer.nextToken());
      int end = Integer.parseInt(stringTokenizer.nextToken());

      int answer = prefixSum[end] - prefixSum[start-1];
      stringBuilder.append(answer).append("\n");
    }

    System.out.println(stringBuilder);
  }
}
