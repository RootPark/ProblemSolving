package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    int arr[] = new int[N+1];

    stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");
    for(int i=1;i<=N;i++){
      arr[0] = 0;
      arr[i] = arr[i-1]+ Integer.parseInt(stringTokenizer.nextToken());
    }

    int answer[] = new int[M];

    for(int i=0;i<M;i++){
      stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");
      int start = Integer.parseInt(stringTokenizer.nextToken());
      int end = Integer.parseInt(stringTokenizer.nextToken());

      answer[i] = arr[end] - arr[start-1];
    }

    for(int i=0;i<M;i++){
      System.out.println(answer[i]);
    }
  }
}
