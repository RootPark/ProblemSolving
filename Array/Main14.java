package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    int[] arr = new int[N];
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(bufferedReader.readLine());
    }

    Arrays.sort(arr);

    int i = 0;
    int j = 0;
    int min = Integer.MAX_VALUE;
    while(i<N){
      if(arr[i] - arr[j] < M){
        i++;
        continue;
      }
      if(arr[i] - arr[j] == M){
        min = M;
        break;
      }
      min = Math.min(min, arr[i] - arr[j]);
      j++;
    }

    System.out.println(min);
  }
}
