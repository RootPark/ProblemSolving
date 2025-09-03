package Daily.D0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11727 {
    static int NUMBER;
    static long[] memory;
    static int DEVIDER = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NUMBER = Integer.parseInt(br.readLine());
        memory = new long[NUMBER+1];
        memory[0] = 1;
        memory[1] = 3;
        System.out.println(recursive(NUMBER-1));
    }

    public static long recursive(int num) {
        if (memory[num] != 0) {
            return memory[num];
        }
        return memory[num] = (recursive(num - 1) + recursive(num - 2) * 2) % DEVIDER;
    }
}