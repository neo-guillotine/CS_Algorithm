package week10_2404;
import java.util.*;
import java.util.stream.*;

public class P12939최댓값과최솟값_240402 {
    class Solution {
        public String solution(String s) {
//        String answer = "";
            StringBuffer answer = new StringBuffer();
            int[]list = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(Arrays.toString(list));
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            for(int i:list){
                max=Math.max(max,i);
                min=Math.min(min,i);
            }
            answer.append(min).append(" ").append(max);
            return answer.toString();
        }
    }
}
