package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int K = Integer.parseInt(stringTokenizer.nextToken());
    int N = Integer.parseInt(stringTokenizer.nextToken());

    long[] arr = new long[K];

    for(int i=0;i<K;i++){
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      arr[i] = Long.parseLong(stringTokenizer.nextToken());
    }

    long min = 0;
    long max = 0;
    long mid = 0;

    for(int i=0;i<K;i++){
      max = Math.max(arr[i], max);
    }
    max++;

    while(min<max){
      mid = (min+max)/2;
      long count = 0;

      for(int i=0;i<arr.length;i++){
        count+=(arr[i]/mid);
      }

      if(count<N){
        max = mid;
      }
      else {
        min = mid + 1;
      }
    }
    System.out.println(min-1);
  }
}
