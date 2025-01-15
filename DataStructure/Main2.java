package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    StringBuilder stringBuilder = new StringBuilder();

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int K = Integer.parseInt(stringTokenizer.nextToken());

    Queue<Integer> queue = new LinkedList<>();
    ArrayList<Integer> answer = new ArrayList<>();

    for (int i = 1; i <= N; i++) {
      queue.add(i);
    }

    int count = 0;

    while (!queue.isEmpty()) {
      if (count == K - 1) {
        answer.add(queue.poll());
        count = 0;
      } else {
        queue.add(queue.poll());
        count++;
      }
    }

    stringBuilder.append("<");
    for(Integer a : answer){
      stringBuilder.append(a).append(", ");
    }
    stringBuilder.deleteCharAt(stringBuilder.length()-1);
    stringBuilder.deleteCharAt(stringBuilder.length()-1);
    stringBuilder.append(">");

    System.out.println(stringBuilder);
  }
}
