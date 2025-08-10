package Daily.D0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1210 {
  static int[][] ladders = new int[100][100];
  static StringBuilder sb = new StringBuilder();
  static int[] deltaX = { -1, 0, 0 };
  static int[] deltaY = { 0, -1, 1 };
  static int startX;
  static int startY;

  static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (int test = 1; test <= 10; test++) {
      int testCase = Integer.parseInt(br.readLine());

      for(int i=0;i<100;i++){
        st = new StringTokenizer(br.readLine());
        for(int j=0;j<100;j++){
          ladders[i][j] = Integer.parseInt(st.nextToken());
          if(ladders[i][j] == 2) {
            startX = i;
            startY = j;
          }
        }
      }
      while(true) {
        if(startX == 0) {
          answer = startY;
          break;
        }
        for(int i=0;i<3;i++){
          int nextX = startX + deltaX[i];
          int nextY = startY + deltaY[i];

          if(nextX >=0 && nextX < 100 && nextY >= 0 && nextY < 100 && ladders[nextX][nextY] == 1) {
            ladders[startX][startY] = 3;
            startX = nextX;
            startY = nextY;
          }
        }
      }
      sb.append("#").append(testCase).append(" ").append(answer).append("\n");
    }
    System.out.println(sb);
  }
}
