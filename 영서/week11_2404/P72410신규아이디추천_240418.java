package week11_2404;
import java.util.*;

public class P72410신규아이디추천_240418 {
    class Solution {
        public String solution(String new_id) {
            String tmp ="";
            //1단계 대문자->소문자
            new_id = new_id.toLowerCase();
            //2단계 나머지 제거
            for(int i=0;i<new_id.length();i++){
                char thisChar=new_id.charAt(i);
                if(thisChar=='.' || thisChar=='-' || thisChar=='_' || (thisChar>='a' && thisChar<='z')|| Character.isDigit(thisChar) ){
                    tmp+=thisChar;
                }
            }
            new_id=tmp;
            tmp="";
            //3단계 . 두개 이상 나오면 .만 남기기
            for(int i=0;i<new_id.length();i++){
                char thisChar = new_id.charAt(i);
                if(thisChar=='.'&& i+1<new_id.length()){
                    while(new_id.charAt(i+1)=='.'){
                        thisChar = new_id.charAt(++i);
                        if(i+1==new_id.length())break;
                    }
                }
                tmp+=thisChar;
            }
            new_id=tmp;
            tmp="";
            //4단계 처음. 마지막.지우기
            if(new_id.charAt(0)=='.'){
                tmp=new_id.substring(1);
                new_id=tmp;
                tmp="";
            }
            if(new_id.length()>0){
                if(new_id.charAt(new_id.length()-1)=='.'){
                    tmp=new_id.substring(0,new_id.length()-1);
                    new_id=tmp;
                    tmp="";
                }
            }
            //5단계 빈 문자열이면 new_id에 a를 대입
            if(new_id.trim().isEmpty()){
                new_id="a";
            }
            //6단계 길이가 16자 이상이면 15자까지만 남기기. 마지막. 없애기
            if(new_id.length()>15){
                tmp = new_id.substring(0,15);
                if(tmp.charAt(14)=='.'){
                    tmp=tmp.substring(0,14);
                }
                new_id=tmp;
            }
            tmp="";
            //7단계 3자로 맞추기
            if(new_id.length()<3){
                tmp=Character.toString(new_id.charAt(0));
                if(new_id.length()==1){//1글자면 앞글자 더하기
                    tmp+=new_id.charAt(0);
                    tmp+=new_id.charAt(0);
                }else{//2글자면 뒷 글자 더하기
                    tmp+=new_id.charAt(1);
                    tmp+=new_id.charAt(1);
                }
                new_id=tmp;
            }
            return new_id;
        }
    }
}
