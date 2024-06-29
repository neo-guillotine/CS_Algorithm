package week17_2406;

import java.util.ArrayDeque;
import java.util.Queue;
public class P1844게임맵최단거리_240628 {
    //BFS로 돌면서 N-1,M-1에 도착하면 BREAK;
    public static int solution(int[][] maps) {
        int move[][]={{0,-1},{1,0},{0,1},{-1,0}};
        int answer=Integer.MAX_VALUE;
        int n = maps.length;
        int m = maps[0].length;
        boolean visited[][]=new boolean[n][m];
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0,0,1));
        visited[0][0]=true;
        int num=0;
        while(!q.isEmpty()){
            num++;
            Point tmp = q.poll();
            // System.out.println(num+" "+tmp);
            if(tmp.r ==n-1 && tmp.c ==m-1){
                answer = tmp.num;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nr = tmp.r+move[i][0];
                int nc = tmp.c+move[i][1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && maps[nr][nc]==1 && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    q.add(new Point(nr,nc,tmp.num+1));
                }
            }

        }
        if(answer ==Integer.MAX_VALUE){
            answer=-1;
        }
        return answer;
    }
    static class Point{
        int r,c,num;
        public Point(int r, int c, int num){
            this.r=r;
            this.c=c;
            this.num=num;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}