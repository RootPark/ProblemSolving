package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main5 {
  static StringBuilder stringBuilder = new StringBuilder();
  static Stack<Integer> stack = new Stack<>();
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine());
    
    int data = 0;
    boolean flag = true;

    for(int i=0;i<n;i++){
      int num = Integer.parseInt(bufferedReader.readLine());
      if(num > data){
        for(int j=data+1; j<=num; j++){
          push(j);
        }
        data = num;
      }
      else if(stack.peek()!=num){
        flag = false;
      }
      pop();
    }

    if(flag){
      System.out.println(stringBuilder);
    }
    else{
      System.out.println("NO");
    }

    
  }

  public static void push(int num){
    stack.push(num);
    stringBuilder.append('+').append('\n');
  }

  public static void pop(){
    stack.pop();
    stringBuilder.append('-').append('\n');    
  }
}
