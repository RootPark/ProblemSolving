package Implementation;

import java.io.*;
import java.util.*;

public class Main1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] S = new int[N + M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      S[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int[] T = new int[N + M];

      for (int j = 0; j < N + M; j++) {
        T[j] = Integer.parseInt(st.nextToken());
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
