package week9_2403;

public class P77484로또의최고순위와최저순위_240326 {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];
            // 일단 같은 숫자가 몇개인지 확인 -> 최저순위.
            // 0의 갯수만큼 더한게 최고 순위
            //for문 2개 돌리기
            int same=0;
            int zero=0;
            for(int i: lottos){
                if(i==0){
                    zero++;
                    continue;
                }
                for(int j:win_nums){
                    if(i==j){
                        same++;
                    }
                }
            }
            //System.out.println(same+" "+zero);
            switch (same){
                case 2:
                    answer[1]=5;
                    break;
                case 3:
                    answer[1]=4;
                    break;
                case 4:
                    answer[1]=3;
                    break;
                case 5:
                    answer[1]=2;
                    break;
                case 6:
                    answer[1]=1;
                    break;
                default:
                    answer[1]=6;
                    break;
            }

            switch (same+zero){
                case 2:
                    answer[0]=5;
                    break;
                case 3:
                    answer[0]=4;
                    break;
                case 4:
                    answer[0]=3;
                    break;
                case 5:
                    answer[0]=2;
                    break;
                case 6:
                    answer[0]=1;
                    break;
                default:
                    answer[0]=6;
                    break;
            }
            return answer;
        }//solution
    }//class
}
