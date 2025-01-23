package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main8 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int K = Integer.parseInt(stringTokenizer.nextToken());

    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = 1; i <= N; i++) {
      deque.addLast(i);
    }

    while(deque.size() >= K){
      deque.addLast(deque.pollFirst());
      for(int i=1;i<K;i++){
        deque.pollFirst();
      }
    }

    System.out.println(deque.peekFirst());
  }
}
