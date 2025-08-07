package Daily.D0807;

import java.util.Arrays;

public class CombinationTest {
    static final int ELEMENT_COUNT = 3;
    static final int SELECT_COUNT = 2;

    static int[] elementArray; // 원소 배열
    static int[] selectedElementArray; // 선택해서 담을 배열
    public static void main(String[] args) {
        elementArray = new int[ELEMENT_COUNT];
        selectedElementArray = new int[SELECT_COUNT];

        for (int elementIndex = 0; elementIndex < ELEMENT_COUNT; elementIndex++) {
            elementArray[elementIndex] = elementIndex + 1;
        }
        combination(0, 0);
    }

    public static void combination(int elementIndex, int selectIndex) {
        // 1. 기저 조건 (종료 조건)
        if(selectIndex == SELECT_COUNT) {
            // 다 선택했으면 선택한 것을 출력.
            // 출력 코드 작성
            System.out.println(Arrays.toString(selectedElementArray));
            return;
        }

        if(elementIndex == ELEMENT_COUNT) {
            // 
            return;
        }

        // 2. 아직 원소를 다 안봤거나, 아직 다 선택하지 않았거나.
        
        // 선택, 복구

        selectedElementArray[selectIndex] = elementArray[elementIndex];
        combination(elementIndex+1, selectIndex+1);

        selectedElementArray[selectIndex] = 0; // 초기화
        combination(elementIndex+1, selectIndex);
    }
}
