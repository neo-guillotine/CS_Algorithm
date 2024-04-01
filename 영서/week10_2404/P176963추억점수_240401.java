package week10_2404;
import java.util.*;

public class P176963추억점수_240401 {

    class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            int[] answer = new int[photo.length];
            int idx=0;
            HashMap<String,Integer>score = new HashMap();
            for(int i=0;i<name.length;i++){
                score.put(name[i],yearning[i]);
            }

            for(int i=0;i<photo.length;i++){
                int tmp=0;
                for(int j=0;j<photo[i].length;j++){
                    String target= photo[i][j];
                    if(score.containsKey(target)){
                        tmp+=score.get(target);
                    }
                }
                answer[i]=tmp;
            }

            return answer;
        }
    }
}
