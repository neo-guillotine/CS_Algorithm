package week15_2406;
import java.util.*;

public class P12973짝지어제거하기_240608 {

    class Solution{
        public int solution(String s){
            int answer = 0;
            Stack<Character> stack = new Stack();
            stack.push(s.charAt(0));
            for(int i=1;i<s.length();i++){
                if(stack.size()==0){
                    stack.push(s.charAt(i));
                }else{
                    if(stack.peek()==s.charAt(i)){
                        stack.pop();
                    }else{
                        stack.push(s.charAt(i));
                    }
                }
            }//for

            if(stack.size()==0){answer=1;}

            return answer;
        }//solution
    }//class

/*
class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        boolean flag = true;
        while(flag){
            flag=false;
            for(int i=0;i<s.length()-1;i++){
                char tmp = s.charAt(i);
                // System.out.println(tmp);
                String strTmp="";
                if(tmp==s.charAt(i+1)){
                    strTmp+=s.substring(0,i);
                    strTmp+=s.substring(i+2);
                    s=strTmp;
                    flag=true;
                }
            }//for
            // System.out.println("====="+s);
        }//while

        if(s.length()==0){
            answer=1;
        }else{
            answer=0;
        }


        return answer;
    }
}
*/
}
