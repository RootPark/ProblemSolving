package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
  static int N;
  static int[] cards;
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    StringBuilder stringBuilder = new StringBuilder();

    N = Integer.parseInt(stringTokenizer.nextToken());
    cards = new int[N];
 
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for(int i=0;i<N;i++){
      cards[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    Arrays.sort(cards);

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int count = 0;
    for(int i=0;i<M;i++){
      int num = Integer.parseInt(stringTokenizer.nextToken());
      stringBuilder.append(upperBound(num)-lowerBound(num)).append(' ');
    }
    System.out.println(stringBuilder);
  }

  public static int lowerBound(int num){
    int left = 0;
    int right = N;

    while(left < right){
      int mid = (left+right) / 2;
      if(cards[mid] >= num){
        right = mid;
      }
      else{
        left = mid + 1;
      }
    }
    return left;
  }

  public static int upperBound(int num){
    int left = 0;
    int right = N;

    while(left < right){
      int mid = (left+right) / 2;
      if(cards[mid] > num){
        right = mid;
      }
      else{
        left = mid + 1;
      }
    }
    return left;
  }
}
