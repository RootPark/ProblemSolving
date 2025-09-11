package Daily.D0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea7793 {
    static int HEIGHT;
    static int WIDTH;
    static String answer;
    static char[][] map;
    static int[] delta_x = { 0, 0, 1, -1 }; // 동 서 남 북
    static int[] delta_y = { -1, 1, 0, 0 };
    static int MOVE_COUNT = 4;
    static Queue<Node> devil;
    static Queue<Node> person;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            st = new StringTokenizer(br.readLine());

            HEIGHT = Integer.parseInt(st.nextToken());
            WIDTH = Integer.parseInt(st.nextToken());
            map = new char[HEIGHT][WIDTH];

            devil = new ArrayDeque<>();
            person = new ArrayDeque<>();

            for (int heightIndex = 0; heightIndex < HEIGHT; heightIndex++) {
                String line = br.readLine();
                for (int widthIndex = 0; widthIndex < WIDTH; widthIndex++) {
                    map[heightIndex][widthIndex] = line.charAt(widthIndex);
                    if (map[heightIndex][widthIndex] == 'S') {
                        person.add(new Node(heightIndex, widthIndex, 0));
                    }
                    if (map[heightIndex][widthIndex] == '*') {
                        devil.add(new Node(heightIndex, widthIndex, 0));
                    }
                }
            }

            answer = Integer.toString(bfs());
            if (answer.equals("-1")) {
                answer = "GAME OVER";
            }

            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < HEIGHT && y < WIDTH;
    }

    public static int bfs() {
        while (!person.isEmpty()) {
            for (int devilIndex = 0; devilIndex < devil.size(); devilIndex++) {
                Node currentDevil = devil.poll();

                for (int moveIndex = 0; moveIndex < MOVE_COUNT; moveIndex++) {
                    int newX = currentDevil.x + delta_x[moveIndex];
                    int newY = currentDevil.y + delta_y[moveIndex];
                    if (!isValid(newX, newY)) {
                        continue;
                    }
                    if (map[newX][newY] == 'X' || map[newX][newY] == 'D' || map[newX][newY] == '*') {
                        continue;
                    }
                    map[newX][newY] = '*';
                    devil.add(new Node(newX, newY, 0));
                }
            }

            for (int personIndex = 0; personIndex < person.size(); personIndex++) {
                Node currentPerson = person.poll();

                for (int moveIndex = 0; moveIndex < MOVE_COUNT; moveIndex++) {
                    int newX = currentPerson.x + delta_x[moveIndex];
                    int newY = currentPerson.y + delta_y[moveIndex];
                    if (!isValid(newX, newY)) {
                        continue;
                    }
                    if (map[newX][newY] == 'X' || map[newX][newY] == '*') {
                        continue;
                    }
                    if (map[newX][newY] == 'D') {
                        return currentPerson.count + 1;
                    }
                    if (map[newX][newY] == '.') {
                        map[newX][newY] = 'S';
                        person.add(new Node(newX, newY, currentPerson.count + 1));
                    }
                }
            }
        }

        return -1;
    }
}

class Node {
    int x, y, count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}