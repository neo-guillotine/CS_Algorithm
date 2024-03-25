package week8_2403;
import java.util.*;

public class P250137_붕대감기_240311 {
    class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int answer = health;
            int time=0;
            int continuous=0;
            //몬스터의 마지막 공격까지 진행
            int lastAttack=attacks[attacks.length-1][0];
            boolean[]check = new boolean[lastAttack+1];
            HashMap<Integer,Integer>map = new HashMap();

            for(int i=0;i<attacks.length;i++){
                check[attacks[i][0]]=true;
                map.put(attacks[i][0],attacks[i][1]);
            }

            while(true){
                if(answer>health){//최대 체력보다 커질 수는 없다.
                    answer=health;
                }
                time++;
                //체력이 0보다 작아지면 끝내기
                if(answer<=0){
                    break;
                }
                //몬스터 공격시간일 때
                if(check[time]){
                    //연속 치료 초기화
                    continuous=0;
                    answer-=map.get(time);
                    if(time==lastAttack){
                        break;
                    }
                }else{
                    continuous++;
                    //최대 체력인지 확인
                    if(answer>=health){
                        continue;
                    }else{
                        answer+=bandage[1];
                        //시전시간을 채우면 추가 회복량 더해주고, 초기화
                        if(continuous==bandage[0]){
                            answer+=bandage[2];
                            continuous=0;
                        }
                    }
                }
            }//while
            if(answer<=0){answer=-1;}

            return answer;
        }
    }
}
