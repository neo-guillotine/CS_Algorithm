// 풀다가 풀이 보고 품 ㅠ _ ㅠ . .
import java.util.*;

// 최소값 구하기 -> 완탐
class Solution {
    static int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        for(int p = 0; p < 3; p++) {
            // 곡괭이 있으면 시작 ~~
            if(picks[p] != 0) {
                int[] clonePicks = picks.clone();
                clonePicks[p] = clonePicks[p] - 1;  // 하나 사용하고 들어감
                dfs(clonePicks, minerals, p, 0, 0);
            }
        }
        
        return answer;
    }
    
    public void dfs(int[] picks, String[] minerals, int pick, int mIdx ,int sum) {
        
        int i = 0;
        for(i = 0; i < 5; i++) {    // 5개씩 광물캐기
            if(mIdx+i >= minerals.length) { // 캘 광물 없는 경우
                break;
            }
            switch(pick) {
                case 0 :    // dia
                    sum += 1;
                    break;
                case 1 :    // iron
                    if("diamond".equals(minerals[mIdx+i]))
                        sum += 5;
                    else
                        sum += 1;
                    break;
                case 2 :    // stone
                    if("diamond".equals(minerals[mIdx+i]))
                        sum += 25;
                    else if("iron".equals(minerals[mIdx+i]))
                        sum += 5;
                    else
                        sum += 1;
                    break;
            }
        }
        // 5개 광물캐기 시작할 인덱스 재설정
        mIdx = mIdx + i;
        // sum이 현재 최소값보다 크면 바로 종료
        if(sum >= answer) return;
        // 캘 광물 없는 경우, 곡괭이 다 쓴 경우 -> 최소값 비교
        if((mIdx >= minerals.length) || 
          (picks[0] == 0 && picks[1] == 0 && picks[2] == 0)) {
            answer = Math.min(sum, answer);
            return;
        }
        
        // 캘 광물이 남아있거나 곡괭이가 남아있으면 한번 더 들어간다
        for(int p = 0; p < 3; p++) {
            if(picks[p] != 0) {
                int[] clonePicks = picks.clone();
                clonePicks[p] = clonePicks[p] - 1;  // 하나 사용하고 들어감
                dfs(clonePicks, minerals, p, mIdx, sum);
            }
        }
    }
}
