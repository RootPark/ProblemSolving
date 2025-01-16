package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main4 {
  static LinkedList<Integer> deque = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    int[] array = new int[M];

    for (int i = 1; i <= N; i++) {
      deque.offer(i);
    }

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i = 0; i < M; i++) {
      array[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    int count = 0;

    for (int i = 0; i < M; i++) {
      int targetIndex = deque.indexOf(array[i]);
      if (isBiggerThenHalf(array[i])) {
        for (int j = 0; j < deque.size() - targetIndex; j++) {
          deque.offerFirst(deque.pollLast());
          count++;
        }
      } else {
        for (int j = 0; j < targetIndex; j++) {
          deque.offerLast(deque.pollFirst());
          count++;
        }

      }
      deque.pollFirst();
    }

    System.out.println(count);
  }

  public static boolean isBiggerThenHalf(int num) {
    int targetIndex = deque.indexOf(num);
    int halfIndex;

    if (deque.size() % 2 == 0) {
      halfIndex = deque.size() / 2 - 1;
    } else {
      halfIndex = deque.size() / 2;
    }

    return (targetIndex > halfIndex);
  }
}
