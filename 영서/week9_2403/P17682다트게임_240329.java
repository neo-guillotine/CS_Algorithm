package week9_2403;
import java.util.*;
public class P17682다트게임_240329 {
    class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            char ch = ' ';
            int score=0;
            int square=0;
            int size=0;
            int idx=0;
            int strLength = dartResult.length();
            Stack<Integer>stack = new Stack();
            while(idx<strLength-1){
                //점수
                ch = dartResult.charAt(idx);
                if(Character.isDigit(ch)){
                    score = Character.getNumericValue(ch);
                }//if
                //보너스
                ch = dartResult.charAt(++idx);
                if(ch=='0'){
                    score=10;
                    ch = dartResult.charAt(++idx);
                }
                switch(ch){
                    case 'S':
                        square = 1;
                        break;
                    case 'D':
                        square = 2;
                        break;
                    case 'T':
                        square = 3;
                        break;
                }
                score = (int)Math.pow(score,square);
                if(idx>strLength){
                    break;
                }

                //옵션
                if(idx+1>=strLength){
                    stack.add(score);
                    break;
                }
                ch = dartResult.charAt(++idx);
                if(Character.isDigit(ch)){
                    stack.add(score);
                }else{
                    size = stack.size();
                    switch(ch){
                        case '*':
                            if(size>0){
                                int tmp = stack.pop();
                                tmp*=(2);
                                stack.add(tmp);
                            }
                            stack.add(score*2);
                            break;
                        case '#':
                            stack.add(score*(-1));
                            break;
                    }//switch
                    idx++;
                }//if
            }//for

            for(int num:stack){
                answer+=num;
            }
            return answer;
        }
    }
}
