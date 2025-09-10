package Daily.D0909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea14510 {
  static int numberOfTrees;
  static int[] trees;
  static int maxTreeLengh;
  static int answer = 0;

  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());

    for (int t = 1; t <= testCase; t++) {
      numberOfTrees = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());

      trees = new int[numberOfTrees];
      maxTreeLengh = Integer.MIN_VALUE;
      answer = 0;

      for (int treeIndex = 0; treeIndex < numberOfTrees; treeIndex++) {
        trees[treeIndex] = Integer.parseInt(st.nextToken());
        maxTreeLengh = Math.max(maxTreeLengh, trees[treeIndex]);
      }

      int oddCount = 0;
      int evenCount = 0;

      for (int treeIndex = 0; treeIndex < numberOfTrees; treeIndex++) {
        int leftTree = maxTreeLengh - trees[treeIndex];
        oddCount += leftTree % 2;
        evenCount += leftTree / 2;
      }

      while (oddCount < evenCount - 1) {
        evenCount--;
        oddCount += 2;
      }

      if (oddCount > evenCount) {
        answer = oddCount * 2 - 1;
      } else if (oddCount == evenCount) {
        answer = oddCount + evenCount;
      } else {
        answer = 2 * evenCount;
      }

      sb.append('#').append(t).append(' ').append(answer).append('\n');
    }

    System.out.println(sb);
  }
}
