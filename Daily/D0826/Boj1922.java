package Daily.D0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1922 {
    static int ELEMENT_SIZE;
    static int CONNECTION_SIZE;
    static int[] parents;

    static Edge[] edges;

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ELEMENT_SIZE = Integer.parseInt(br.readLine());
        CONNECTION_SIZE = Integer.parseInt(br.readLine());

        parents = new int[ELEMENT_SIZE];
        edges = new Edge[CONNECTION_SIZE];

        for (int index = 0; index < CONNECTION_SIZE; index++) {
            st = new StringTokenizer(br.readLine());
            int element1 = Integer.parseInt(st.nextToken()) - 1;
            int element2 = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            edges[index] = new Edge(element1, element2, weight);
        }

        Arrays.sort(edges);
        make();

        int result = 0;
        int count = 0;

        for (Edge edge : edges) {
            if (!union(edge.from, edge.to)) {
                continue;
            }
            result += edge.weight;

            if(++count == ELEMENT_SIZE-1) {
                break;
            }
        }

        System.out.println(result);
    }

    public static void make() {
        for (int elementIndex = 0; elementIndex < ELEMENT_SIZE; elementIndex++) {
            parents[elementIndex] = elementIndex;
        }
    }

    public static int find(int element) {
        if (parents[element] == element) {
            return element;
        }

        return parents[element] = find(parents[element]);
    }

    public static boolean union(int element1, int element2) {
        int ele1Root = find(element1);
        int ele2Root = find(element2);

        if (ele1Root == ele2Root) {
            return false;
        }

        if(ele1Root > ele2Root) {
            parents[ele2Root] = ele1Root;
        }
        else {
            parents[ele1Root] = ele2Root;
        }

        return true;
    }
}

class Edge implements Comparable<Edge> {
    int from, to, weight;

    public Edge(int from, int to, int weight) {
        super();
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}