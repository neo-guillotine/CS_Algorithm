package week15_2406;

import java.util.*;
import java.io.*;
public class BJ14503로봇청소기_240612 {
    //dir 0북 1동 2남 3서
    static int dir, map[][],N,M,sr,sc,count;
    //후진 기준으로 0부터 3까지!
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        //map그리기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }//for
        }//fori

        if(map[sr][sc]==0){
            count++;
            map[sr][sc]=2;
        }

        clean(sr,sc,dir);

        System.out.println(count);

    }//main

    static void clean(int r, int c, int dir){
        if(map[r][c]==0){
            map[r][c]=2;
            count++;
        }

        boolean flag=false;
        for(int i=0;i<4;i++){
            int nr = r+move[i][0];
            int nc = c+move[i][1];
            if(nr>=0 && nc>=0 && nr<N && nc<M && map[nr][nc]==0){flag=true;}
        }

        if(flag){//청소되지 않은 빈 칸이 있을 때 청소기가 돌아간다.
            //반시계 90도?
            dir = (dir+3)%4;
            int nr = r+move[dir][0];
            int nc = c+move[dir][1];

            //청소하지 않은 칸 만날 때까지 회전
            while(map[nr][nc]!=0){
                dir = (dir+3)%4;
                nr = r+move[dir][0];
                nc = c+move[dir][1];
            }///while

            if(0<=nr && nr<N && 0<=nc && nc<M && map[nr][nc]==0){
                map[nr][nc]=2;
                count++;

                clean(nr,nc,dir);
            }
        //////?
        }else{///모두 깨끗하면 후진하기!
            int nr = r - move[dir][0];
            int nc = c - move[dir][1];
            if(0<=nr && nr<N && 0<=nc && nc<M  && map[nr][nc]!=1){
                clean(nr,nc,dir);
            }
        }

    }


    static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
        public String toString(){
            return "r="+r+"  &c="+c;
        }
    }
}///class

//https://giken.tistory.com/entry/%EB%B0%B1%EC%A4%80Java-14503%EB%B2%88-%EB%A1%9C%EB%B4%87-%EC%B2%AD%EC%86%8C%EA%B8%B0-%ED%92%80%EC%9D%B4-%EA%B5%AC%ED%98%84-%EC%8B%9C%EB%AE%AC%EB%A0%88%EC%9D%B4%EC%85%98