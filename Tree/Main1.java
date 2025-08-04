package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1 {
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<List<Integer>> connection = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            connection.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];
        parents = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            connection.get(num1).add(num2);
            connection.get(num2).add(num1);
        }

        bfs(1, connection, parents, visited);

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    public static void bfs(int root, List<List<Integer>> list, int[] parents, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited[root] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int nearNode : list.get(current)) {
                if (!visited[nearNode]) {
                    visited[nearNode] = true;
                    parents[nearNode] = current;
                    queue.add(nearNode);
                }
            }
        }
    }

}