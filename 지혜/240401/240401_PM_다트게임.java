import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int idx = -1;
        int[] sum = new int[3];
        
        for(int i = 0; i < dartResult.length(); i++) {
            
            if(dartResult.charAt(i) == '1') {  // 10 판별
                idx++;
                if(dartResult.charAt(i+1) == '0') {    // 10일때
                    sum[idx] = 10;
                } else {    // 10 아닐때 (S,D,T) : 1일때
                    sum[idx] = 1;
                }
            } else if(i != 0 && dartResult.charAt(i) == '0') {   // 10(이미 앞에서 계산 완) 판별
                if(dartResult.charAt(i-1) == '1') {    // 10(이미 앞에서 계산 완) 판별 : 10일때
                    continue;
                } else {    // 0일때
                    idx++;
                    sum[idx] = 0;
                }
            } else {
                if(dartResult.charAt(i) > '1' && dartResult.charAt(i) <= '9') { // 1, 0, 10 제외 나머지 점수들
                    idx++;
                    sum[idx] = dartResult.charAt(i) - '0';
                } else {
                    if(dartResult.charAt(i) == 'D') {
                        sum[idx] = (int) Math.pow(sum[idx], 2);
                    } else if(dartResult.charAt(i) == 'T') {
                        sum[idx] = (int) Math.pow(sum[idx], 3);
                    } else if(dartResult.charAt(i) == '*') {
                        if(idx == 0) sum[idx] *= 2;
                        else {
                            sum[idx] *= 2;
                            sum[idx-1] *= 2;
                        }
                    } else if(dartResult.charAt(i) == '#') {
                            sum[idx] *= -1;
                    }
                }
            }
            
        }   // for문 끝
        
        for(int i = 0; i < 3; i++) {
            answer += sum[i];
        }
        
        return answer;
    }
}
