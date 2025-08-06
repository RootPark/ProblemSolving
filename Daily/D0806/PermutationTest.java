package Daily.D0806;

import java.util.Arrays;

// 1,2,3 중에 중복되지 않게 뽑아서 순서대로 나열
// nPr

public class PermutationTest {

    static int N = 3, R = 2;
    static int[] numbers; // 맨 앞에서부터 차례대로 뽑힌 수들 저장(0: 첫번째 자리, 1: 두번째 자리, ...)
    static boolean[] isSelected; // 각 수들이 뽑혔는지 상태 플래그 저장(1: 숫자 1 선택여부, 2: 숫자 2 선택여부,...)

    public static void main(String[] args) {
        numbers = new int[R];
        isSelected = new boolean[N + 1];

        permutation(0);
    }

    public static void permutation(int cnt) { // 해당 자리에 들어갈 수 순열로 뽑기 // cnt: 이전까지 뽑은 수 들의 개수
        
        if(cnt==R){
            System.out.println(Arrays.toString(numbers));
            return;
        }
        // 가능한 모든 수를 해당 자리에 시도
        for (int i = 1; i <= N; i++) {
            // 이미 선택된 수는 중복이니까 패스
            if(isSelected[i]) {
                continue;
            }
            numbers[cnt] = i; // 해당 자리에 수 저장
            isSelected[i] = true; // 수의 선택여부를 체크 해둠
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }
}
