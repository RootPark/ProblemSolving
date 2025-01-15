package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main3 {
  static Stack<Character> stack = new Stack<>();
  static Queue<Character> queue = new LinkedList<>();
  static StringBuilder answer = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String S = bufferedReader.readLine();
    int index = 0;
    boolean flag = false;

    while(index < S.length()){
      if(S.charAt(index) == '<'){
        flag = true;
        popAll();
        queue.add(S.charAt(index));
        index++;
      }
      else if(S.charAt(index) == '>'){
        flag = false;
        queue.add(S.charAt(index));
        pollAll();
        index++;
      }
      else if(flag){
        queue.add(S.charAt(index));
        index++;
      }
      else if(!flag){
        if(S.charAt(index)==' '){
          popAll();
          answer.append(' ');
          index++;
        }
        else{
          stack.push(S.charAt(index));
          index++;
        }
      }
    }
    popAll();
    System.out.println(answer);
  }

  public static void pollAll() {
    while (!queue.isEmpty()) {
      answer.append(queue.poll());
    }
  }

  public static void popAll() {
    while (!stack.empty()) {
      answer.append(stack.pop());
    }
  }
}
