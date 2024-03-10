package week7_2403;

public class P140108_문자열나누기_240309 {
    public int solution(String s) {
        int answer = 0;
        char first=s.charAt(0);
        int firstCnt=0;
        int otherCnt=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==first){
                firstCnt++;
            }else{
                otherCnt++;
            }//if

            if(otherCnt==firstCnt){
                firstCnt=0;
                otherCnt=0;
                answer++;
                if(i+1<s.length()){
                    first = s.charAt(i+1);
                }
                continue;
            }
            if(i==s.length()-1){
                answer++;
            }
        }//for

        return answer;
    }//solution
}
