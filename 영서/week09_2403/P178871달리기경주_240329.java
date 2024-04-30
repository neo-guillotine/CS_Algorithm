package week09_2403;

import java.util.*;

public class P178871달리기경주_240329 {
    class Solution {
        public String[] solution(String[] players, String[] callings) {
            String[] answer = new String[players.length];
            HashMap<String, Integer>map = new HashMap();
            String tmp="";
            int num=0;
            int idx=0;
            for(int i=0;i<players.length;i++){
                map.put(players[i],i);
            }

            for(String str:callings){
                num = map.get(str);
                //리스트에서 바꾸기
                tmp = players[num-1];
                players[num-1]=str;
                players[num]=tmp;

                map.put(str,num-1);
                map.put(tmp,num);
            }

            return players;
        }
    }
}
