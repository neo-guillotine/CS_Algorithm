package week14_2405;

public class P155652둘만의암호_240508{
    class Solution {
        public String solution(String s, String skip, int index) {
            String answer = "";
            //charAt가져와서 skip에 포함되어 있는지 확인. index까지 값 확인하고 아니면 그 전 값 넣기
            for(int i=0;i<s.length();i++){
                char thisChar = s.charAt(i);
                int plus=0;
                // System.out.println(thisChar);
                while(plus<=index){
                    //thisChar가 skip에 포함되어 있는 경우 뒤로 미루기
                    while(skip.contains(Character.toString(thisChar))){
                        thisChar++;
                        if(thisChar=='z'+1){
                            thisChar='a';
                        }
                    }
                    if(index==plus){//만약 마지막으로 이동한 값이 skip에 포함되어있으면 또 미루기
                        answer+=thisChar;
                        break;
                    }//if
                    plus++;
                    thisChar++;
                    if(thisChar=='z'+1){
                        thisChar='a';
                    }
                }//while
            }//for
            return answer;
        }//solution
    }//class
}
