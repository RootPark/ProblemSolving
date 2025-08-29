package Daily.D0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea4013 {
    static int MAGNET_COUNT = 4;
    static int MAGNET_POINT_COUNT = 8;
    static int MAGNET_LEFT = 6;
    static int MAGNET_RIGHT = 2;
    static int ROTATION_COUNT;
    static List<Deque<Integer>> magnets;
    static boolean[] visitied;
    static int answer;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            ROTATION_COUNT = Integer.parseInt(br.readLine());
            magnets = new ArrayList<>();
            answer = 0;

            for (int magnetIndex = 0; magnetIndex < MAGNET_COUNT; magnetIndex++) {
                magnets.add(new LinkedList<>());
                st = new StringTokenizer(br.readLine());
                for (int magnetPointIndex = 0; magnetPointIndex < MAGNET_POINT_COUNT; magnetPointIndex++) {
                    magnets.get(magnetIndex).add(Integer.parseInt(st.nextToken()));
                }
            }

            for (int rotationIndex = 0; rotationIndex < ROTATION_COUNT; rotationIndex++) {
                visitied = new boolean[MAGNET_COUNT];

                st = new StringTokenizer(br.readLine());
                int magnetIndex = Integer.parseInt(st.nextToken()) - 1;
                int rotateDirection = Integer.parseInt(st.nextToken()); // 1 이면 시계방향, -1이면 반시계방향

                rotate(magnetIndex, rotateDirection);
            }

            calculatePoints();
            sb.append('#').append(t).append(' ').append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static void calculatePoints() {
        for (int magnetIndex = 0; magnetIndex < MAGNET_COUNT; magnetIndex++) {
            if (magnets.get(magnetIndex).peek() == 0) {
                continue;
            } else {
                answer += Math.pow(2, magnetIndex);
            }
        }
    }

    public static void rotate(int magnetIndex, int rotateDirection) {
        if (visitied[magnetIndex]) {
            return;
        }

        visitied[magnetIndex] = true;

        if (magnetIndex - 1 >= 0) {
            int thisLeft = ((LinkedList<Integer>) magnets.get(magnetIndex)).get(MAGNET_LEFT);
            int leftRight = ((LinkedList<Integer>) magnets.get(magnetIndex-1)).get(MAGNET_RIGHT);

            if (thisLeft != leftRight) {
                rotate(magnetIndex - 1, -rotateDirection);
            }
        }

        if (magnetIndex + 1 < MAGNET_COUNT) {
            int thisRight = ((LinkedList<Integer>) magnets.get(magnetIndex)).get(MAGNET_RIGHT);
            int rightLeft = ((LinkedList<Integer>) magnets.get(magnetIndex+1)).get(MAGNET_LEFT);

            if (thisRight != rightLeft) {
                rotate(magnetIndex + 1, -rotateDirection);
            }
        }

        rotateSelf(magnetIndex, rotateDirection);

    }

    public static void rotateSelf(int magnetIndex, int rotateDirection) {
        if (rotateDirection == 1) {
            magnets.get(magnetIndex).addFirst(magnets.get(magnetIndex).pollLast());
        } else {
            magnets.get(magnetIndex).addLast(magnets.get(magnetIndex).pollFirst());
        }
    }
}
