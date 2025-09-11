package Daily.D0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea2383 {
    static int SIZE;
    static int[][] map;
    static int answer;
    static int[][] stairs;
    static Queue<Node> people;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            SIZE = Integer.parseInt(br.readLine());
            map = new int[SIZE][SIZE];
            stairs = new int[][] { { -1, -1 }, { -1, -1 } };
            people = new ArrayDeque<>();

            for (int index_x = 0; index_x < SIZE; index_x++) {
                st = new StringTokenizer(br.readLine());
                for (int index_y = 0; index_y < SIZE; index_y++) {
                    map[index_x][index_y] = Integer.parseInt(st.nextToken());
                    if (map[index_x][index_y] != 1 && map[index_x][index_y] != 0) {
                        if (stairs[0][0] == -1) {
                            stairs[0][0] = index_x;
                            stairs[0][1] = index_y;
                        } else {
                            stairs[1][0] = index_x;
                            stairs[1][1] = index_y;
                        }
                    }
                }
            }

            for (int index_x = 0; index_x < SIZE; index_x++) {
                for (int index_y = 0; index_y < SIZE; index_y++) {
                    int stair1Distance = Math.abs(stairs[0][0] - index_x) + Math.abs(stairs[0][1] - index_y);
                    int stair2Distance = Math.abs(stairs[1][0] - index_x) + Math.abs(stairs[1][1] - index_y);

                    int[] distanceArr = { stair1Distance, stair2Distance };
                    people.add(new Node(index_x, index_y, distanceArr));
                }
            }

            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }
}

class Node {
    int x, y;
    int[] distance;

    public Node(int x, int y, int[] distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}