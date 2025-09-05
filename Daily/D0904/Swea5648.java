package Daily.D0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Swea5648 {
    static int NUM_OF_ATOMS;
    static ArrayList<Node> list;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            NUM_OF_ATOMS = Integer.parseInt(br.readLine());
            list = new ArrayList<>();

            for (int indexOfAtom = 0; indexOfAtom < NUM_OF_ATOMS; indexOfAtom++) {
                st = new StringTokenizer(br.readLine());
                int coordinate_x = Integer.parseInt(st.nextToken()) * 2;
                int coordinate_y = Integer.parseInt(st.nextToken()) * 2;
                int direction = Integer.parseInt(st.nextToken());
                int energy = Integer.parseInt(st.nextToken());

                list.add(new Node(coordinate_x, coordinate_y, direction, energy));
            }

            sb.append("#").append(t).append(" ").append(makeBoomPair()).append("\n");
        }
        System.out.println(sb);
    }

    public static int makeBoomPair() {
        Collections.sort(list);
        ArrayList<Pair> boomList = new ArrayList<>();

        for (int index = 0; index < NUM_OF_ATOMS; index++) { // 선택할 첫번째 원자
            for (int secondIndex = index + 1; secondIndex < NUM_OF_ATOMS; secondIndex++) { // 선택할 두번째 원자
                Node node1 = list.get(index);
                Node node2 = list.get(secondIndex);

                // 같은 x좌표를 갖는 원자들이 수직선에서 만날때
                if (node1.coordinate_x == node2.coordinate_x) {
                    if (node1.direction == 0 && node2.direction == 1) {
                        boomList.add(
                                new Pair(index, secondIndex, Math.abs(node1.coordinate_y - node2.coordinate_y) / 2));
                    }
                }
                // 같은 y좌표를 갖는 원자들이 수평선에서 만날때
                if (node1.coordinate_y == node2.coordinate_y) {
                    if (node1.direction == 3 && node2.direction == 2) {
                        boomList.add(
                                new Pair(index, secondIndex, Math.abs(node1.coordinate_x - node2.coordinate_x) / 2));
                    }
                }
                // / 대각선 라인에 있는 대상들이 만날때
                if (node1.coordinate_x - node1.coordinate_y == node2.coordinate_x - node2.coordinate_y) {
                    if (node1.direction == 3 && node2.direction == 1 || node1.direction == 0 && node2.direction == 2) {
                        boomList.add(new Pair(index, secondIndex, Math.abs(node1.coordinate_x - node2.coordinate_x)));
                    }
                }
                // \ 대각선 라인에 있는 대상들이 만날때
                if (node1.coordinate_x + node1.coordinate_y == node2.coordinate_x + node2.coordinate_y) {
                    if (node1.direction == 1 && node2.direction == 2 || node1.direction == 3 && node2.direction == 0) {
                        boomList.add(new Pair(index, secondIndex, Math.abs(node1.coordinate_x - node2.coordinate_x)));
                    }
                }
            }
        }

        return getTotalEnerge(boomList);
    }

    public static int getTotalEnerge(ArrayList<Pair> boomList) {
        Collections.sort(boomList); // 터지는 시간기준 오름차순 정렬
        int INF = Integer.MAX_VALUE;

        int boomTimes[] = new int[NUM_OF_ATOMS];
        Arrays.fill(boomTimes, INF);

        int sum = 0;
        for (Pair p : boomList) {

            if (boomTimes[p.i] < p.time || boomTimes[p.j] < p.time) {
                continue;
            }

            if (boomTimes[p.i] == INF) {
                boomTimes[p.i] = p.time;
                sum += list.get(p.i).energy;
            }
            if (boomTimes[p.j] == INF) {
                boomTimes[p.j] = p.time;
                sum += list.get(p.j).energy;
            }
        }

        return sum;
    }
}

class Node implements Comparable<Node> {
    int coordinate_x;
    int coordinate_y;
    int direction;
    int energy;

    public Node(int coordinate_x, int coordinate_y, int direction, int energy) {
        super();
        this.coordinate_x = coordinate_x;
        this.coordinate_y = coordinate_y;
        this.direction = direction;
        this.energy = energy;
    }

    @Override
    public int compareTo(Node o) {
        // x좌표보다 작은 순, 같다면 y좌표가 작은 순
        if (this.coordinate_x < o.coordinate_x) {
            return -1;
        } else {
            if (this.coordinate_x != o.coordinate_x) {
                return Integer.compare(this.coordinate_x, o.coordinate_x);
            } else {
                return Integer.compare(this.coordinate_y, o.coordinate_y);
            }
        }

    }
}

class Pair implements Comparable<Pair> { // 충돌리스트에 담을 충돌하는 두 원자와 그때의 시간 정보.
    int i, j, time;

    public Pair(int i, int j, int time) {
        super();
        this.i = i;
        this.j = j;
        this.time = time;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.time, o.time);
    }
}