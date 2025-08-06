package Daily.D0806;

import java.io.*;
import java.util.*;

public class Main1 {

    static int[] permutation;
    static boolean[] visited;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        permutation = new int[M];
        visited = new boolean[N];

        dfs(N,M,0);
        System.out.println(stringBuilder);
    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for(int i=0;i<M;i++){
                stringBuilder.append(permutation[i]).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        else{
            for(int i=0;i<N;i++){
                if(visited[i] == false){
                    visited[i] = true;
                    permutation[depth] = i+1;

                    dfs(N,M,depth+1);
                    visited[i] = false;
                }
            }
            
        }
    }
}
