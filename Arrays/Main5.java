package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String S = bufferedReader.readLine();
    StringBuilder stringBuilder = new StringBuilder();

    int q = Integer.parseInt(bufferedReader.readLine());

    int[][] prefixSum = new int[S.length()+1][26];

    for(int i=1;i<=S.length();i++){
      for(int j=0;j<26;j++){
        prefixSum[i][j] = prefixSum[i-1][j];
      }
      prefixSum[i][S.charAt(i-1)-'a'] +=1;
    }

    for(int i=0;i<q;i++){
      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      char alpha = stringTokenizer.nextToken().charAt(0);
      int start = Integer.parseInt(stringTokenizer.nextToken());
      int end = Integer.parseInt(stringTokenizer.nextToken());

      stringBuilder.append(prefixSum[end+1][alpha-'a'] - prefixSum[start][alpha-'a']).append("\n");
    }

    System.out.println(stringBuilder);

  }
}
