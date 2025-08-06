package Daily.D0806;

// 순열 : 순서가 의미가 있다.

public class PermutationTest2 {
    static final int ELEMENT_COUNT = 3;
    static final int SELECT_COUNT = 2;

    static int[] elementArray; // 원소 배열
    static int[] selectedElementArray; // 선택해서 담을 배열
    static boolean[] isSelected; // 특정 원소를 선택했는지 확인하는 배열

    public static void main(String[] args) {
        elementArray = new int[ELEMENT_COUNT];
        selectedElementArray = new int[SELECT_COUNT];
        isSelected = new boolean[ELEMENT_COUNT];

        for (int elementIndex = 0; elementIndex < ELEMENT_COUNT; elementIndex++) {
            elementArray[elementIndex] = elementIndex + 1;
        }

        permutation(0);
    }

    // 재귀 함수 구현
    // * 기저 조건 --> 없다면? --> stackOverFlow
    public static void permutation(int selectIndex) {
        // 기저 조건 (종료 조건)
        // 재귀를 해야겠다 싶으면 기저 조건을 무조건 위에 써야 함
        // 내가 모두 다 선택 했다면 종료
        if (selectIndex == SELECT_COUNT) {

            for (int index = 0; index < SELECT_COUNT; index++) {
                System.out.print(selectedElementArray[index] + " ");
            }
            System.out.println();
            return;
        }

        // 아직 선택할 것이 남아있다면,
        for (int elementIndex = 0; elementIndex < ELEMENT_COUNT; elementIndex++) {
            // 해당 위치의 원소를 확인했더니, 이미 사용했으면 제외.
            if (isSelected[elementIndex]) {
                continue; // 이미 사용했으면 다음 놈을 봐야해요.
            }

            // 아직 선택하지 않았다.
            isSelected[elementIndex] = true;
            selectedElementArray[selectIndex] = elementArray[elementIndex];
            permutation(selectIndex + 1);

            // 다시 되돌려준다.
            isSelected[elementIndex] = false;
        }
    }
}
