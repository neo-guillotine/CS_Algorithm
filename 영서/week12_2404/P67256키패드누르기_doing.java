package week12_2404;
import java.util.*;
public class P67256키패드누르기_doing {
    class Solution {
        public String solution(int[] numbers, String hand) {
            String answer = "";
            HashMap<Integer,Point> map = new HashMap();
            for(int i: numbers){
                if(i==1 || i==4|| i==7){
                    //위치 이동하기
                    answer+="L";
                }else if(i==3 || i==6|| i==9){
                    //위치 이동시키기
                    answer+="R";
                }else{
                    //거리 계산하기

                }
            }










            return answer;
        }
        void calcDist(Point a, Point b, Point c){
           int dist =  Math.abs(a.r-b.r)+Math.abs(a.c-b.c);
        }

        class Point{
            int r;
            int c;
            Point(int r, int c){
                this.r = r;
                this.c = c;
            }
        }
    }
}
