package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    int[][] A = new int[N][M];

    for (int i = 0; i < N; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");
      for (int j = 0; j < M; j++) {
        A[i][j] = Integer.parseInt(stringTokenizer.nextToken());
      }
    }

    stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");
    M = Integer.parseInt(stringTokenizer.nextToken());
    int K = Integer.parseInt(stringTokenizer.nextToken());

    int[][] B = new int[M][K];

    for(int i=0;i<M;i++){
      stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");
      for(int j=0;j<K;j++){
        B[i][j] = Integer.parseInt(stringTokenizer.nextToken());
      }
    }

    int[][] answer = new int[N][K];

    for(int i=0;i<N;i++){
      for(int j=0;j<K;j++){
        int sum = 0;
        for(int k=0;k<M;k++){
          sum += A[i][k] * B[k][j];
        }
        answer[i][j] = sum;
      }
    }

    for(int i=0;i<N;i++){
      for(int j=0;j<K;j++){
        System.out.print(answer[i][j]+" ");
      }
      System.out.println();
    }

  }

}
