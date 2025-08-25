package Daily.D0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea3289 {
    static int ELEMENT_SIZE;
    static int[] parents;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1; t <= testCase; t++) {
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            ELEMENT_SIZE = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            parents = new int[ELEMENT_SIZE+1];
            make();

            for(int index = 0; index < M; index++) {
                st = new StringTokenizer(br.readLine());

                int flag = Integer.parseInt(st.nextToken());
                int element1 = Integer.parseInt(st.nextToken());
                int element2 = Integer.parseInt(st.nextToken());

                if(flag == 0) {
                    union(element1, element2);
                }
                else {
                    if(find(element1) == find(element2)) {
                        sb.append(1);
                    }
                    else{
                        sb.append(0);
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void make() {
        for(int index = 1; index <= ELEMENT_SIZE; index++) {
            parents[index] = index;
        }
    }

    public static int find(int element) {
        if(parents[element] == element) {
            return element;
        }

        return parents[element] = find(parents[element]);
    }

    public static boolean union(int element1, int element2) {
        int ele1Root = find(element1);
        int ele2Root = find(element2);

        if(ele1Root == ele2Root) {
            return false;
        }

        parents[ele2Root] = ele1Root;
        return true;
    }
}