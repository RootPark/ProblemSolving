package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();

    int T = Integer.parseInt(bufferedReader.readLine());

    long[] measureSum = new long[1000001];
    long[] prefixMeasureSum = new long[1000001];

    for (int i = 0; i < measureSum.length; i++) {
      measureSum[i] = 1;
    }

    for(int i=2;i<measureSum.length;i++){
      for(int j=1;j*i<measureSum.length;j++){
        measureSum[i*j] +=i;
      }
    }

    for(int i=1;i<measureSum.length;i++){
      prefixMeasureSum[i] = prefixMeasureSum[i-1] + measureSum[i];
    }

    for(int i=0;i<T;i++){
      int N = Integer.parseInt(bufferedReader.readLine());
      stringBuilder.append(prefixMeasureSum[N]).append("\n");
    }

    System.out.println(stringBuilder);

  }
}
