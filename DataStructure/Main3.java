package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main3 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();

    String string = bufferedReader.readLine();
    Stack<Character> stack = new Stack<>();

    int index = 0;
    while(index < string.length()){
      char c = string.charAt(index);
      if(c == '<'){
        while(!stack.isEmpty()){
          stringBuilder.append(stack.pop());
        }
        stringBuilder.append(c); //<
        while(c != '>'){
          index++;
          c = string.charAt(index);
          stringBuilder.append(c);
        }
      }
      else if(c == ' '){
        while(!stack.isEmpty()){
          stringBuilder.append(stack.pop());
        }
        stringBuilder.append(' ');
        index++;
      }
      else if (c=='>'){
        index++;
      }
      else {
        stack.push(c);
        index++;
      }
    }

    while(!stack.isEmpty()){
      stringBuilder.append(stack.pop());
    }

    System.out.println(stringBuilder);
  }
}
