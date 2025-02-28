package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bufferedReader.readLine());

    int answer = 0;

    while(N>answer){
      int sum = answer;
      int copyNum = answer;
      while(copyNum!=0){
        sum+=copyNum%10;
        copyNum/=10;
      }
      if(sum == N){
        break;
      }
      else{
        answer++;
      }
    }

    if(answer == N){
      System.out.println(0);
    }
    else{
      System.out.println(answer);
    }
  }
}
