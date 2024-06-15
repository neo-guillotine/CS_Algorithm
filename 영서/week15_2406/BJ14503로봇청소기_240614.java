package week15_2406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14503로봇청소기_240614 {
    static int N;
    static int M;
    static int sr;
    static int sc;
    static int dir;
    static int[][] map;
    static int count;
//    static int [][]move ={{0,1},{1,0},{0,-1},{-1,0}};
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sr=Integer.parseInt(st.nextToken());
        sc=Integer.parseInt(st.nextToken());
        //dir 0 1 2 3 -> 북 동 남 서
        dir=Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //청소했으면 2로 바꾸기
        clean(sr,sc,dir);
        System.out.println(count);
    }//main

    static void clean(int r,int c, int d){
        //현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        if(map[r][c]==0){
            map[sr][sc] = 2;
//            System.out.println(count);
            count++;
        }

        //주위 4칸 중 0이 있는지 없는지 체크
        boolean flag=false;
        for(int i=0;i<4;i++){
            int nr = r+move[i][0];
            int nc = c+move[i][1];
            if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==0){
                flag = true;
                break;
            }
        }

        //2. 청소되지 않은 빈칸이 없는 경우
        if(!flag){
            //후진하기 -하면되나?
            int nr = r-move[d][0];
            int nc = c-move[d][1];
            if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]!=1){
                //벽이 아니면 다시 처음으로 돌아간다.
                clean(nr,nc,d);
            }
        }else{//3. 청소되지 않은 칸이 있는 경우 반시계 방향으로 돌면서 청소되지 않은 경우 전진.
            //0->3북->서 3->2서->남 2->1남->동 1->0동->북
            //반시계로 회전
            d=(d+3)%4;
            int nr = r+move[d][0];
            int nc = c+move[d][1];

            while(map[nr][nc]!=0){
                d=(d+3)%4;
                nr = r+move[d][0];
                nc = c+move[d][1];
            }

            if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==0){
                map[nr][nc]=2;
                count++;
                clean(nr,nc,d);
            }

        }

    }//clean
}//class
