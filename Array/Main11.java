package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine());

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    long[] arr = new long[n];

    for(int i=0;i<n;i++){
      arr[i] = Long.parseLong(stringTokenizer.nextToken());
    }

    long[] prefixSum = new long[n+1];

    for(int i = 1;i<=n;i++){
      prefixSum[i] = prefixSum[i-1] + arr[i-1];
    }

    long k = Long.parseLong(bufferedReader.readLine());

    int start = 0;
    int end = 1;

    long count = 0;

    while(start < end){
      if(end > n){
        break;
      }
      else if(prefixSum[end] - prefixSum[start] > k){
        count+=(n-end+1);
        start++;
        end = start+1;
      }
      else {
        end++;
      }
    }

    System.out.println(count);
  }
}
