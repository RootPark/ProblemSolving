package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12 {
  static int N;
  static int d;
  static int k;
  static int c;
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    N = Integer.parseInt(stringTokenizer.nextToken());
    d = Integer.parseInt(stringTokenizer.nextToken());
    k = Integer.parseInt(stringTokenizer.nextToken());
    c = Integer.parseInt(stringTokenizer.nextToken());

    int[] arr = new int[N];
    int[] eated = new int[d+1];

    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(bufferedReader.readLine());
    }

    int count = 0;
    for(int i=0;i<k;i++){
      if(eated[arr[i]] == 0){
        count++;
      }
      eated[arr[i]]++;
    }

    int max = count;

    for(int i=0;i<N;i++){
     int end = (i+k) % N;
     int start = i;

     if(eated[arr[end]] == 0){
      count++;
     }
     eated[arr[end]]++;

     eated[arr[start]]--;
     if(eated[arr[start]]==0){
      count--;
     }

     int currentMax = count;
     if(eated[c] == 0){
      currentMax++;
     }
     max = Math.max(max, currentMax);
    }

    System.out.println(max);
  }
}
