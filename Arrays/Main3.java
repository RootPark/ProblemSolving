package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int X = Integer.parseInt(stringTokenizer.nextToken());

    int[] arr = new int[N];

    stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    int sum = 0;
    for (int i = 0; i < X; i++) {
      sum += arr[i];
    }

    int max = sum;
    int count = 1;
    for (int i = 0; i < N - X; i++) {
      sum -= arr[i];
      sum += arr[i + X];

      if (sum == max) {
        count++;
      }
      if (sum > max) {
        count = 1;
        max = sum;
      }
    }
    if (max == 0) {
      System.out.println("SAD");
    } else {
      System.out.println(max);
      System.out.println(count);
    }
  }
}
