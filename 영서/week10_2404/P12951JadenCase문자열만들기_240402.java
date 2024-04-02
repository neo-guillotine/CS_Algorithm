package week10_2404;
import java.util.*;


public class P12951JadenCase문자열만들기_240402 {
    class Solution {
        public String solution(String s) {
            StringBuilder answer =new StringBuilder();
            char[]cList = s.toCharArray();
            boolean isBlank=true;

            for(int i=0;i<s.length();i++){
                if(cList[i]==' '){
                    isBlank=true;
                    continue;
                }
                if(isBlank){
                    if(Character.isDigit(cList[i])){
                        isBlank=false;
                        continue;
                    }
                    cList[i]=Character.toUpperCase(cList[i]);
                    isBlank=false;
                    continue;
                }
                if(Character.isUpperCase(cList[i])){
                    cList[i]=Character.toLowerCase(cList[i]);
                }
            }
            for(char c:cList){
                answer.append(c);
            }
            return answer.toString();
        }
    }
}
