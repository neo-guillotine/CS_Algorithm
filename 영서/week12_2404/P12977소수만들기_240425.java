package week12_2404;
import java.util.*;
public class P12977소수만들기_240425 {
    class Solution {
        boolean[]visited;
        int[]numArray;
        ArrayList<Integer>list;
        int answer;
        public int solution(int[] nums) {
            answer= 0;
            numArray = nums.clone();
            visited = new boolean[nums.length];
            list = new ArrayList();
            //3개 뽑기.
            pick(0,0,0);
            //소수인지 확인하기
            for(int i: list){
                isPrime(i);
            }
            return answer;
        }//SOLUTION
        void pick(int start, int count, int sum){
            if(count==3){
                list.add(sum);
                return;
            }
            for(int i=start;i<numArray.length;i++){
                if(!visited[i]){
                    visited[i]=true;
                    pick(i+1,count+1,sum+numArray[i]);
                    visited[i]=false;
                }
            }//for
        }//pick
        void isPrime(int num){
            int sqrt = (int)Math.sqrt(num);
            for(int i=2;i<=sqrt;i++){
                if(num%i==0){
                    return;
                }
            }
            answer++;
        }//isPrime
    }//CLASS
}
