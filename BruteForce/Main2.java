package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
  static boolean[][] arr;
  static int min = 64;
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    arr = new boolean[N][M];

    for(int i=0;i<N;i++){
      String line = bufferedReader.readLine();
      for(int j=0;j<M;j++){
        if(line.charAt(j) == 'W'){
          arr[i][j] = true;
        }
        else{
          arr[i][j] = false;
        }
      }
    }

    for(int i=0;i<N-7;i++){
      for(int j=0;j<M-7;j++){
        check(i, j);
      }
    }
    System.out.println(min);
  }

  public static void check(int x, int y){
    boolean WB = arr[x][y];

    int count = 0;

    for(int i=x;i<x+8;i++){
      for(int j=y;j<y+8;j++){
        if(arr[i][j] != WB){
          count++;
        }
        WB=(!WB);
      }
      WB=(!WB);
    }
    count = Math.min(count, 64-count);
    
    min = Math.min(min, count);
  }
}
