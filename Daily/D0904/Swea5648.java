package Daily.D0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea5648 {
    static int MAX_NUM = 4001;
    static int NUM_OF_ATOMS;
    static int[][] visited;
    static Node[] atoms;
    static int[] delta_x = { 1, -1, 0, 0 };
    static int[] delta_y = { 0, 0, -1, 1 };

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            NUM_OF_ATOMS = Integer.parseInt(br.readLine());
            atoms = new Node[NUM_OF_ATOMS];

            for (int indexOfAtom = 0; indexOfAtom < NUM_OF_ATOMS; indexOfAtom++) {
                st = new StringTokenizer(br.readLine());
                int coordinate_x = Integer.parseInt(st.nextToken());
                int coordinate_y = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());
                int energy = Integer.parseInt(st.nextToken());

                atoms[indexOfAtom] = new Node((coordinate_x + 1000) * 2, (coordinate_y + 1000) * 2, direction, energy);
                visited[atoms[indexOfAtom].coordinate_x][atoms[indexOfAtom].coordinate_y]++;
            }

            sb.append("#").append(t).append(" ").append("\n");
        }
        System.out.println(sb);
    }

    public static int findCollapse() {
        int answer = 0;
        int numOfAtoms = NUM_OF_ATOMS;

        
    }

}

class Node {
    int coordinate_x;
    int coordinate_y;
    int direction;
    int energy;

    public Node(int coordinate_x, int coordinate_y, int direction, int energy) {
        super();
        this.coordinate_x = coordinate_x;
        this.coordinate_y = coordinate_y;
        this.direction = direction;
        this.energy = energy;
    }
}
