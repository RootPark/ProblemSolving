package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main4 {
  static int N;
  static int M;
  static int count;
  static LinkedList<Integer> deque = new LinkedList<>();
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    N = Integer.parseInt(stringTokenizer.nextToken());
    M = Integer.parseInt(stringTokenizer.nextToken());
    count = 0;

    for(int i = 1; i <= N; i++){
      deque.addLast(i);
    }

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for(int i=0;i<M;i++){
      int num = Integer.parseInt(stringTokenizer.nextToken());
      while(deque.peek() != num){
        int halfIndex = 0;
        if(deque.size()%2==0){
          halfIndex = deque.size()/2;
        }
        else{
          halfIndex = deque.size()/2 + 1;
        }
        
        if(deque.indexOf(num)+1 > halfIndex){
          action3();
        }
        else{
          action2();
        }
      }
      deque.pollFirst();
    }

    System.out.println(count);
  }

  public static void action2(){
    deque.addLast(deque.pollFirst());
    count++;
  }

  public static void action3(){
    deque.addFirst(deque.pollLast());
    count++;
  }
}
