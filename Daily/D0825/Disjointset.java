package Daily.D0825;

import java.util.Arrays;
import java.util.Scanner;

public class Disjointset {
    static int N;
    static int[] parents;

    private static void make() {
        for (int i = 0; i < N; i++) {
            parents[i] = i; // make set : 자신을 자신의 부모로 초기화(자신이 곧 루트, 대표자가 됨)
        }
    }

    private static int find(int a) { // a가 속한 집합(집합의 대표자) 찾기
        if (parents[a] == a) {
            return a;
        }
        // return find(parents[a]); // 패스 압축 전
        return parents[a] = find(parents[a]); // 패스 압축 후
    }

    private static boolean union(int a, int b) { // a, b 가 속한 집합을 합치기
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) { // 이미 같은 집합이므로 합치기 불가!
            return false;
        }

        parents[bRoot] = aRoot;
        return true; // 합치기 성공!!
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = 5;
        parents = new int[N];

        make();
        System.out.println(Arrays.toString(parents));
        System.out.println(union(0, 1));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(2, 1));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(3, 2));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(4, 3));
        System.out.println(Arrays.toString(parents));

        System.out.println("===find===");
        System.out.println(find(0));
        System.out.println(find(1));
        System.out.println(find(2));
        System.out.println(find(3));
        System.out.println(find(4));

        System.out.println("===union fail===");
        System.out.println(union(2, 3));
    }
}
