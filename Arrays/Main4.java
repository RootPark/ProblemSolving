package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
    StringBuilder stringBuilder = new StringBuilder();

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    int[][] prefixSum = new int[N+1][N+1];

    for (int i = 1; i <= N; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
      for (int j = 1; j <= N; j++) {
        int num = Integer.parseInt(stringTokenizer.nextToken());
        prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + num;
      }
    }

    for(int i=0;i<M;i++){
      stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");
      int x1 = Integer.parseInt(stringTokenizer.nextToken());
      int y1 = Integer.parseInt(stringTokenizer.nextToken());
      int x2 = Integer.parseInt(stringTokenizer.nextToken());
      int y2 = Integer.parseInt(stringTokenizer.nextToken());
      int answer = prefixSum[x2][y2] - prefixSum[x1-1][y2] - prefixSum[x2][y1-1] + prefixSum[x1-1][y1-1];
      stringBuilder.append(answer).append("\n");
    }

    System.out.println(stringBuilder);


  }
}
