package Daily.D0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1861 {

  static int[] delta_x = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
  static int[] delta_y = { 0, 0, -1, 1 };
  static int[][] rooms;
  static int N;
  static int maxRoom;
  static int maxMove;
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(in.readLine());

    for (int tc = 1; tc <= T; tc++) {
      sb.append("#").append(tc).append(" ");

      N = Integer.parseInt(in.readLine());
      rooms = new int[N][N];
      maxRoom = 0;
      maxMove = 0;

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(in.readLine());
        for (int j = 0; j < N; j++) {
          rooms[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          moveRoom(i, j, 1);
        }
      }

      sb.append(maxRoom).append(" ").append(maxMove).append("\n");
    }

    System.out.print(sb);
  }

  private static int moveRoom(int i, int j, int cnt) {
    for (int d = 0; d < 4; d++) {
      int ni = i + delta_x[d];
      int nj = j + delta_y[d];

      if (ni < 0 || ni >= N || nj < 0 || nj >= N)
        continue;
      else if (rooms[i][j] + 1 != rooms[ni][nj])
        continue;

      cnt = moveRoom(ni, nj, cnt + 1);

      if (maxMove < cnt) {
        maxMove = cnt;
        maxRoom = rooms[i][j];
      } else if (maxMove == cnt && maxRoom > rooms[i][j]) {
        maxRoom = rooms[i][j];
      }
      break;
    }
    return cnt;
  }

}