package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine());

    int[] arr = new int[n];

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    int k = Integer.parseInt(bufferedReader.readLine());

    long count = 0;

    int pointer1 = 0;
    int pointer2 = 0;
    long sum = 0;

    while(true){
      if(sum > k){
        count += (n-pointer2+1);
        sum -= arr[pointer1];
        pointer1++;
      }
      else if (pointer2 == n){
        break;
      }
      else{
        sum += arr[pointer2];
        pointer2++;
      }
    }
    System.out.println(count);
  }
}
