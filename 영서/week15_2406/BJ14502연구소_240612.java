package week15_2406;

import java.io.*;
import java.util.*;

public class BJ14502연구소_240612 {
    static int N,M,map[][],max;
    static int[][]move = {{0,1},{-1,0},{0,-1},{1,0}};
    static ArrayList<Point>points;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map=new int[N][M];
        max=0;
        points =new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j]=tmp;
                if(tmp==2){
                    points.add(new Point(i,j));
                }
            }
        }

        dfs(0);
//        System.out.println(Arrays.deepToString(map));
        //바이러스는 큐에 담아서 퍼져 나가고, 벽은 어케 세우지
        System.out.println(max);


    }//main
    static void dfs(int count){
        if(count==3){
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0){
                    map[i][j]=1;
                    dfs(count+1);
                    map[i][j]=0;
                }
            }//for_j
        }//for_i
    }//dfs

    static void bfs(){
        int num=0;
        //바이러스가 퍼져나가는 걸 표시할 맵
        int[][]tMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tMap[i][j]= map[i][j];
            }//M
        }//N

        Queue<Point>q = new ArrayDeque();
        for (Point p:points){
            q.add(p);
        }

        while(!q.isEmpty()){
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = tmp.r+move[i][0];
                int nc = tmp.c+move[i][1];
                if(nr>=0 && nc>=0 && nr<N && nc<M && tMap[nr][nc]==0){
                    tMap[nr][nc]=2;
                    q.add(new Point(nr,nc));
                }
            }//move_for
        }//while

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tMap[i][j]==0)num++;
            }
        }
       max =  Math.max(num,max);

    }//bfs

    static class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
        public String toString(){
            return "r="+r+"& c="+c;
        }
    }//Point
}//class