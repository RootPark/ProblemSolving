package Daily.D0812;

import java.util.Arrays;

public class NextPermutation {

    // 넥퍼 찾는 순서
    // 1. 꼭대기(큰 수)를 찾기
    // 2. 내림차순을 깬 놈을 찾기
    // 3. 그것보다 살짝 더 큰 놈 찾기
    // 4. swap
    // 5. 뒷부분을 오름차순으로 바꾸기
    static final int ELEMENT_COUNT = 4;
    static int[] elementArray;

    public static void swap(int leftIndex, int rightIndex) {
        int temp = elementArray[leftIndex];
        elementArray[leftIndex] = elementArray[rightIndex];
        elementArray[rightIndex] = temp;
    }

    public static boolean hasNext() {
        int head = 0;
        int tail = ELEMENT_COUNT - 1;
        
        // 1. 꼭대기를 찾는다.
        int highestElementIndex = tail;
        while(highestElementIndex > 0 && elementArray[highestElementIndex -1] >= elementArray[highestElementIndex]) {
            highestElementIndex--;
        }

        // 2. 꼭대기가 맨 앞이라면 더 이상 만들 수 있는 순열이 없어요.
        if(highestElementIndex == head) {
            return false;
        }
        
        // 3. 내림차순이 깨지는 위치의 값보다 살짝 더 큰 값의 위치를 찾는다.
        int brokenDescendingElementIndex = highestElementIndex - 1;
        int nextLargerThanBrokenElementIndex = tail;

        while(elementArray[brokenDescendingElementIndex] >= elementArray[nextLargerThanBrokenElementIndex]) {
            nextLargerThanBrokenElementIndex--;
        }

        // 배열을 출력 해보세요~(확인용)
        // System.out.println("[Before Swap]");
        // System.out.println(Arrays.toString(elementArray));
        // 4. swap
        swap(brokenDescendingElementIndex, nextLargerThanBrokenElementIndex);
        
        // 배열을 출력 해보세요~(확인용)
        // System.out.println("[After Swap]");
        // System.out.println(Arrays.toString(elementArray));

        // 5. 사전순으로 정렬 (뒷 부분의 내림차순을 오름차순으로 변경)
        int fairIndex = tail;
        while(highestElementIndex < fairIndex) {
            swap(highestElementIndex, fairIndex);
            highestElementIndex++;
            fairIndex--;
        }

        return true;
    }

    public static void nextPermutation() {
        do {
            System.out.println(Arrays.toString(elementArray));
        }while(hasNext()); // 다음 순열을 찾을 수 있음?
    }
    public static void main(String[] args) {

        elementArray = new int[ELEMENT_COUNT];

        for (int elementIndex = 0; elementIndex < ELEMENT_COUNT; elementIndex++) {
            elementArray[elementIndex] = elementIndex + 1;
        }

        nextPermutation();
    }
}
