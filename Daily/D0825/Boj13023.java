package Daily.D0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj13023 {
    static int ELEMENT_SIZE;
    static ArrayList<Integer>[] elements;
    static boolean[] visited;
    static int flag = 0;

    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        ELEMENT_SIZE = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        elements = new ArrayList[ELEMENT_SIZE];
        visited = new boolean[ELEMENT_SIZE];

        for(int index = 0; index < ELEMENT_SIZE; index++) {
            elements[index] = new ArrayList<Integer>();
        }
        for(int index = 0; index < M; index++) {
            st = new StringTokenizer(br.readLine());
            int element1 = Integer.parseInt(st.nextToken());
            int element2 = Integer.parseInt(st.nextToken());
            elements[element1].add(element2);
            elements[element2].add(element1);
        }

        for(int index = 0; index < ELEMENT_SIZE; index++) {
            if(flag == 0) {
                dfs(index, 1);
            }
        }
        System.out.println(flag);
        
    }

    public static void dfs(int start, int depth) {
        if(depth==5) {
            flag = 1;
            return;
        }

        visited[start] = true;

        for(int index : elements[start]) {
            int next = index;

            if(!visited[next]) {
                dfs(next, depth+1);
            }
        }
        visited[start] = false;
    }
}
