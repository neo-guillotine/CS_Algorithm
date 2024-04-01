package week10_2404;
import java.util.*;

public class P161990바탕화면정리_240401 {
    class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = new int[4];
            //#의 X값과 Y값의 최소 최대 값을 각각 구하고, 최소,최소~최대,최대로 구하기
            int lux=Integer.MAX_VALUE;
            int rdx=Integer.MIN_VALUE;
            int luy=Integer.MAX_VALUE;
            int rdy=Integer.MIN_VALUE;
            int idx=0;

            for(String str:wallpaper){
                char[]list = str.toCharArray();
                for(int i=0;i<list.length;i++){
                    if(list[i]=='#'){
                        //S
                        lux=Math.min(idx,lux);
                        luy=Math.min(i,luy);

                        //E
                        rdx=Math.max(idx,rdx);
                        rdy=Math.max(i,rdy);
                    }
                }
                idx++;
            }

            answer[0]=lux;
            answer[1]=luy;
            answer[2]=rdx+1;
            answer[3]=rdy+1;

            return answer;
        }
    }
}
