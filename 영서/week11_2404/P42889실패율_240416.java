package week11_2404;
import java.util.*;

public class P42889실패율_240416 {
    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            double[]down=new double[N+2];
            double[]up = new double[N+2];
            HashMap<Integer,Double>failure = new HashMap();
            //분모구하기
            for(int i:stages){
                for(int j=1;j<=i;j++){
                    down[j]++;
                }
            }
            //분자구하기
            for(int i:stages){
                up[i]++;
            }
            //실패율 구하기
            for(int i=1;i<N+1;i++){
                if(down[i]==0){
                    failure.put(i,0.0);
                }else{
                    failure.put(i,up[i]/down[i]);
                }
            }
            //정렬
            List<Integer>keySet = new ArrayList<>(failure.keySet());
            Collections.sort(keySet,(v1,v2)->(failure.get(v2).compareTo(failure.get(v1))));
            int idx=0;
            for(int i:keySet){
                answer[idx++]=i;
            }
            return answer;
        }
    }
}

