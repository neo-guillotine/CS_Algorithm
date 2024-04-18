package week11_2404;
import java.util.*;
public class P118666성격유형검사하기_240419 {
    class Solution {
        public String solution(String[] survey, int[] choices) {
            String answer = "";
            HashMap<String, Integer>map = new HashMap();
            int[]score={0,3,2,1,0,1,2,3};
            int idx=0;
            map.put("R",0);
            map.put("T",0);
            map.put("C",0);
            map.put("F",0);
            map.put("J",0);
            map.put("M",0);
            map.put("A",0);
            map.put("N",0);

            for(int choice:choices){
                String target1 = Character.toString(survey[idx].charAt(0));
                String target2 = Character.toString(survey[idx].charAt(1));
                idx++;

                if(choice==4){//4번이면 아무것도 안더하기
                    continue;
                }else if(choice<4){//4보다 작으면 앞의 캐릭터 점수
                    map.put(target1,map.get(target1)+score[choice]);
                }else{//4보다 크면 뒤 캐릭터 점수
                    map.put(target2,map.get(target2)+score[choice]);
                }
            }//for
            //2개씩 비교해서 더 큰 값으로 출력. 점수가 높은 순으로 return해야함.
            //1번지표
            if(map.get("R")>=map.get("T")){
                answer+="R";
            }else{
                answer+="T";
            }
            //2번지표
            if(map.get("C")>=map.get("F")){
                answer+="C";
            }else{
                answer+="F";
            }
            //3번지표
            if(map.get("J")>=map.get("M")){
                answer+="J";
            }else{
                answer+="M";
            }
            //4번지표
            if(map.get("A")>=map.get("N")){
                answer+="A";
            }else{
                answer+="N";
            }
            return answer;
        }//solution
    }//class

}
