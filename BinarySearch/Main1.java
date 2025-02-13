package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {
  static int[] cards;
  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;
    StringBuilder stringBuilder = new StringBuilder();

    N = Integer.parseInt(bufferedReader.readLine());
    cards = new int[N];

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i = 0; i < N; i++) {
      cards[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    Arrays.sort(cards);

    M = Integer.parseInt(bufferedReader.readLine());
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    for (int i = 0; i < M; i++) {
      int num = Integer.parseInt(stringTokenizer.nextToken());

      if(binarySearch(num)) {
        stringBuilder.append("1 ");
      }
      else{
        stringBuilder.append("0 ");
      }

    }

    System.out.println(stringBuilder);

  }

  public static boolean binarySearch(int num) {
    int leftIndex = 0;
    int rightIndex = N - 1;

    while (leftIndex <= rightIndex) {
      int midIndex = (leftIndex + rightIndex) / 2;
      int mid = cards[midIndex];
      if (num < mid) {
        rightIndex = midIndex - 1;
      } else if (num > mid) {
        leftIndex = midIndex + 1;
      } else {
        return true;
      }
    }
    return false;
  }
}
