package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 26145 출제비 제분배
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int[] S = new int[N + M];

    for (int i = 0; i < N; i++) {
      S[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    for (int i = 0; i < N; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());

      int[] T = new int[N + M];
      for (int j = 0; j < N + M; j++) {
        T[j] = Integer.parseInt(stringTokenizer.nextToken());
      }

      for (int j = 0; j < N + M; j++) {
        S[j] += T[j];
      }
      int sum = Arrays.stream(T).sum();
      S[i] -= sum;
    }

    for (int i = 0; i < N + M; i++) {
      System.out.print(S[i] + " ");
    }
  }
}