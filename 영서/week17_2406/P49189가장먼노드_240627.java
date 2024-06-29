package week17_2406;

import java.util.ArrayDeque;
import java.util.Queue;

public class P49189가장먼노드_240627 {
    public static void main(String[] args) {
        int[][]arr = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        System.out.println(solution(6,arr));
    }
        public static int solution(int n, int[][] edge) {
            int answer = 0;
            Queue<Integer>q = new ArrayDeque<>();
            //1. 각 노드의 연결 배열 생성
            boolean map[][]=new boolean[n+1][n+1];
            //방문처리 배열
            boolean visited[]=new boolean[n+1];
            for (int[] e:edge) {
                int n1 = e[0];
                int n2 = e[1];
                map[n1][n2]=true;
                map[n2][n1]=true;
            }

            //2. bfs로 돌리면서 마지막 q가 돌 때, 해당 개수 구하기
            q.add(1);
            visited[1]=true;

            while (!q.isEmpty()){
                int qsize= q.size();
                for (int j = 0; j < qsize; j++) {
                    int tmp = q.poll();
                    for (int i = 0; i < n; i++) {
                        if(!visited[i+1]&&map[tmp][i+1]){
                            q.add(i+1);
                            visited[i+1]=true;
                        }
                    }
                }
                answer=qsize;
            }

            return answer;

        }
}
