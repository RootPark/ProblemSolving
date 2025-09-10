package Daily.D0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2458 {
    static int numberOfStudent;
    static int compareCount;
    static int[][] connection;
    static boolean[] answer;
    static int countAnswer;

    static int MAX = 100_000;

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        numberOfStudent = Integer.parseInt(st.nextToken());
        compareCount = Integer.parseInt(st.nextToken());

        connection = new int[numberOfStudent][numberOfStudent];
        answer = new boolean[numberOfStudent];
        countAnswer = 0;

        for (int index_x = 0; index_x < numberOfStudent; index_x++) {
            for (int index_y = 0; index_y < numberOfStudent; index_y++) {
                if (index_x == index_y) {
                    connection[index_x][index_y] = 0;
                } else {
                    connection[index_x][index_y] = MAX;
                }
            }
        }

        for (int index = 0; index < compareCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            connection[from][to] = Math.min(connection[from][to], 1);
        }

        for (int i = 0; i < numberOfStudent; i++) {
            for (int j = 0; j < numberOfStudent; j++) {
                for (int k = 0; k < numberOfStudent; k++) {
                    connection[j][k] = Math.min(connection[j][k], connection[j][i] + connection[i][k]);
                }
            }
        }

        for (int indexOfStudent = 0; indexOfStudent < numberOfStudent; indexOfStudent++) {
            answer[indexOfStudent] = true;
        }

        for (int indexOfStudent = 0; indexOfStudent < numberOfStudent; indexOfStudent++) {
            for (int indexOfConnection = 0; indexOfConnection < numberOfStudent; indexOfConnection++) {
                if (connection[indexOfConnection][indexOfStudent] == MAX && connection[indexOfStudent][indexOfConnection] == MAX) {
                    answer[indexOfStudent] = false;
                }
            }
        }

        
        for (int indexOfStudent = 0; indexOfStudent < numberOfStudent; indexOfStudent++) {
            if (answer[indexOfStudent]) {
                countAnswer++;
            }

        }
        System.out.println(countAnswer);
    }
}