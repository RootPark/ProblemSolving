package Daily.D0806;

import java.io.*;
import java.util.*;

public class Swea6808 {
  static int CARDS_NUM = 9;
  static int[] cards;
  static int[] enemyCards;
  static int winnderCount;
  static int loserCount;
  static boolean[] isSelected;
  static int[] selectedCards;
  static boolean[] cardsChecked;
  static int totalCount;

  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());

    for (int t = 1; t <= testCase; t++) {
      st = new StringTokenizer(br.readLine());
      cards = new int[CARDS_NUM];
      enemyCards = new int[CARDS_NUM];

      selectedCards = new int[CARDS_NUM];

      cardsChecked = new boolean[CARDS_NUM*2+1];
      isSelected = new boolean[CARDS_NUM+1];

      for (int index = 0; index < CARDS_NUM; index++) {
        int card = Integer.parseInt(st.nextToken());
        cards[index] = card;
        cardsChecked[card] = true;
      }

      winnderCount = 0;
      loserCount = 0;

      int cardIndex = 0;
      for(int index=1; index<=CARDS_NUM*2;index++){
        if(cardsChecked[index]) {
          continue;
        }
        enemyCards[cardIndex] = index;
        cardIndex++;
      }

      permutation(0);
      sb.append("#").append(t).append(" ").append(winnderCount).append(" ").append(loserCount).append("\n");
    }
    System.out.println(sb);
  }

  public static void permutation(int count) {
    if (count == CARDS_NUM) {
      totalCount++;
      int userCount = 0;
      int enemyCount = 0;

      for(int i=0;i<CARDS_NUM;i++){
        if(cards[i] > selectedCards[i]) {
          userCount += cards[i] + selectedCards[i];
        }
        else if(cards[i] < selectedCards[i]) {
          enemyCount += cards[i] + selectedCards[i];
        }
      }
      if(userCount > enemyCount) {
        winnderCount++;
      }
      else if (userCount < enemyCount){
        loserCount++;
      }
      return;
    }

    for (int i=0;i<CARDS_NUM;i++){
      if(isSelected[i]) {
        continue;
      }
      selectedCards[count] = enemyCards[i];
      isSelected[i] = true;

      permutation(count+1);
      isSelected[i] = false;
    }
  }
}
