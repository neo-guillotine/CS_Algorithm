package week14_2405;
import java.util.*;

public class P160586대충만든자판_240508 {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];
            HashMap<Character,Integer>map = new HashMap();
            for(String str:keymap){
                for(int i=0;i<str.length();i++){
                    char target = str.charAt(i);
                    if(map.containsKey(target)){
                        if(map.get(target)>i){
                            map.put(target,i+1);
                        }//if_map
                    }else{
                        map.put(target,i+1);
                    }
                }//for_i
            }//for_str

            //HASHMAP에 값 비교해서 넣고 더하기
            int idx=0;
            for(String str:targets){
                for(int i=0;i<str.length();i++){
                    char target = str.charAt(i);
                    if(!map.containsKey(target)){
                        answer[idx]=-1;
                        break;
                    }
                    answer[idx]+=map.get(target);
                }//for_str
                idx++;
            }//for_targets

            return answer;
        }//SOLUTION
    }//CLASS
}
