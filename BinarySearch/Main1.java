package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    int N = Integer.parseInt(bufferedReader.readLine());

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int[] cards = new int[N];

    for(int i=0;i<N;i++){
      cards[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    Arrays.sort(cards);

    int M = Integer.parseInt(bufferedReader.readLine());
    int[] cardsToFind = new int[M];

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for(int i=0;i<M;i++){
      cardsToFind[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    for(int i=0;i<M;i++){
      int left = 0;
      int right = N-1;
      boolean flag = false;
      while(left <= right){
        int mid = (left + right) / 2;
        if(cards[mid] < cardsToFind[i]){
          left = mid + 1;
        }
        else if(cards[mid] > cardsToFind[i]){
          right = mid - 1;
        }
        else{ 
          flag = true;
          break;
        }
      }

      if(flag){
        stringBuilder.append("1 ");
      }
      else{
        stringBuilder.append("0 ");
      }
    }

    System.out.println(stringBuilder);

  }
}
