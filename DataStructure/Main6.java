package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main6 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    Map<String, Integer> map = new HashMap<>();

    String input = bufferedReader.readLine();
    int count = 0;
    while(true){
      if(map.containsKey(input)){
        int numOfWood = map.get(input);
        map.replace(input, numOfWood+1);
        count++;
      }
      else{
        map.put(input, 1);
        count++;
      }
      input = bufferedReader.readLine();
      if(input.length() == 0 || input == null){
        break;
      }
    }

    List<String> keySet = new ArrayList<>(map.keySet());
    Collections.sort(keySet);

    for(String key : keySet){
      stringBuilder.append(key).append(" ");
      double percent =(double)map.get(key) / (double)count * 100;
      stringBuilder.append(String.format("%.4f\n",percent));
    }

    System.out.println(stringBuilder);

  }
}
