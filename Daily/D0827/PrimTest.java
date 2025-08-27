package Daily.D0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 5
 * 0 5 10 8 7
 * 5 0 5 3 6
 * 10 5 0 1 3
 * 8 3 1 0 1
 * 7 6 3 1 0
 * 
 * output => 10
 * 
 * 7
 * 0 32 31 0 0 60 51
 * 32 0 21 0 0 0 0
 * 31 21 0 0 46 0 25
 * 0 0 0 0 34 18 0
 * 0 0 46 34 0 40 51
 * 60 0 0 18 40 0 0
 * 51 0 25 0 51 0 0
 * 
 * output => 175
 */

public class PrimTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine()); // 정점 수

        int[][] adjMatrix = new int[V][V]; // 인접 행렬
        boolean[] visited = new boolean[V]; // MST 트리에 속하는 정점인지 체크

        int[] minEdge = new int[V]; // 각 정점 기준으로 타 정점과 연결시 최소 간선 비용

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // step0 전처리 : 모든 minEdge 값을 최대로...
        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[0] = 0; // 임의의 시작정점의 간선비용은 0으로...

        int result = 0; // MST 비용
        int c;
        for (c = 0; c < V; c++) {
            // step1. 비트리 정점중 간선비용이 최소인 정점 찾기
            int min = Integer.MAX_VALUE;
            int minVertex = -1;
            for (int i = 0; i < V; i++) {
                if (visited[i] || min <= minEdge[i]) {
                    continue; // 트리 정점이면 패스
                }
                if (min > minEdge[i]) {
                    min = minEdge[i];
                    minVertex = i;
                }
            }

            if (minVertex == -1) {
                break; // 만약에 모든 노드가 연결이 되는 상황이 아니라면, step1에서 정점을 찾지 못해서 minVertex가 변하지 않음
            }
            result += minEdge[minVertex];
            visited[minVertex] = true;

            // step2. 현재 단계에서 트리에 추가된 최소간선비용 정점 기준으로 인접정점 들여다 보며 영업하기!!!
            for (int i = 0; i < V; i++) {
                if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
                    minEdge[i] = adjMatrix[minVertex][i];
                }
            }
        }

        System.out.println(c == V ? result : -1);
    }
}