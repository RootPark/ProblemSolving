package Daily.D0807;

import java.io.*;
import java.util.*;

public class Swea2001 {
  static int[][] map;
  static int[][] prefixSumMap;
  static int size,searchSize;
  static int maxSum;

  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());

    for (int t = 1; t <= testCase; t++) {
      st = new StringTokenizer(br.readLine());

      size = Integer.parseInt(st.nextToken());
      searchSize = Integer.parseInt(st.nextToken());

      map = new int[size][size];
      prefixSumMap = new int[size+1][size+1];

      maxSum = Integer.MIN_VALUE;

      for(int indexX = 0; indexX < size; indexX++) {
        st = new StringTokenizer(br.readLine());
        for(int indexY = 0; indexY < size; indexY++){
          map[indexX][indexY] = Integer.parseInt(st.nextToken());
        }
      }

      for(int indexX = 1; indexX <= size; indexX++) {
        for(int indexY = 1; indexY <= size; indexY++){
          prefixSumMap[indexX][indexY] = map[indexX-1][indexY-1] + prefixSumMap[indexX-1][indexY] + prefixSumMap[indexX][indexY-1] - prefixSumMap[indexX-1][indexY-1];
        }
      }

      for(int indexX = searchSize; indexX <= size; indexX++) {
        for(int indexY = searchSize; indexY <= size; indexY++){
          int sum = prefixSumMap[indexX][indexY] - prefixSumMap[indexX][indexY-searchSize] - prefixSumMap[indexX-searchSize][indexY] + prefixSumMap[indexX-searchSize][indexY-searchSize];
          if(sum > maxSum) {
            maxSum = sum;
          }
        }
      }
      
      sb.append("#").append(t).append(" ").append(maxSum).append("\n");
    }
    System.out.println(sb);
  }
}
