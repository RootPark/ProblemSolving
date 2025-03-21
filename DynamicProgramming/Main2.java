package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bufferedReader.readLine());

    arr = new int[N];

    System.out.println(prinaryNumber(N-1));
  }

  public static int prinaryNumber(int num){
    if(num == 0 || num == 1){
      return arr[num] = 1;
    }
    if(arr[num] > 0){
      return arr[num];
    }
    return arr[num] = prinaryNumber(num-2) + prinaryNumber(num-1);
  }
}
