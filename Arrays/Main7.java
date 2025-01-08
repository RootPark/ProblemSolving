package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    long[] prefixSum = new long[N];
    long[] remainder = new long[N];
    long[] remainderIndex = new long[M];
    long count = 0;

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i = 0; i < N; i++) {
      if (i == 0) {
        prefixSum[i] = Integer.parseInt(stringTokenizer.nextToken());
      } else {
        prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      remainder[i] = prefixSum[i] % M;
      if (remainder[i] == 0) {
        count++;
      }
      remainderIndex[(int)remainder[i]]++;
    }

    for (int i = 0; i < M; i++) {
      if (remainderIndex[i] > 1) {
        count += (remainderIndex[i] * (remainderIndex[i] - 1) / 2);
      }
    }

    System.out.println(count);
  }
}
