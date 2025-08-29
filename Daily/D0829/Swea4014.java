package Daily.D0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea4014 {
    static int LENGTH;
    static int RUNWAY_LENGTH;
    static int answer;
    static int maxHeight;
    static int[][] area;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1; t <= testCase; t++) {
            st = new StringTokenizer(br.readLine());
            LENGTH = Integer.parseInt(st.nextToken());
            RUNWAY_LENGTH = Integer.parseInt(st.nextToken());
            maxHeight = Integer.MIN_VALUE;
            
            for(int areaIndex_x = 0; areaIndex_x < LENGTH; areaIndex_x++) {
                st = new StringTokenizer(br.readLine());
                for(int areaIndex_y = 0; areaIndex_y < LENGTH; areaIndex_y++) {
                    int height = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(height, maxHeight);
                    area[areaIndex_x][areaIndex_y] = height;
                }
            }

            sb.append('#').append(t).append(' ').append('\n');
        }
        System.out.println(sb);
    }

    public static void searchRow() { // 가로 탐색
        for(int index_x = 0 ; index_x < LENGTH; index_x++) {
            for(int index_y = 0; index_y < LENGTH; index_y++) {
                
            }
        }
    }

    public static void searchColumn() { // 세로 탐색
        for(int index_y = 0 ; index_y < LENGTH; index_y++) {
            for(int index_x = 0; index_x < LENGTH; index_x++) {
                
            }
        }
    }
}
