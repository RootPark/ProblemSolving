package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main1 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    StringBuilder stringBuilder = new StringBuilder();

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());

    Map<String, String> map = new HashMap<>();

    for(int i=0;i<N;i++){
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      map.put(stringTokenizer.nextToken(), stringTokenizer.nextToken());
    }

    for(int i=0;i<M;i++){
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      stringBuilder.append(map.get(stringTokenizer.nextToken())).append("\n");
    }

    System.out.println(stringBuilder);

  }
}
