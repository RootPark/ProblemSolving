package Daily.D0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Swea5658 {
    static int LENGTH;
    static int ROTATION;
    static int SINGLE_LENGTH;
    static int INDEX;
    static String fullNumber;
    static Set<String> numbers;
    static Integer[] numbersArr;
    static int answer;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            st = new StringTokenizer(br.readLine());
            LENGTH = Integer.parseInt(st.nextToken());
            INDEX = Integer.parseInt(st.nextToken()) - 1;

            SINGLE_LENGTH = LENGTH / 4;
            ROTATION = SINGLE_LENGTH - 1;
            answer = 0;
            numbers = new HashSet<>();
            fullNumber = br.readLine();

            findHexNumber();
            changeHexToInt();

            Arrays.sort(numbersArr, Collections.reverseOrder());
            answer = numbersArr[INDEX];

            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }

        System.out.println(sb);
    }

    public static void findHexNumber() {
        for (int rotationIndex = 0; rotationIndex <= ROTATION; rotationIndex++) {
            for (int stringIndex = 0; stringIndex <= fullNumber.length() - SINGLE_LENGTH; stringIndex++) {
                numbers.add(fullNumber.substring(stringIndex, stringIndex + SINGLE_LENGTH));
            }
            fullNumber = fullNumber.substring(fullNumber.length() - 1)
                    + fullNumber.substring(0, fullNumber.length() - 1);
        }
    }

    public static void changeHexToInt() {
        numbersArr = new Integer[numbers.size()];

        int indexOfArr = 0;
        for (String number : numbers) {
            numbersArr[indexOfArr] = Integer.parseInt(number, 16);
            indexOfArr++;
        }
    }
}
