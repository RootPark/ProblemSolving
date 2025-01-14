package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int K = Integer.parseInt(stringTokenizer.nextToken());

    int[] prefixArr = new int[N+1];

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for(int i=1;i<=N;i++){
        prefixArr[i] = prefixArr[i-1] + Integer.parseInt(stringTokenizer.nextToken());
      
    }

    int max = Integer.MIN_VALUE;

    for(int i=K;i<=N;i++){
      max = Math.max(max, prefixArr[i]-prefixArr[i-K]);
    }

    System.out.println(max);
  }
}
