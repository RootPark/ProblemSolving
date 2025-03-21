package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
  static long[] arr;
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine());

    arr = new long[n+1];


    System.out.println(find(n-1));
  }

  public static long find(int num){
    if(num == 0){
      return arr[num] = 1;
    }
    if(num == 1){
      return arr[num] = 3;
    }
    if(arr[num] > 0){
      return arr[num];
    }
    return arr[num] = (find(num-1) + find(num-2) * 2)%10007;
  }
}
