package Graph1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(bufferedReader.readLine());

    
    for(int i = 0; i < T; i++){
      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int N = Integer.parseInt(stringTokenizer.nextToken());
      int M = Integer.parseInt(stringTokenizer.nextToken());

      for(int j = 0; j < M ; j++){
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
      }
      System.out.println(N-1);
    }
  }
}
