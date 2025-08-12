package Daily.D0812;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10972 {
    static int ELEMENT_COUNT;
    static int[] elementArray;
    static int head = 0;
    static int tail;
    static int swapCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ELEMENT_COUNT = Integer.parseInt(br.readLine());
        elementArray = new int[ELEMENT_COUNT];
        tail = ELEMENT_COUNT - 1;

        st = new StringTokenizer(br.readLine());
        for (int elementIndex = 0; elementIndex < ELEMENT_COUNT; elementIndex++) {
            elementArray[elementIndex] = Integer.parseInt(st.nextToken());
        }

        nextPermutation();


        if (swapCount!=0) {
            for (int elementIndex = 0; elementIndex < ELEMENT_COUNT; elementIndex++) {
                System.out.print(elementArray[elementIndex] + " ");
            }
        }
        else{
            System.out.println(-1);
        }
    }

    public static void swap(int left, int right) {
        int temp = elementArray[left];
        elementArray[left] = elementArray[right];
        elementArray[right] = temp;
        swapCount++;
    }

    public static void nextPermutation() {
        int compareIndex = tail;
        while (compareIndex > 0 && elementArray[compareIndex - 1] > elementArray[compareIndex]) {
            compareIndex--;
        }
        if (compareIndex == 0) {
            return;
        }

        int biggestCompareIndex = tail;
        while (biggestCompareIndex > compareIndex
                && elementArray[compareIndex - 1] > elementArray[biggestCompareIndex]) {
            biggestCompareIndex--;
        }

        swap(compareIndex - 1, biggestCompareIndex);

        Arrays.sort(elementArray, compareIndex, ELEMENT_COUNT);
    }
}