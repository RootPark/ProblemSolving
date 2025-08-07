package Daily.D0806;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest { // 주사위 던지기 1,2,3,4
    static int N, numbers[], totalCnt;
    static boolean[] isSelected;
    public static void main(String[] args) {
        // 입력으로 주사위던진 횟수와 던지기 모드 받기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 던진 횟수
        int M = sc.nextInt(); // 던지기 모드

        numbers = new int[N];

        switch(M) {
            case 1: // 중복 순열
                dice1(0);
                break;
            case 2: // 순열
                isSelected = new boolean[7];
                dice2(0);
                break;
            default:
                System.out.println("던지기 모드값이 잘못되었습니다. (1~4 모드값 입력 필요!)");
                break;
        }
    }

        public static void dice1(int cnt) { // cnt : 기존까지 던진 주사위 횟수
        // 기저파트
        if (cnt == N) { // 다 던졌다면 ...
            ++totalCnt;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        // 해당 자리에 가능한 주사위 눈을 모두 시도 : 유도파트
        for (int i=1;i<=6;i++){

            // 아니라면 주사위눈 선택
            numbers[cnt] = i;
            //다음 주사위 던지러 가기
            dice1(cnt+1);
        }
    }

    public static void dice2(int cnt) { // cnt : 기존까지 던진 주사위 횟수
        // 기저파트
        if (cnt == N) { // 다 던졌다면 ...
            ++totalCnt;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        // 해당 자리에 가능한 주사위 눈을 모두 시도 : 유도파트
        for (int i=1;i<=6;i++){
            // 앞에서 나온 주사위 눈인지 체크
            if(isSelected[i]) {
                continue;
            }
            // 아니라면 주사위눈 선택
            numbers[cnt] = i;
            isSelected[i] = true;
            //다음 주사위 던지러 가기
            dice2(cnt+1);
            // 주사위눈 바꿔서 처리하기 위해 선택을 되돌림!
            isSelected[i] = false;
        }
    }
}
