package Array;

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

    int sum = 0;
    for(int i=0;i<10;i++){
      sum+=arr[i];
      if(sum>100){
        if(sum - 100 <= 100 - (sum-arr[i])){
          break;
        }
        else{
          sum-=arr[i];
          break;
        }
      }
    }
    System.out.println(sum);
  }
}
