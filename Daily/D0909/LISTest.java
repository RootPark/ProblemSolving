package Daily.D0909;

import java.util.Arrays;
import java.util.Scanner;

public class LISTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();

        int[] arr= new int[N];
        int[] LIS = new int[N]; // 각 요소마다 자신을 끝으로 하는 증가수열의 최대길이

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            LIS[i] = 1; // 자신 혼자 증가수열의 끝에 있다고 생각했을때 길이 값 1로 초기화
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
            }
            max = Math.max(max, LIS[i]);
        }

        System.out.println(Arrays.toString(LIS));
        System.out.println(max);
    }
}
