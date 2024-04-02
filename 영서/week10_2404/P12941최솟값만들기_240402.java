package week10_2404;
import java.util.*;
public class P12941최솟값만들기_240402 {
    class Solution
    {
        int answer = 0;
        public int solution(int []A, int []B)
        {
            Arrays.sort(A);
            Arrays.sort(B);
            for(int i=0;i<A.length;i++){
                answer+=A[i]*B[A.length-i-1];
            }

            return answer;
        }

    }
}
