package week07_2403;

import java.util.*;

public class P154539뒤에있는큰수찾기 {
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];

            Arrays.fill(answer,-1);
            Stack<Integer>stack = new Stack<>();
            //뒤에 있는 숫자부터 값을 넣기. 더 크면 그 값으로 바꾸기
            for (int i = numbers.length-1; i >=0 ; i--) {
                while(!stack.isEmpty()){
                    if(stack.peek()>numbers[i]){
                        answer[i]=numbers[i];
                        break;
                    }else{
                        stack.pop();
                    }
                }
                stack.push(numbers[i]);
            }//for
/*
//시간초과
            for(int i=0;i<numbers.length;i++){
                for(int j=i;j<numbers.length;j++){
                    if(numbers[i]<numbers[j]){
                        answer[i]=numbers[j];
                        break;
                    }//if
                    answer[i]=-1;
                }//for_j
            }//for-i           
 */
            return answer;
        }
    }
}
