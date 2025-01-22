package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main6 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
    StringBuilder stringBuilder = new StringBuilder();
    // key = 나무, value = 개체수

    String str = bufferedReader.readLine();

    int sum = 0;
    
    while (true) {
      if (treeMap.containsKey(str)) {
        int num = treeMap.get(str) + 1;
        treeMap.put(str, num);
        sum++;
      } else {
        treeMap.put(str, 1);
        sum++;
      }
      str = bufferedReader.readLine();
			if(str == null || str.length() == 0) {
				break;
			}
    }

    for(Map.Entry<String, Integer> entry : treeMap.entrySet()) {
      String key = entry.getKey();
      int count = entry.getValue();
      double ratio = count / (double)sum * 100;
      stringBuilder.append(String.format("%s %.4f\n", key, ratio));
    }


    System.out.println(stringBuilder);
  }
}
