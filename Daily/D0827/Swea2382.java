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

                int[][] sum = new int[SIZE][SIZE];
                int[][] maxNum = new int[SIZE][SIZE];
                int[][] maxIdx = new int[SIZE][SIZE];
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        maxIdx[i][j] = -1;
                    }
                }

                for (int microIndex = 0; microIndex < NUM; microIndex++) {
                    Micro current = micros[microIndex];

                    if (current.num == 0 || current.isDead) {
                        continue;
                    }

                    int nx = current.x + delta_x[current.direction];
                    int ny = current.y + delta_y[current.direction];

                    if (isEdge(nx, ny)) {
                        current.num /= 2;
                        if (current.num == 0) {
                            current.isDead = true;
                            current.x = nx;
                            current.y = ny;
                            continue;
                        }
                        current.direction = reverse(current.direction);
                    }
                    current.x = nx;
                    current.y = ny;

                    sum[current.x][current.y] += current.num;
                    if (current.num > maxNum[current.x][current.y]) {
                        maxNum[current.x][current.y] = current.num;
                        maxIdx[current.x][current.y] = microIndex;
                    }
                }
                
                for (int microIndex = 0; microIndex < NUM; microIndex++) {
                    Micro current = micros[microIndex];
                    if (current.num == 0 || current.isDead)
                        continue;

                    int x = current.x;
                    int y = current.y;

                    if (maxIdx[x][y] == microIndex) {
                        current.num = sum[x][y]; 
                    } else {
                        current.num = 0;
                        current.isDead = true;
                    }
                }

            }

            int answer = 0;
            for (Micro m : micros)
                answer += m.num;
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

    public static boolean isEdge(int x, int y) {
        return x == 0 || y == 0 || x == SIZE - 1 || y == SIZE - 1;
    }

    public static int reverse(int d) {
        return (d == 1) ? 2 : (d == 2) ? 1 : (d == 3) ? 4 : 3;
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
