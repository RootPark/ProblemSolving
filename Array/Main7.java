package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    long[] arr = new long[N];
    long[] prefixSum = new long[N+1];
    long[] remainderSum = new long[N+1];
    long[] remainderCount = new long[M];

    int count = 0;

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for(int i=0;i<N;i++){
      arr[i] = Long.parseLong(stringTokenizer.nextToken());
    }

    for(int i=1;i<=N;i++){
      prefixSum[i] = prefixSum[i-1] + arr[i-1];
    }

    for(int i=0;i<=N;i++){
      remainderSum[i] = prefixSum[i] % M;
    }

    for(int i=0;i<=N;i++){
      remainderCount[(int)remainderSum[i]]++;
    }

    for(int i=0;i<M;i++){
      count += (remainderCount[i] * (remainderCount[i] - 1) /2);
    }

    System.out.println(count);
  }
}
