package Daily.D0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea1225 {
    static Queue<Integer> passwordQueue;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            passwordQueue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                passwordQueue.offer(Integer.parseInt(st.nextToken()));
            }
            makePassword();
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < 8; i++) {
                sb.append(passwordQueue.poll()).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void makePassword() {
        int decrease = 1;
        while (true) {
            int num = passwordQueue.poll() - decrease;
            if (num <= 0) {
                passwordQueue.offer(0);
                break;
            } else {
                passwordQueue.offer(num);
            }
            decrease = (decrease % 5) + 1;
        }
    }
}
