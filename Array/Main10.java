package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int K = Integer.parseInt(stringTokenizer.nextToken());

    int[] arr = new int[N];

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    int[] prefixSum = new int[N+1];

    for(int i=1;i<=N;i++){
      prefixSum[i] = prefixSum[i-1] + arr[i-1];
    }

    int start = 0;
    int end = start + K;
    int max = Integer.MIN_VALUE;

    while(end <= N){
      if(prefixSum[end] - prefixSum[start] > max){
        max = prefixSum[end] - prefixSum[start];
      }
      start++;
      end++;
    }

    System.out.println(max);
  }
}
