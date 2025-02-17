package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
  static long n;

  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    n = Long.parseLong(bufferedReader.readLine());

    long left = 0;
    long right = n;
    long answer = 0;

    while(left <= right) {
      long middle = (left + right) / 2;
      if (Math.pow(middle, 2) >= n) {
        answer = middle;
        right = middle - 1;
      }
      else if(Math.pow(middle, 2) < n) {
        left = middle + 1;
      }
    }
    System.out.println(answer);
  }

}
