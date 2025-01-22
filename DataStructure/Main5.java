package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main5 {
  static Stack<Integer> stack = new Stack<>();
  static StringBuilder stringBuilder = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine());
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(bufferedReader.readLine());
    }

    boolean flag = true;
    int num = 0;

    for (int i = 0; i < n; i++) {
      if(arr[i] > num) {
        for(int j=num+1;j<=arr[i];j++){
          pushStack(j);
        }
        num = arr[i];
      }
      else if(stack.peek()!= arr[i]){
        flag = false;
      }
      popStack();
    }

    if (flag) {
      System.out.println(stringBuilder);
    } else {
      System.out.println("NO");
    }

  }

  public static void pushStack(int num) {
    stack.push(num);
    stringBuilder.append("+").append("\n");
  }

  public static void popStack() {
    stack.pop();
    stringBuilder.append("-").append("\n");
  }
}
