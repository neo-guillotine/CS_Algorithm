import java.util.*;
// 구현
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int maxHealth = health;
        int successCnt = 0;
        boolean isAttack;
        // 최대 시간 : 마지막 공격 초
        for(int i = 1; i <= attacks[attacks.length-1][0]; i++) {
            isAttack = false;
            // 공격 당한거 먼저 계산
            for(int a = 0; a < attacks.length; a++) {
                // 어택 시간 오름차순 정렬돼있기에 더 높은 수 나오면 빠져나옴
                if(attacks[a][0] > i) break;
                else if(attacks[a][0] == i) {  // 어택으로 인한 체력 감소 계산
                    health -= attacks[a][1];
                    successCnt = 0;
                    isAttack = true;
                    break;
                }
            }
            if(health <= 0) {   // 체력이 0 이하면 -1 return
                answer = -1;
                break;
            }
            
            // 공격받지 않았을 경우 회복량 계산
            if(!isAttack) {
                // max 체력인 경우, 연속 성공만 카운트하고 다음으로 넘어감
                successCnt++;
                if(health != maxHealth) {   // 체력 회복 가능한 경우
                    health += bandage[1];
                    if(health >= maxHealth) health = maxHealth;
                }
                // 연속 성공으로 인한 추가 회복량 계산
                if(successCnt == bandage[0]) {
                    health += bandage[2];
                    if(health >= maxHealth) health = maxHealth;
                    successCnt = 0; // 연속 성공 초기화
                }
            }
          
            // 마지막 턴
            if(i == attacks[attacks.length-1][0]) answer = health;
        }
        return answer;
    }
}
