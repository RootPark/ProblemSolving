package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bufferedReader.readLine());

    int[][] xy = new int[N][2];

    for (int i = 0; i < N; i++) {
      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

      xy[i][0] = Integer.parseInt(stringTokenizer.nextToken());
      xy[i][1] = Integer.parseInt(stringTokenizer.nextToken());
    }

    int[] grade = new int[N];
    for (int i = 0; i < N; i++) {
      grade[i] = 1;
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (xy[i][0] < xy[j][0] && xy[i][1] < xy[j][1]) {
          grade[i]++;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      System.out.print(grade[i] + " ");
    }
  }
}
