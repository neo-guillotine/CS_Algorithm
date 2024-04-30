package week12_2404;

public class P133499옹알이_240426 {
    class Solution {
        public int solution(String[] babbling) {
            int answer = 0;
            String[]list = { "aya", "ye", "woo", "ma"};
            for(String str:babbling){
                // System.out.println("1"+str);
                for(String strList:list){
                    if(str.contains(strList)){
                        if(str.contains(strList+strList)){continue;}//2번나오면
                        str= str.replaceAll(strList," ");
                    }
                }
                // System.out.println("2"+str);
                if(str.trim().length()==0){
                    answer++;
                }
            }
            return answer;
        }
    }
}
