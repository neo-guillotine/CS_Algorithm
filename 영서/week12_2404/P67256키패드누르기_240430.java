package week12_2404;
import java.util.*;
public class P67256키패드누르기_240430 {
    class Solution {
        String handType;
        public String solution(int[] numbers, String hand) {
            String answer = "";
            handType = hand;
            System.out.println(handType);
            //map에 넣을 필요없이 2차원 배열에 넣었어도 가능
            HashMap<Integer,Point> map = new HashMap();
            map.put(1,new Point(0,0));
            map.put(2,new Point(0,1));
            map.put(3,new Point(0,2));
            map.put(4,new Point(1,0));
            map.put(5,new Point(1,1));
            map.put(6,new Point(1,2));
            map.put(7,new Point(2,0));
            map.put(8,new Point(2,1));
            map.put(9,new Point(2,2));
            map.put(0,new Point(3,1));

            Point L = new Point(3,0);
            Point R = new Point(3,2);

            for(int i: numbers){
                if(i==1 || i==4|| i==7){
                    //위치 이동하기
                    L = map.get(i);
                    answer+="L";
                }else if(i==3 || i==6|| i==9){
                    //위치 이동시키기
                    R = map.get(i);
                    answer+="R";
                }else{
                    //거리 계산하기
                    String move=calcDist(L,R,map.get(i));
                    if(move.equals("L")){
                        L =map.get(i);
                        answer+="L";
                    }else{
                        R = map.get(i);
                        answer+="R";
                    }
                }
            }

            return answer;
        }
        String calcDist(Point l, Point r, Point p){
            int distL = Math.abs(l.r-p.r)+Math.abs(l.c-p.c);
            int distR = Math.abs(r.r-p.r)+Math.abs(r.c-p.c);
            if(distR>distL){
                return "L";
            }else if(distL>distR){
                return "R";
            }else{
                if(handType.equals("left")){
                    return "L";
                }else{
                    return "R";
                }
            }

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
