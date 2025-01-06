package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[10];

    for (int i = 0; i < 10; i++) {
      arr[i] = Integer.parseInt(bufferedReader.readLine());
    }

    int answer = 0;

    for (int i = 0; i < 10; i++) {
      answer += arr[i];
      if (answer > 100) {
        if(answer-100 <= 100-(answer-arr[i])){
          break;
        }
        else{
          answer-=arr[i];
          break;
        }
      }
    }

    System.out.println(answer);
  }
}
