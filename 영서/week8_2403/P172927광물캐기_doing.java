package week8_2403;

public class P172927광물캐기_doing {
    class Solution {
        int answer = Integer.MAX_VALUE;
        public int solution(int[] picks, String[] minerals) {
            //곡괭이 종류에 따라 피로도 누적 1 5 25
            //5개 캔 후 사용 불가
            //모두 캤거나, 사용할 곡괭이가 없을 때까지.
            //최소한의 피로도를 얻으려면 완탐?
            dfs(0,0,0);
            dfs(0,0,1);
            dfs(0,0,2);

            return answer;
        }
        void dfs(int fatigue, int idx, int pick){
            boolean flag=false;
            if(fatigue>answer){
                return;
            }
            for(int i=0;i<5;i++){
                int thisIdx = idx+i;
                if(thisIdx>=minerals.length){
                    flag=true;
                    answer= Math.min(answer,fatigue);
                    continue;
                }
                switch(pick){
                    case 0:
                        if(picks[0]>0){
                            fatigue+=1;
                        }
                        break;
                    case 1:
                        if(picks[1]>0){
                            switch(minerals[thisIdx]){
                                case "diamond":
                                    fatigue+=5;
                                    break;
                                default:
                                    fatigue+=1;
                                    break;
                            }
                            fatigue+=1;
                        }
                        break;
                    case 2:
                        if(picks[2]>0){
                            switch(minerals[thisIdx]){
                                case "diamond":
                                    fatigue+=25;
                                    break;
                                case "iron":
                                    fatigue+=5;
                                    break;
                                case "stone":
                                    fatigue+=1;
                                    break;
                            }
                        }
                        break;
                }
                picks[pick]--;
            }
            if(!flag){
                dfs(fatigue,idx+5,0);
                dfs(fatigue,idx+5,1);
                dfs(fatigue,idx+5,2);
            }
        }//dfs

    }
}
