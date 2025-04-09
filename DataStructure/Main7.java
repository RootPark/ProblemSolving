package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    PriorityQueue<Integer> gift = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> kid = new LinkedList<>();

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for(int i=0;i<N;i++){
       gift.offer(Integer.parseInt(stringTokenizer.nextToken()));
    }

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for(int i=0;i<M;i++){
      kid.add(Integer.parseInt(stringTokenizer.nextToken()));
    }

    boolean flag = true;

    while(!kid.isEmpty()){
      int num = kid.poll();

      if(gift.peek() > num){
        gift.offer(gift.poll() - num);
      }
      else if(gift.peek() == num){
        gift.poll();
      }
      else if(gift.peek() < num){
        flag = false;
      }
    }

    if(flag){
      System.out.println(1);
    }
    else{
      System.out.println(0);
    }
  }
}
