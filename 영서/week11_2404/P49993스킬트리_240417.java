package week11_2404;
import java.util.*;

public class P49993스킬트리_240417 {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            HashMap<String, Integer>map = new HashMap();

            for(int i=0;i<skill.length();i++){
                map.put(Character.toString(skill.charAt(i)),i);
            }

            for(String str: skill_trees){
                int idx=0;
                boolean flag=false;
                //0번부터 나왔는지 확인.
                for(int i=0;i<str.length();i++){
                    if(flag)continue;
                    String target = Character.toString(str.charAt(i));
                    if(map.containsKey(target)){
                        //지금 나와야 할 숫자가 아니면 넘어가기
                        if(map.get(target)!=idx){
                            flag=true;
                            break;
                        }
                        idx++;
                    }
                }//for_i
                if(!flag)answer++;
            }//for_str
            return answer;
        }//method_solution
    }//class
}
