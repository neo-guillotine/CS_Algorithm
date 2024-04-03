package week10_2404;
import java.util.*;


public class P70129이진변환반복하기_240403 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];
            boolean flag=false;
            while(!flag){
                //0제거
                String s1 = s.replace("0","");
                answer[1] += s.length()-s1.length();
                //이진법 변환
                s = toBinary(s1.length());
                if(s.equals("1")){flag=true;}
                answer[0]++;
            }
            return answer;
        }//solution
        String toBinary(int num){
            Stack<Integer>stack = new Stack();
            while((num/2)>0){
                stack.push(num%2);
                num=num/2;
            }
            stack.add(1);
            String s="";
            while(!stack.isEmpty()){
                s+=stack.pop();
            }
            // System.out.println(s);
            return s;
        }//toBinary

    }//class
}
