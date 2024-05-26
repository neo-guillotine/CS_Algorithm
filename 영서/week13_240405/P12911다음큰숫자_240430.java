package week13_240405;
import java.util.*;

public class P12911다음큰숫자_240430 {
    class Solution {
        public int solution(int n) { //Integer.bitCount(); 2진수로 바꿨을 때 1의 개수를 세는 메서드가 있음?
            int answer = 0;
            int num = Integer.bitCount(n);
//            System.out.println(Integer.toBinaryString(n));
            // n보다 큰 수이면서 1의 개수가 동일한 수.
            for(int i=n+1;n<1000000;i++){
                if(Integer.bitCount(i)==num){
                    answer=i;
                    break;
                }
            }
            return answer;
        }//solution
    }//class
}
