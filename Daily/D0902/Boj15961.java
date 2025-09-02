package Daily.D0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15961 {
    static int NUMBER_OF_SUSHI;
    static int TYPE;
    static int NUMBER_OF_EAT;
    static int NUMBER_OF_COUPON;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        NUMBER_OF_SUSHI = Integer.parseInt(st.nextToken());
        TYPE = Integer.parseInt(st.nextToken());
        NUMBER_OF_EAT = Integer.parseInt(st.nextToken());
        NUMBER_OF_COUPON = Integer.parseInt(st.nextToken());

        int[] sushi = new int[NUMBER_OF_SUSHI + NUMBER_OF_EAT];
        int[] sushiCount = new int[TYPE + 1];

        for (int index = 0; index < NUMBER_OF_SUSHI; index++) {
            sushi[index] = (Integer.parseInt(br.readLine()));
        }

        int count = 1;
        sushiCount[NUMBER_OF_COUPON]++;
        for (int index = 0; index < NUMBER_OF_EAT; index++) {
            if (sushiCount[sushi[index]] == 0) {
                count++;
            }
            sushiCount[sushi[index]]++;
        }

        int max = count;
        for (int index = 1; index < NUMBER_OF_SUSHI; index++) {
            sushiCount[sushi[index - 1]]--;
            if (sushiCount[sushi[index - 1]] == 0) {
                count--;
            }
            if (sushiCount[sushi[(index + NUMBER_OF_EAT - 1) % NUMBER_OF_SUSHI]] == 0) {
                count++;
            }
            sushiCount[sushi[(index + NUMBER_OF_EAT - 1) % NUMBER_OF_SUSHI]]++;

            max = Math.max(count, max);
        }

        System.out.println(max);
    }
}
