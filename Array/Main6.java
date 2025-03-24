package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6 {
  static long[] arr = new long[1000001];
  static long[] prefixSum = new long[1000001];
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    
    int T = Integer.parseInt(bufferedReader.readLine());

    for(int i=0;i<arr.length;i++){
      arr[i] = 1;
    }

    for(int i=2;i<arr.length;i++){
      for(int j=1;j*i<arr.length;j++){
        arr[i*j] += i;
      }
    }

    for(int i=1;i<prefixSum.length;i++){
      prefixSum[i] = prefixSum[i-1] + arr[i];
    }

    for(int i=0;i<T;i++){
      int num = Integer.parseInt(bufferedReader.readLine());
      stringBuilder.append(prefixSum[num]).append("\n");
    }

    System.out.println(stringBuilder);
  }


}
