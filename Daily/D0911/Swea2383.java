package Daily.D0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Swea2383 {
    static final int MOVE = 1, WAIT = 2, DOWN = 3, CLEAR = 4;

    static int SIZE, min, count;
    static int[][] stairList;
    static ArrayList<Person> personList;
    static int[] selected;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            SIZE = Integer.parseInt(br.readLine());

            personList = new ArrayList<>();
            stairList = new int[2][];

            min = Integer.MAX_VALUE;

            for (int indexX = 0, k = 0; indexX < SIZE; indexX++) {
                st = new StringTokenizer(br.readLine());
                for (int indexY = 0; indexY < SIZE; indexY++) {
                    int c = Integer.parseInt(st.nextToken());
                    if (c == 1) {
                        personList.add(new Person(indexX, indexY));
                    } else if (c > 1) {
                        stairList[k++] = new int[] { indexX, indexY, c };
                    }
                }
            }
            count = personList.size();
            selected = new int[count];

            divide(0);
            sb.append('#').append(t).append(' ').append(min).append('\n');
        }
        System.out.println(sb);
    }

    public static void divide(int index) {

        if (index == count) {
            makeList();
            return;
        }

        selected[index] = 0;
        divide(index + 1);

        selected[index] = 1;
        divide(index + 1);
    }

    public static void makeList() {
        ArrayList<Person>[] list = new ArrayList[] { new ArrayList<Person>(), new ArrayList<Person>() };

        for (int index = 0; index < count; index++) {
            Person p = personList.get(index);
            p.init();
            int no = selected[index];

            p.arrivalTime = Math.abs(p.row - stairList[no][0]) + Math.abs(p.column - stairList[no][1]);
            list[no].add(p);
        }

        int timeA = processDown(list[0], stairList[0][2]);
        int timeB = processDown(list[1], stairList[1][2]);
        int res = Math.max(timeA, timeB);
        min = Math.min(min, res);
    }

    public static int processDown(ArrayList<Person> list, int height) {
        if (list.size() == 0) {
            return 0;
        }

        Collections.sort(list);
        int time = list.get(0).arrivalTime;
        int size = list.size();
        int ingCount = 0, cCount = 0;

        while (true) {
            for (int index = 0; index < size; index++) {
                Person p = list.get(index);
                if (p.status == CLEAR) {
                    continue;
                }
                if (p.arrivalTime == time) {
                    p.status = WAIT;
                } else if (p.status == WAIT && ingCount < 3) {
                    p.status = DOWN;
                    p.downCount = 1;
                    ++ingCount;
                } else if (p.status == DOWN) {
                    if (p.downCount < height) {
                        ++p.downCount;
                    } else {
                        p.status = CLEAR;
                        --ingCount;
                        ++cCount;
                    }
                }
            }

            if (cCount == size) {
                break;
            }
            ++time;
        }
        return time;
    }
}

class Person implements Comparable<Person> {
    int row, column, status, arrivalTime, downCount;
    static final int MOVE = 1, WAIT = 2, DOWN = 3, CLEAR = 4;

    public Person(int row, int column) {
        super();
        this.row = row;
        this.column = column;
    }

    void init() {
        arrivalTime = downCount = 0;
        status = MOVE;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.arrivalTime, o.arrivalTime);
    }
}