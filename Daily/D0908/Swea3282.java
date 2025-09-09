package Daily.D0908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea3282 {
    static int STUFF_COUNT;
    static int WEIGHT_COUNT;
    static int[][] stuff;
    static int[][] sum;
    static int WEIGHT_INDEX = 0;
    static int VALUE_INDEX = 1;
    static int maxValue;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            st = new StringTokenizer(br.readLine());
            STUFF_COUNT = Integer.parseInt(st.nextToken());
            WEIGHT_COUNT = Integer.parseInt(st.nextToken());

            maxValue = Integer.MIN_VALUE;
            stuff = new int[STUFF_COUNT+1][2];
            sum = new int[STUFF_COUNT+1][WEIGHT_COUNT+1];

            for (int stuffIndex = 1; stuffIndex <= STUFF_COUNT; stuffIndex++) {
                st = new StringTokenizer(br.readLine());
                stuff[stuffIndex][WEIGHT_INDEX] = Integer.parseInt(st.nextToken());
                stuff[stuffIndex][VALUE_INDEX] = Integer.parseInt(st.nextToken());
            }

            for (int stuffIndex = 1; stuffIndex <= STUFF_COUNT; stuffIndex++) {
                for (int weightIndex = 1; weightIndex <= WEIGHT_COUNT; weightIndex++) {
                    if (stuff[stuffIndex][WEIGHT_INDEX] > weightIndex) {
                        sum[stuffIndex][weightIndex] = sum[stuffIndex-1][weightIndex];
                    }
                    else {
                        sum[stuffIndex][weightIndex] = Math.max(sum[stuffIndex-1][weightIndex], sum[stuffIndex-1][weightIndex- stuff[stuffIndex][WEIGHT_INDEX]] + stuff[stuffIndex][VALUE_INDEX]);
                    }
                }
            }

            sb.append('#').append(t).append(' ').append(sum[STUFF_COUNT][WEIGHT_COUNT]).append('\n');
        }
        System.out.println(sb);
    }
}