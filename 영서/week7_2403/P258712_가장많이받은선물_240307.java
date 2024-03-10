import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][]graph = new int[friends.length][friends.length];
        boolean[][]visited = new boolean[friends.length][friends.length];
        //friends 순서대로 값 설정해주기..
        HashMap<String,Integer>map= new HashMap();
        int num=0;
        for(String a: friends){
            map.put(a,num++);
        }
        int[]next =new int[friends.length];
        //다음 달에 가장 선물을 많이 받을 개수
        //0->1 주는거임
        // 선물지수 배열
        int[]gift = new int[friends.length];

        for(String a: gifts){
            String from = a.split(" ")[0];
            String to= a.split(" ")[1];
            graph[map.get(from)][map.get(to)]++;
            //선물지수 계산. 선물 주면++, 받았으면 --;
            gift[map.get(from)]++;
            gift[map.get(to)]--;
        }

        // 그래프에서 비교
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph.length;j++){
                //두번씩해야되나? flag찾기
                if(i==j)continue;
                if(visited[i][j])continue;
                if(graph[i][j]>graph[j][i]){
                    //1. 선물을 더 많이 준 사람이 받는다.
                    next[i]++;
                }else if(graph[i][j]<graph[j][i]){
                    next[j]++;
                }else{
                    //2. 값이 같을 때, 선물지수 비교
                    if(gift[i]>gift[j]){
                        next[i]++;
                    }else if(gift[i]<gift[j]){
                        next[j]++;
                    }
                }
                visited[i][j]=true;
                visited[j][i]=true;
            }//for_j
        }//for_i
        for(int a:next){
            answer=Math.max(a,answer);
        }
        return answer;
    }//solution
}//class
