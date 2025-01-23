package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main7 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    Stack<Integer> stack = new Stack<>();

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    boolean flag = true;

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i = 0; i < N; i++) {
      priorityQueue.offer(Integer.parseInt(stringTokenizer.nextToken()));
    }

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i = 0; i < M; i++) {
      int wish = Integer.parseInt(stringTokenizer.nextToken());
      if (priorityQueue.peek() > wish) {
        int num = priorityQueue.poll() - wish;
        priorityQueue.offer(num);
      } else if (priorityQueue.peek() == wish) {
        priorityQueue.poll();
      } else if (priorityQueue.peek() < wish) {
        flag = false;
      }
    }

    if (flag) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }
}
