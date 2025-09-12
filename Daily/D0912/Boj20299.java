package Daily.D0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20299 {
    static int NUM_OF_TEAMS;
    static int TEAM_LIMIT;
    static int PERSONAL_LIMIT;
    static int[][] person;
    static int count;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        NUM_OF_TEAMS = Integer.parseInt(st.nextToken());
        TEAM_LIMIT = Integer.parseInt(st.nextToken());
        PERSONAL_LIMIT = Integer.parseInt(st.nextToken());

        count = 0;
        person = new int[NUM_OF_TEAMS][3];

        for (int teamIndex = 0; teamIndex < NUM_OF_TEAMS; teamIndex++) {
            st = new StringTokenizer(br.readLine());
            person[teamIndex][0] = Integer.parseInt(st.nextToken());
            person[teamIndex][1] = Integer.parseInt(st.nextToken());
            person[teamIndex][2] = Integer.parseInt(st.nextToken());

            int sum = person[teamIndex][0] + person[teamIndex][1] + person[teamIndex][2];
            int min =  Math.min(Math.min(person[teamIndex][0], person[teamIndex][1]), person[teamIndex][2]);

            if (sum >= TEAM_LIMIT && min >= PERSONAL_LIMIT) {
                count++;
                sb.append(person[teamIndex][0]).append(' ').append(person[teamIndex][1]).append(' ').append(person[teamIndex][2]).append(' ');
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }
}
