package Daily.D0807;

import java.io.*;
import java.util.StringTokenizer;

public class Main1 {

    static int[] input, numbers;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N + 1];
        numbers = new int[M];

        for (int i = 1; i <= N; i++) {
            input[i] = i;
        }

        combination(0, input[1]);
    }

    public static void combination(int count, int start) {
        if (count == M) {
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = start; i <= N; i++) {
                numbers[count] = input[i];
                combination(count + 1, i + 1);
            }
        }
    }
}
