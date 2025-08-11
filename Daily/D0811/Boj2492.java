package Daily.D0811;
import java.io.*;
import java.util.*;

public class Boj2492 {
    static int N, M, T, K;
    static int[] xs, ys;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 너비(x최대), M: 높이(y최대), T: 보석 수, K: 정사각형 한 변
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        xs = new int[T];
        ys = new int[T];

        // 입력 좌표는 (x y) 순서입니다.
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }

        int bestCnt = -1;
        int bestX = 0, bestYbottom = 0;

        // 왼쪽변 후보: 각 보석의 x
        // 아랫변 후보: 각 보석의 y
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
                int x = xs[i];
                int y = ys[j];

                // 사각형이 지도를 벗어나면 오른쪽/윗쪽에 붙이기 (클램프)
                if (x + K > N) x = N - K;
                if (y + K > M) y = M - K;

                // (이상 케이스 방지: 만약 K > N 또는 K > M이면 음수가 될 수 있음)
                if (x < 0 || y < 0) continue;

                int x2 = x + K;
                int y2 = y + K;

                int cnt = 0;
                for (int t = 0; t < T; t++) {
                    if (x <= xs[t] && xs[t] <= x2 && y <= ys[t] && ys[t] <= y2) {
                        cnt++;
                    }
                }

                if (cnt > bestCnt) {
                    bestCnt = cnt;
                    bestX = x;
                    bestYbottom = y;
                }
            }
        }

        // 출력은 좌상단 (x, y+K), 그리고 보석 개수
        System.out.println(bestX + " " + (bestYbottom + K));
        System.out.println(bestCnt);
    }
}
