package Daily.D0808;

import java.util.Scanner;

public class SubsetTest {
    static int N;
    static int[] input;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        isSelected = new boolean[N];
        for(int i=0;i<N;i++){
            input[i] = sc.nextInt();
        }
        generateSubset(0, 0);
    }


    // cnt : 다룬 원소개수, setCnt : 부분집합을 구성하고 있는 원소 개수
    private static void generateSubset(int cnt, int setCnt) { // 해당 원소를 부분집합의 구성으로 포함/비포함 처리
        //기본파트(기저)
        if(cnt==N) { // 마지막 원소까지 모두 고려헀다면
            System.out.print("부분집합의 원소 개수 : "+setCnt+" ==> ");
            for(int i=0;i<N;i++) { // 부분집합의 구성요소만 뽑기
                System.out.print((isSelected[i]?input[i]:"X")+" ");
            }
            System.out.println();
            return;
        }

        //유도파티
        //해당 원소 부분집합에 넣기

        isSelected[cnt] = true;
        generateSubset(cnt+1, setCnt+1);

        isSelected[cnt] = false;
        generateSubset(cnt+1, setCnt);
        
    }
}