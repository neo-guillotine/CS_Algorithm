package week7_2403;

public class P154539_뒤에있는큰수찾기 {
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            for(int i=0;i<numbers.length;i++){
                for(int j=i;j<numbers.length;j++){
                    if(numbers[i]<numbers[j]){
                        answer[i]=numbers[j];
                        break;
                    }//if
                    answer[i]=-1;
                }//for_j
            }//for-i
            return answer;
        }
    }
}
