package week11_2404;
import java.util.*;
public class P250121데이터분석_240419 {


    class Solution {
        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
            int[][] answer = {};
            HashMap<String, Integer>extList=new HashMap();
            ArrayList<int[]>lists = new ArrayList();
            extList.put("code",0);
            extList.put("date",1);
            extList.put("maximum",2);
            extList.put("remain",3);
            //ext값이 val_ext보다 작은 데이터 추출
            for(int[]list:data){
                if(list[extList.get(ext)]<val_ext){
                    // System.out.println("===="+Arrays.toString(list));
                    lists.add(list);
                }
            }


            final Integer idx = extList.get(sort_by);
            // Collections.sort(lists,(a,b)->(a[idx].compareTo(b[idx])));
            Collections.sort(lists,(a,b)->Integer.compare(a[idx],b[idx]));
            answer = new int[lists.size()][4];
            int id=0;
            for(int[]li:lists){
                answer[id++]=li;
            }
            return answer;
        }
    }
}
