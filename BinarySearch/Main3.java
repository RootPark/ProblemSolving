package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(bufferedReader.readLine());

    long left = 0;
    long right = n;
    long answer = 0;

    while(left <= right){
      long mid = (left+right) / 2;
      if(Math.pow(mid,2) >= n){
        answer = mid;
        right = mid - 1;
      }
      else{
        left = mid + 1;
      }
    }
    System.out.println(answer);
  }
}
