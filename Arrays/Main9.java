package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bufferedReader.readLine());
    int M = Integer.parseInt(bufferedReader.readLine());

    int[] arr = new int[N];
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    Arrays.sort(arr);
    int count = 0;

    int pointer1 = 0;
    int pointer2 = N - 1;

    while (pointer1 < pointer2) {
      if (arr[pointer1] + arr[pointer2] < M) {
        pointer1++;
      } else if (arr[pointer1] + arr[pointer2] > M) {
        pointer2--;
      } else {
        count++;
        pointer1++;
        pointer2--;
      }
    }

    System.out.println(count);
  }
}
