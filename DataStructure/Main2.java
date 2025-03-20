package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    StringBuilder stringBuilder = new StringBuilder();

    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> answer = new LinkedList<>();

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int K = Integer.parseInt(stringTokenizer.nextToken());

    for(int i=1;i<=N;i++){
      queue.add(i);
    }

    int count = 1;
    while(!queue.isEmpty()){
      int num = queue.poll();
      if(count%K==0){
        answer.add(num);
      }
      else{
        queue.add(num);
      }
      count++;
    }

    stringBuilder.append("<");
    for(int i=0;i<N;i++){
      stringBuilder.append(answer.poll()).append(", ");
    }
    stringBuilder.deleteCharAt(stringBuilder.length()-1);
    stringBuilder.deleteCharAt(stringBuilder.length()-1);
    stringBuilder.append(">");

    System.out.println(stringBuilder);
  }
}
