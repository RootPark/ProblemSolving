package Daily.D0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(devide(N, 0));
    }

    public static int devide(int num, int count) {
        if (num < 2) {
            return count;
        }

        return Math.min(devide(num / 2, count + 1 + (num % 2)), devide(num / 3, count + 1 + (num % 3)));
    }
}
