package Daily.D0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea1238 {

    static int TEST_CASE = 10;
    static int start;
    static int DATA_LENGTH;
    static ArrayList<ArrayList<Integer>> nodes;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= TEST_CASE; t++) {
            st = new StringTokenizer(br.readLine());
            DATA_LENGTH = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            nodes = new ArrayList<>();

            for (int index = 0; index <= 100; index++) {
                nodes.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int dataIndex = 0; dataIndex < DATA_LENGTH /2; dataIndex++) {
                int startNode = Integer.parseInt(st.nextToken());
                int endNode = Integer.parseInt(st.nextToken());
                nodes.get(startNode).add(endNode);
            }

            sb.append("#").append(t).append(" ").append(findNode(start)).append("\n");
        }

        System.out.println(sb);
    }

    public static int findNode(int node) {
        visited = new boolean[101];

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(node);

        visited[node] = true;
        int last = 0;
        int size = 0;

        while (!queue.isEmpty()) {
            last = 0;
            size = queue.size();
            for (int index = 0; index < size; index++) {
                int current = queue.poll();
                last = Math.max(current, last);

                for (int num : nodes.get(current)) {
                    if (visited[num]) {
                        continue;
                    }
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
        return last;
    }
}
