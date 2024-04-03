package week10_2404;

import java.io.*;
import java.util.*;

public class B2178미로탐색_240403 {
    static int N,M,answer;
    static char[][]map;
    static boolean[][]visited;
    static int[][]move = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited= new boolean[N][M];
//        answer = Integer.MAX_VALUE;
        answer=0;
        Queue<Point>q = new ArrayDeque();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j]=str.charAt(j);
            }//for_i
        }//for_j
        visited[0][0]=true;
//        dfs(0,0,1);
        q.add(new Point(0,0,1));
        while(!q.isEmpty()){
            Point tmp= q.poll();
            if(tmp.r ==N-1 && tmp.c==M-1){
                answer= tmp.num;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nr = tmp.r+move[i][0];
                int nc = tmp.c+move[i][1];
                if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] &&map[nr][nc]=='1'){
                    visited[nr][nc]=true;
                    q.add(new Point(nr,nc,tmp.num+1));
                }
            }
        }
        System.out.println(answer);
    }//MAIN

    static void dfs(int r,int c, int num){
        if(r==N-1 && c==M-1){
            answer = Math.min(num, answer);
            return;
        }
        if(num>=answer)return;
        //nr, nc 체크
        int nr=0;
        int nc=0;
        for (int i = 0; i < 4; i++) {
            nr = r+move[i][0];
            nc = c+move[i][1];
            if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] &&map[nr][nc]=='1'){
                visited[nr][nc]=true;
                dfs(nr,nc,num+1);
                visited[nr][nc]=false;
            }
        }
    }//dfs
    static class Point{
        int r;
        int c;
        int num;
        public Point(int r, int c,int num){
            this.r = r;
            this.c = c;
            this.num = num;
        }
        @Override
        public String toString(){
            return "r"+r+" &c"+c;
        }
    }
}//CLASS
