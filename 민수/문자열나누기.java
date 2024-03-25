package 단두대스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열나누기 {
    public static int solution(String s) {
        int answer = 0;
        char start=' ';
        int same=0;
        int diff=0;
        for(int i=0;i<s.length();i++){
            if(same==0) {//여기가 시작이다
                start = s.charAt(i);
                same++;
                continue;//start 기록하고 다음 문자로 넘어가기
            }
            if(start==s.charAt(i)){//start다음부터 나오는 문자 판별
                same++;//같은 문자면 same+1;
            }
            else{
                diff++;//다른 문자면 diff+1;
            }
            if(same==diff){//두 수가 같아지면
                answer++;//정답(단어)+1;
                same=0;
                diff=0;
                //비교군 초기화
            }
        }
        if(same!=0){//for문을 다 돌았는데 same이 0이 아니다 -> 마지막 단어가 마무리 안되어 나옴
            answer++;//마지막 단어까지 포함
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String st=br.readLine();
        System.out.println(solution(st));
    }
}
