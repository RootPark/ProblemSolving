package Daily.D0813;

import java.io.*;
import java.util.*;

public class Swea1486 {

    static int T, N, B, result;
    static int[] person;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            
            result = Integer.MAX_VALUE;
            person = new int[N];
            visited = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                person[n] = Integer.parseInt(st.nextToken());
            }
            
            subSet(0);
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static void subSet(int cnt) {
        if(cnt==N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    sum+=person[i];
                }
            }
            if(sum>=B) {
                int diff = sum-B;
                result = Math.min(diff, result);
            }
            return;
        }
        visited[cnt] = true;
        subSet(cnt+1);
        visited[cnt] = false;
        subSet(cnt+1);
    }

}