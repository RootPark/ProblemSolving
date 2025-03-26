package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bufferedReader.readLine());

    int[] arr = new int[N];

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    int left = 0;
    int right = N - 1;

    int min = Integer.MAX_VALUE;
    while (left < right) {
      int num = arr[left] + arr[right];
      if(Math.abs(num) < Math.abs(min)){
        min = num;
      }

      if(num < 0){
        left++;
      }
      if(num > 0){
        right--;
      }
      if(num == 0){
        min = 0;
        break;
      }
    }
    System.out.println(min);
  }
}
