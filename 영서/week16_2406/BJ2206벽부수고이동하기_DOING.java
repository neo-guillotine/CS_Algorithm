package week16_2406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2206벽부수고이동하기_DOING {
    public static void main(String[] args) throws IOException {
        //bfs로 이동
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][]map = new int[N][M];
        //벽부수고 갈때랑 그냥 갈 이동할 때 체크를 따로 해야 함.
        boolean[][][]visited=new boolean[N][M][2];
        Queue<Point> q = new ArrayDeque();
        int answer =Integer.MAX_VALUE;
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

        for (int i = 0; i < N; i++) {
            String str =sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j]=str.charAt(j)-'0';
            }//FORJ
        }//FOPRI
        q.add(new Point(0,0,1,false));
        visited[0][0][0]=true;

        while(!q.isEmpty()){
            Point tmp = q.poll();
//            System.out.println(tmp.r+" "+tmp.c+" "+tmp.count+tmp.flag);
            if(tmp.r==N-1 && tmp.c==M-1){
                answer =tmp.count;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nr = tmp.r+move[i][0];
                int nc = tmp.c+move[i][1];
                if(nr>=0 && nr<N && nc>=0  && nc<M ){
                    if(map[nr][nc]==0){ //1. 이동할 수 있는 곳이면

                        if(tmp.flag && !visited[nr][nc][1]){ //1. 벽을 부순 적이 있으면
                            visited[nr][nc][1]=true;
                            q.add(new Point(nr,nc,tmp.count+1,true));
                        }else if(!tmp.flag && !visited[nr][nc][0]){//2. 벽을 부순 적이 없으면
                            visited[nr][nc][0]=true;
                            q.add(new Point(nr,nc,tmp.count+1,false));
                        }

                    }else if(!tmp.flag){//2. 이동할 수 없는 곳이고 벽을 부순 적이 없으면
                        visited[nr][nc][1]=true;
                        q.add(new Point(nr,nc,tmp.count+1,true));
                    }
                }
            }//move
        }
        if(answer==Integer.MAX_VALUE){
            answer=-1;
        }
        System.out.println(answer);
    }//main
    static class Point{
        int r, c,count;
        boolean flag;
        public Point(int r, int c, int count,boolean flag){
            this.r=r;
            this.c=c;
            this.count = count;
            this.flag=flag;
        }
        String toString(int r, int c, boolean flag){
            return "r="+r+"&c="+c+"&flag="+flag;
        }
    }
}//class

//반례 https://www.acmicpc.net/board/view/107646