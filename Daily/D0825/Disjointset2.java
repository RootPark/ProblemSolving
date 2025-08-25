package Daily.D0825;

public class Disjointset2 { // Union-Find Set
    // 부모
    // 랭크
    // 경로압축 - 트리가 한쪽으로 쏠리면 사실상 리스트처럼 되는데, 이걸 막기 위함임
    // make() -> 초기화, union() -> 짱을 찾아서 하나로 만드는 거, find() -> 짱을 찾는거.
    public static final int ELEMENT_COUNT = 5;
    public static int[] parentArray;
    public static int[] rankArray;
    public static void make() {
        parentArray = new int[ELEMENT_COUNT + 1]; // +1 => 0번을 안쓰고 1부터 시작하려구 더함
        rankArray = new int[ELEMENT_COUNT + 1];

        // 나 자신을 부모로 표시.
        for(int index = 0; index < ELEMENT_COUNT + 1; index++) {
            parentArray[index] = index;
            rankArray[index] = 0; // 배열 타입이 int -> 애초에 초기값 : 0 
        }
    }
    // 부모를 찾아오는 메서드
    public static int find(int element) {
        // 내가 부모면 더 이상 찾을 필요가 없다.
        if (parentArray[element] == element) {
            return element;
        }

        // 어라? 내가 부모가 안됐네?
        // 부모 찾으로 이동.
        return parentArray[element] = find(parentArray[element]);
    }

    // 두 노드를 하나의 집합으로 묶는다.
    public static void union(int element1, int element2) {
        // 각각의 부모를 찾아온다.
        int e1Parent = find(element1);
        int e2Parent = find(element2);

        // 부모가 동일하면 이미 동일한 그룹에 속해있다. 그래서 합칠 수 없다.
        if(e1Parent == e2Parent) {
            return;
        }

        // 부모가 동일하지 않다는 이야기는 => 서로 다른 집합.
        // 서로 다른 집합 => 어느 한 쪽으로는 기어들어가야한다.

        // 랭크를 판단한다.
        // e1의 랭크가 더 크면 e2가 기어들어간다.
        if(rankArray[e1Parent] > rankArray[e2Parent]) {
            parentArray[e2Parent] = e1Parent; // 서로 바꿔서 쓰지 않도록 주의할 것.
            return;
        }

        // e2의 랭크가 더 크거나, 같은 경우.
        parentArray[e1Parent] = e2Parent;

        // 만약 랭크가 동일하다면, e2를 부모로 선정했으니, e2 랭크를 증가시킨다.
        if(rankArray[e1Parent] == rankArray[e2Parent]) {
            rankArray[e2Parent]++;
        }
    }
    public static void main(String[] args) {
        
    }
}
