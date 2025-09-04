package Daily.D0819;

import java.io.*;
import java.util.*;

/*
문자	의미
.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.)
 */

/*
문자	동작
U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
 */

public class Swea1873 {
    static int HEIGHT;
    static int WIDTH;
    static char[][] map;
    static int COMMAND_LENGTH;
    static String commands;

    static char[] tank = { '^', 'v', '<', '>' };

    static int position_x;
    static int position_y;

    static String answer;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            st = new StringTokenizer(br.readLine());
            HEIGHT = Integer.parseInt(st.nextToken());
            WIDTH = Integer.parseInt(st.nextToken());

            map = new char[HEIGHT][WIDTH];
            answer = "";

            for (int heightIndex = 0; heightIndex < HEIGHT; heightIndex++) {
                String line = br.readLine();
                for (int widthIndex = 0; widthIndex < WIDTH; widthIndex++) {
                    map[heightIndex][widthIndex] = line.charAt(widthIndex);
                    char command = map[heightIndex][widthIndex];
                    if (command == tank[0] || command == tank[1] || command == tank[2] || command == tank[3]) {
                        position_x = heightIndex;
                        position_y = widthIndex;
                    }
                }
            }

            COMMAND_LENGTH = Integer.parseInt(br.readLine());
            commands = br.readLine();

            for (int commandIndex = 0; commandIndex < commands.length(); commandIndex++) {
                char command = commands.charAt(commandIndex);
                switch (command) {
                    case 'U':
                        up();
                        break;
                    case 'D':
                        down();
                        break;
                    case 'L':
                        left();
                        break;
                    case 'R':
                        right();
                        break;
                    case 'S':
                        shoot();
                        break;
                    default:
                        break;
                }
            }

            for (int heightIndex = 0; heightIndex < HEIGHT; heightIndex++) {
                for (int widthIndex = 0; widthIndex < WIDTH; widthIndex++) {
                    answer += map[heightIndex][widthIndex];
                }
                answer += '\n';
            }
            sb.append("#").append(t).append(" ").append(answer);
        }
        System.out.println(sb);
    }

    public static void shoot() {
        if (map[position_x][position_y] == tank[0]) {
            shootUp();
        }
        if (map[position_x][position_y] == tank[1]) {
            shootDown();
        }
        if (map[position_x][position_y] == tank[2]) {
            shootLeft();
        }
        if (map[position_x][position_y] == tank[3]) {
            shootRight();
        }
    }

    public static void shootUp() {
        int index_x = position_x - 1;
        while (index_x >= 0) {
            char object = map[index_x][position_y];
            if (object == '#') {
                break;
            }
            if (object == '*') {
                map[index_x][position_y] = '.';
                break;
            }
            index_x--;
        }
    }

    public static void shootDown() {
        int index_x = position_x + 1;
        while (index_x < HEIGHT) {
            char object = map[index_x][position_y];
            if (object == '#') {
                break;
            }
            if (object == '*') {
                map[index_x][position_y] = '.';
                break;
            }
            index_x++;
        }
    }

    public static void shootLeft() {
        int index_y = position_y - 1;
        while (index_y >= 0) {
            char object = map[position_x][index_y];
            if (object == '#') {
                break;
            }
            if (object == '*') {
                map[position_x][index_y] = '.';
                break;
            }
            index_y--;
        }
    }

    public static void shootRight() {
        int index_y = position_y + 1;
        while (index_y < WIDTH) {
            char object = map[position_x][index_y];
            if (object == '#') {
                break;
            }
            if (object == '*') {
                map[position_x][index_y] = '.';
                break;
            }
            index_y++;
        }
    }

    public static void up() {
        map[position_x][position_y] = tank[0];
        if (position_x > 0 && map[position_x - 1][position_y] == '.') {
            map[position_x][position_y] = '.';
            map[position_x - 1][position_y] = tank[0];
            position_x -= 1;
        }
    }

    public static void down() {
        map[position_x][position_y] = tank[1];
        if (position_x < HEIGHT-1 && map[position_x + 1][position_y] == '.') {
            map[position_x][position_y] = '.';
            map[position_x + 1][position_y] = tank[1];
            position_x += 1;
        }
    }

    public static void left() {
        map[position_x][position_y] = tank[2];
        if (position_y > 0 && map[position_x][position_y - 1] == '.') {
            map[position_x][position_y] = '.';
            map[position_x][position_y - 1] = tank[2];
            position_y -= 1;
        }
    }

    public static void right() {
        map[position_x][position_y] = tank[3];
        if (position_y < WIDTH-1 && map[position_x][position_y + 1] == '.') {
            map[position_x][position_y] = '.';
            map[position_x][position_y + 1] = tank[3];
            position_y += 1;
        }
    }
}
