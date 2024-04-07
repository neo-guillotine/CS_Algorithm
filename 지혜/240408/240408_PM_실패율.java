import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        // stages 오름차순 sorting
        // ex : [1, 2, 2, 2, 3, 3, 4, 6]
        Arrays.sort(stages);
        
        int mom = 0;    // 분모
        int son = 0;    // 분자
        boolean momFlag = false;
        double[] calc = new double[N];
        for(int n = 1; n <= N; n++) {
            for(int s = 0; s < stages.length; s++) {
                if(n == stages[s]) {
                    if(!momFlag) {
                        momFlag = true;
                        mom = stages.length - s;
                    }
                    son++;
                }
            }
            if(mom == 0) calc[n-1] = 0.0;
            else calc[n-1] = (double)son/mom;
            
            momFlag = false;
            mom = 0;
            son = 0;
        }
        
        // map으로 받아서 value 기준 sorting
        HashMap<Integer, Double> hm = new HashMap<>();
        for(int c = 0; c < calc.length; c++) {
            hm.put(c+1, calc[c]);
        }
        
        List<Integer> list = new ArrayList<>(hm.keySet());
        Collections.sort(list, (o1, o2) -> Double.compare(hm.get(o2), hm.get(o1)));
        // key값 출력
        for(int l = 0; l < list.size(); l++) {
            answer[l] = (int)list.get(l);
        }
        return answer;
    }
}
