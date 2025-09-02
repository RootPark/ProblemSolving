package Daily.D0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraTest {

    static class Node {
        int to, weight;
        Node next;

        public Node(int to, int weight, Node next) {
            super();
            this.to = to;
            this.weight = weight;
            this.next = next;
        }
    }

    static class Vertex implements Comparable<Vertex> {
        int no, totalDistance;

        public Vertex(int no, int totalDistance) {
            super();
            this.no = no;
            this.totalDistance = totalDistance;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.totalDistance, o.totalDistance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Node[] adjList = new Node[V];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, weight, adjList[from]);
        } // 그래프 인접리스트 완성

        int[] minDistance = new int[V]; // start 정점에서 자신으로의 최소비용
        boolean[] visited = new boolean[V];

        // step 0
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        final int INF = Integer.MAX_VALUE;
        Arrays.fill(minDistance, INF);
        minDistance[start] = 0;
        pq.offer(new Vertex(start, minDistance[start]));

        while(!pq.isEmpty()) {
            // step 1 : 미방문정점중에 출발점에서 가장 가까운 정점 찾기
            Vertex stopOver = pq.poll();
            if (visited[stopOver.no]) {
                continue;
            }
            visited[stopOver.no] = true;

            if(stopOver.no == end) {
                break;
            }

            // step 2 : step 1 에서 선택된 정점을 경유지로 하여 아직 미방문정점으로의 경로 비용 계산 후 최소비용으로 업데이트..
            for (Node temp = adjList[stopOver.no]; temp != null; temp = temp.next) {
                if (!visited[temp.to] && minDistance[temp.to] > stopOver.totalDistance + temp.weight) {
                    minDistance[temp.to] = stopOver.totalDistance + temp.weight;
                    pq.offer(new Vertex(temp.to, minDistance[temp.to]));
                }
            }
        }
        System.out.println(Arrays.toString(minDistance));
        System.out.println(minDistance[end] != INF ? minDistance[end] : -1);

    }
}
