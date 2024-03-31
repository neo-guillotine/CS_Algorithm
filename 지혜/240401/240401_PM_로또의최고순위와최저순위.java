import java.util.*;

// 최저 : 일치 개수, 최대 : 최저 + 0의 개수
class Solution {
    public static int l = 0;    // 람다때문에 여기다 선언
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int minCnt = 0;
        int zeroCnt = 0;
        for(l = 0; l < lottos.length; l++) {
            if(lottos[l] == 0) zeroCnt++;
            else {
                boolean isExist = Arrays.stream(win_nums).anyMatch(i->i==lottos[l]);
                if(isExist) minCnt++;
            }
        }
        
        answer[0] = rank[minCnt+zeroCnt];
        answer[1] = rank[minCnt];
        
        return answer;
    }
}
