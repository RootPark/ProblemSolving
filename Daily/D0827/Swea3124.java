package Daily.D0827;

import java.io.*;
import java.util.*;

public class Swea3124 {

    static List<Edge>[] edges;
    static boolean[] visited;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            edges = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++)
                edges[i] = new ArrayList<>();
            visited = new boolean[V + 1];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                long w = Long.parseLong(st.nextToken());
                edges[u].add(new Edge(v, w));
                edges[v].add(new Edge(u, w)); // 무방향
            }

            long mst = prim(1, V);
            sb.append('#').append(t).append(' ').append(mst).append('\n');
        }
        System.out.println(sb);
    }

    static long prim(int start, int V) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        // [to, weight]
        pq.add(new long[] { start, 0 });
        long total = 0;
        int picked = 0;

        while (!pq.isEmpty() && picked < V) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long w = cur[1];
            if (visited[u])
                continue;

            visited[u] = true;
            total += w;
            picked++;

            for (Edge e : edges[u]) {
                if (!visited[e.to])
                    pq.add(new long[] { e.to, e.w });
            }
        }
        return total; // 그래프가 연결이라고 가정 (SWEA 3124 조건)
    }
}

class Edge {
    int to;
    long w;

    Edge(int to, long w) {
        this.to = to;
        this.w = w;
    }
}