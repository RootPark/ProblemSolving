package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();

    String S = bufferedReader.readLine();

    int[][] charCount = new int[S.length()][26];
    int[][] prefixSum = new int[S.length()+1][26];

    for(int i=0;i<S.length();i++){
      int index = S.charAt(i) - 'a';  
      charCount[i][index]++;
    }

    for(int j=0;j<26;j++){
      for(int i=1;i<=S.length();i++){
        prefixSum[i][j] = prefixSum[i-1][j] + charCount[i-1][j];
      }
    }

    int q = Integer.parseInt(bufferedReader.readLine());

    StringTokenizer stringTokenizer;
    for(int i=0;i<q;i++){
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      char alpha = stringTokenizer.nextToken().charAt(0);
      int l = Integer.parseInt(stringTokenizer.nextToken());
      int r = Integer.parseInt(stringTokenizer.nextToken());
      int answer = prefixSum[r+1][alpha-'a'] - prefixSum[l][alpha-'a'];
      stringBuilder.append(answer).append("\n");
    }
    
    System.out.println(stringBuilder);
  }
}
