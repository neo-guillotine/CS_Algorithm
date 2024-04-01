package week10_2404;
import java.util.*;
import java.util.stream.*;

public class P150370개인정보수집유효기간_240401 {

    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            int[] answer = {};
            ArrayList<Integer>answerL= new ArrayList();
            int idx=1;
            //1~n번. 약관 종류는 A~Z, 약관마다 유효기간. 모든 달은 28일까지.
            int[] todayList = Stream.of(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
            HashMap<String,Integer>map = new HashMap();
            for(String str:terms){
                String[]tmp = str.split(" ");
                map.put(tmp[0],Integer.parseInt(tmp[1]));
            }//for terms

            for(String str:privacies){
                String[]tmp = str.split(" ");
                int[]lawDate = Arrays.stream(tmp[0].split("\\.")).mapToInt(Integer::parseInt).toArray();
                // System.out.println("lawDate1"+Arrays.toString(lawDate));
                int dueDate = map.get(tmp[1]);
                lawDate[1]+=dueDate;
                lawDate[2]--;

                if(lawDate[2]==0){
                    lawDate[1]--;
                    lawDate[2]=28;
                }else if(lawDate[2]>28){
                    lawDate[1]++;
                    lawDate[2]-=28;
                }

                if(lawDate[1]>12){
                    lawDate[0]+=lawDate[1]/12;
                    lawDate[1]%=12;
                    if(lawDate[1]==0){
                        lawDate[1]=12;
                        lawDate[0]--;
                    }
                }

                // System.out.println("lawDate2"+Arrays.toString(lawDate));
                //today vs lawdate
                if(todayList[0]>lawDate[0]){ //1.년비교
                    answerL.add(idx);
                }else if(todayList[0]==lawDate[0]){ //2.월비교
                    if(todayList[1]>lawDate[1]){
                        answerL.add(idx);
                    }else if(todayList[1]==lawDate[1] && todayList[2]>lawDate[2]){
                        answerL.add(idx);
                    }
                }
                idx++;
            }//for privacies

            idx=0;
            answer = new int[answerL.size()];
            for(int i:answerL){
                answer[idx++]=i;
            }
            return answer;
        }
    }
}
