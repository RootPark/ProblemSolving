package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(bufferedReader.readLine());
    int M = Integer.parseInt(bufferedReader.readLine());

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int[] arr = new int[N];

    for(int i = 0;i < N ;i++){
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    Arrays.sort(arr);

    int left = 0;
    int right = arr.length-1;

    int count = 0;

    while(left < right){
      if (arr[left] + arr[right] > M){
        right--;
      }
      else if (arr[left] + arr[right] < M){
        left++;
      }
      else{
        count++;
        left++;
        right--;
      }
    }

    System.out.println(count);
  }
}