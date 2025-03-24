package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main8 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bufferedReader.readLine());

    Ball[] balls = new Ball[N];

    StringTokenizer stringTokenizer;

    for(int i=0;i<N;i++){
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int color = Integer.parseInt(stringTokenizer.nextToken());
      int size = Integer.parseInt(stringTokenizer.nextToken());
      balls[i] = new Ball(i, color, size);
    }

    Arrays.sort(balls, (a1,a2)-> Integer.compare(a1.getSize(), a2.getSize()));

    int[] answer = new int[N];
    int[] colors = new int[N+1];
    int sum = 0;

    for(int i=0, j=0;i<N;i++){
      Ball ball = balls[i];
      Ball ballNext = balls[j];

      while(ball.size > ballNext.size){
        sum+=ballNext.size;
        colors[ballNext.color] += ballNext.size;
        ballNext = balls[++j];
      }
      
      answer[ball.index] = sum - colors[ball.color]; 
    }

    for(int i=0;i<N;i++){
      System.out.println(answer[i]);
    }
  }
}

class Ball{
  int index;
  int color;
  int size;
  Ball(int index, int color, int size){
    this.index = index;
    this.color = color;
    this.size = size;
  }

  public int getSize(){
    return size;
  }
}
