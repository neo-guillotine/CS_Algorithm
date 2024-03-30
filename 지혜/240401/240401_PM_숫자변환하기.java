import java.util.*;

// DFS : 시간초과 + 런타임 에러로 풀이 찾아봄 ㅠ ㅠ
// y에서 거꾸로 내려가며 가능한 경우만 q에 추가하는 방법(가지치기 가능) : 2나 3으로 안나눠지면 멈추면 됨 (q에 안넣음)
class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y, 0});
        while(!q.isEmpty()) {
            int[] cnt = q.poll();
            if(x == cnt[0]) return cnt[1];
            
            if(cnt[0] - n >= x) q.offer(new int[] {cnt[0]-n, cnt[1]+1});
            if(cnt[0] % 2 == 0) q.offer(new int[] {cnt[0]/2, cnt[1]+1});
            if(cnt[0] % 3 == 0) q.offer(new int[] {cnt[0]/3, cnt[1]+1});
        }
        
        return -1;
    }
}
