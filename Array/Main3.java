package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    
    int N = Integer.parseInt(stringTokenizer.nextToken());
    int X = Integer.parseInt(stringTokenizer.nextToken());

    int[] visitors = new int[N];
    
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for(int i = 0 ; i < N ; i++){
      visitors[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    int[] prefixSum = new int[N+1];
    for(int i = 0 ; i <= N ; i++){
      if(i==0){
        prefixSum[i] = 0;
      }
      else{
        prefixSum[i] = prefixSum[i-1] + visitors[i-1];
      }
    }

    int start = 0;
    int end = start + X;

    int max = 0;
    int count = 0;
    while(end <= N){
      if(prefixSum[end] - prefixSum[start] > max){
        max = prefixSum[end] - prefixSum[start];
        count = 1;
      }
      else if(prefixSum[end] - prefixSum[start] == max){
        count++;
      }
      start++;
      end++;
    }

    if(max == 0){
      System.out.println("SAD");
    }
    else{
      System.out.println(max);
      System.out.println(count);
    }
  }
}
