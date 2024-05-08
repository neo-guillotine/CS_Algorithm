package week14_2405;

public class P159994카드뭉치_240508 {
    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "";
            int idx1=0;
            int idx2=0;

            for(String str:goal){
                if(idx1<cards1.length && cards1[idx1].equals(str)){
                    idx1++;
                }else if(idx2<cards2.length && cards2[idx2].equals(str)){
                    idx2++;
                }else{
                    return "No";
                }
            }


            return "Yes";
        }//SOLUTION
    }//CLASS
}
