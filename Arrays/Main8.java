package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main8 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bufferedReader.readLine());

    Ball[] balls = new Ball[N];
    int[] results = new int[N];
    for (int i = 0; i < N; i++) {
      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
      int color = Integer.parseInt(stringTokenizer.nextToken());
      int size = Integer.parseInt(stringTokenizer.nextToken());
      balls[i] = new Ball(i, color, size);
    }

    Arrays.sort(balls, (o1,o2)-> o1.size - o2.size);

    int[] colors = new int[N+1];
    int ballIndex = 0;
    int sum = 0;
    for(int i=0;i<N;i++){
      while(balls[ballIndex].size <balls[i].size){
        sum+= balls[ballIndex].size;
        colors[balls[ballIndex].color] += balls[ballIndex].size;
        ballIndex++;
      }
      results[balls[i].index] = sum - colors[balls[i].color];
    }

    for(int i=0;i<N;i++){
      System.out.println(results[i]);
    }

  }
}

class Ball {
  int index, color, size, result;

  Ball(int index, int color, int size) {
    this.index = index;
    this.color = color;
    this.size = size;
  }

}
