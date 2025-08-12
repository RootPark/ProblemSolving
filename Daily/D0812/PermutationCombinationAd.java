package Daily.D0812;

import java.util.*;

public class PermutationCombinationAd {
    static int N, R;
    static int[] input;
    static int[] numbers; // 맨 앞에서부터 차례대로 뽑힌 수들 저장(0: 첫번째 자리, 1: 두번째 자리, ...)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();

        input = new int[N];
        numbers = new int[R];

        for (int i=0;i<N;i++){
            input[i] = sc.nextInt();
        }
        permutation(0, 0);
    }

    public static void permutation(int cnt, int flag) { // 해당 자리에 들어갈 수 순열로 뽑기 // cnt: 이전까지 뽑은 수 들의 개수

        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        // 가능한 모든 수를 해당 자리에 시도
        for (int i = 0; i < N; i++) {
            // 이미 선택된 수는 중복이니까 패스
            if ((flag & 1<<i) !=0) {
                continue;
            }
            numbers[cnt] = input[i]; // 해당 자리에 수 저장
            permutation(cnt + 1, flag | 1<<i);
        }
    }
}
