package Daily.D0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea2382 {
    static int SIZE;
    static int TIME;
    static int NUM;
    static Micro[][] map;
    static Micro[] micros;
    static int answer;

    static int[] delta_x = { 0, -1, 1, 0, 0 };
    static int[] delta_y = { 0, 0, 0, -1, 1 };
    // 0 상 하 좌 우

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            st = new StringTokenizer(br.readLine());
            SIZE = Integer.parseInt(st.nextToken());
            TIME = Integer.parseInt(st.nextToken());
            NUM = Integer.parseInt(st.nextToken());

            answer = 0;

            micros = new Micro[NUM];

            for (int index = 0; index < NUM; index++) {
                st = new StringTokenizer(br.readLine());
                int xCoordinate = Integer.parseInt(st.nextToken());
                int yCoordinate = Integer.parseInt(st.nextToken());
                int numOfMicro = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());

                micros[index] = new Micro(xCoordinate, yCoordinate, numOfMicro, direction);
            }

            for (int time = 0; time < TIME; time++) {
                map = new Micro[SIZE][SIZE];

                for (int microIndex = 0; microIndex < NUM; microIndex++) {
                    Micro current = micros[microIndex];

                    if (current.num == 0 || current.isDead) {
                        continue;
                    }

                    current.x += delta_x[current.direction];
                    current.y += delta_y[current.direction];

                    if (isEdge(current.x, current.y)) {
                        current.num /= 2;

                        if (current.num == 0) {
                            current.isDead = true;
                            continue;
                        }
                        if (current.direction == 1) {
                            current.direction = 2;
                        }
                        if (current.direction == 2) {
                            current.direction = 1;
                        }
                        if (current.direction == 3) {
                            current.direction = 4;
                        }
                        if (current.direction == 4) {
                            current.direction = 3;
                        }
                    }

                    if (map[current.x][current.y] == null) {
                        map[current.x][current.y] = current;
                    } else {
                        Micro pre = map[current.x][current.y];

                        if (pre.num > current.num) {
                            pre.num += current.num;
                            current.num = 0;
                            current.isDead = true;
                        } else {
                            current.num += pre.num;
                            map[current.x][current.y] = current;
                            pre.num = 0;
                            pre.isDead = true;
                        }
                    }
                }
            }

            for (int index_x = 0; index_x < SIZE; index_x++) {
                for (int index_y = 0; index_y < SIZE; index_y++) {
                    if (map[index_x][index_y] != null) {
                        answer += map[index_x][index_y].num;
                    }
                }
            }
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

    public static boolean isEdge(int x, int y) {
        return x == 0 || y == 0 || x == SIZE - 1 || y == SIZE - 1;
    }
}

class Micro {
    int x, y, num, direction;
    boolean isDead;
    public Micro(int x, int y, int num, int direction) {
        this.x = x;
        this.y = y;
        this.num = num;
        this.direction = direction;
        this.isDead = false;
    }
}
