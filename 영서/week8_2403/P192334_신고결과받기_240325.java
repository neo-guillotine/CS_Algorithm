package week8_2403;

import java.util.*;
import java.io.*;

public class P192334_신고결과받기_240325 {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int num = id_list.length;
            int[] answer = new int[num];
            boolean[][]check = new boolean[num][num];
            HashMap<String,Integer>map = new HashMap();
            ArrayList<HashSet<String>>setList=new ArrayList<>();

            for (int i = 0; i < num; i++) {
                setList.add(new HashSet());
                map.put(id_list[i],i);
            }

            for(int i=0;i<report.length;i++){
                String from = report[i].split(" ")[0];
                String to = report[i].split(" ")[1];
                setList.get(map.get(to)).add(from);
            }//for

            for(int i=0;i<num;i++){
                if(setList.get(i).size()>=k){
                    for(String str: setList.get(i)){
                        answer[map.get(str)]++;
                    }
                }//if
            }//for

            return answer;
        }
    }
}
