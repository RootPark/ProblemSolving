package Daily.D0821;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Swea1227 {
    static int[][] maze;
    static boolean[][] visited;
    static int[] dirX = { -1, 1, 0, 0 };
    static int[] dirY = { 0, 0, -1, 1 };
    static int[] start, end;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine(); // 테스트케이스 번호 입력 무시
            maze = new int[100][100];
            visited = new boolean[100][100];
            for (int i = 0; i < 100; i++) {
                String line = br.readLine();
                for (int j = 0; j < 100; j++) {
                    maze[i][j] = line.charAt(j) - '0';
                    if (maze[i][j] == 2) {
                        start = new int[] { i, j };
                    }
                    if (maze[i][j] == 3) {
                        end = new int[] { i, j };
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(bfs() ? "1" : "0").append("\n");
        }
        System.out.print(sb);
    }

    private static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dirX[d];
                int ny = y + dirY[d];
                if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100)
                    continue;
                if (maze[nx][ny] == 1 || visited[nx][ny])
                    continue;
                if (nx == end[0] && ny == end[1])
                    return true;
                visited[nx][ny] = true;
                queue.offer(new int[] { nx, ny });
            }
        }
        return false;
    }
}
