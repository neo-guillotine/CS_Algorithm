package week10_2404;

import java.io.*;
import java.util.*;

public class B13460구슬탈출2_doing {
    static int N,M,answer;
    static char map[][];
    static boolean visited[][];
    static Point blue, red;
    static int[][] move={{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        int min=0;
        Queue<Point>redQueue = new ArrayDeque<>();
        Queue<Point>blueQueue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j]=='R'){
                    red = new Point(i,j,0);
                    redQueue.add(red);
                }else if(map[i][j]=='B'){
                    blue = new Point(i,j,0);
                    blueQueue.add(red);
                }
            }
        }//map

        while(!redQueue.isEmpty()){
            Point red = redQueue.peek();
            Point blue = blueQueue.peek();
            int num=red.num;
            int rnr = red.r;
            int rnc = red.c;
            int bnr = blue.r;
            int bnc = blue.c;
            for (int i = 0; i < 4; i++) {
                boolean rFlag=true;
                boolean bFlag=true;

                //이미 이동거리가 최솟값보다 커지면 더 볼필요도 없다.
                if(num>10){
                    answer=-1;
                    break;
                }
                if(num>answer)break;

                //한 쪽 방향으로 이동!
                while(true){
                    //r의 이동 방법
                    if(map[rnr][rnc]=='O') {
                        //while문 for문에서 빠져나가기
                        //b랑 같이 왔는지도 확인해야 함.
                        answer = Math.min(answer,num+1);
                        break;
                    }else if(map[rnr][rnc]=='#'){//벽에 부딪히면 더 갈 수 없으니까 rq에 넣고 while문에서 빠져나가기
                        //벽까지 오기 전 값을 확인하기
                        redQueue.add(new Point(rnr,rnc,num+1));
                        rFlag=false;
                    } else if(map[rnr][rnc]=='B'){
                        //B 이동한 다음에 다시 R 이동시키기
                        //기다리기
                    }
                    //b의 이동 방법
                    if(map[bnr][bnc]=='O') {
                        //여기 도달한거면 r보다 먼저 온거 아닌가..?
                        answer = -1;
                        break;
                    }else if(map[bnr][bnc]=='#'){//벽에 부딪히면 더 갈 수 없으니까 rq에 넣고 while문에서 빠져나가기
                        blueQueue.add(new Point(bnr,bnc,num+1));
                        bFlag=false;
                    } else if(map[bnr][bnc]=='R'){
                        //B 이동한 다음에 다시 R 이동시키기
                        break;
                    }

                    //걸러지지 않았으면 이동 가능한 경우
                    if(rFlag){
                        rnr+=move[i][0];
                        rnc+=move[i][1];
                    }//r이 이동할 수 있는지 확인
                    if(bFlag){
                        bnr+=move[i][0];
                        bnc+=move[i][1];
                    }//b가 이동할 수 있는지 확인
                }//while막히는 곳까지 이동하기
//                while(true){
//                    if(map[bnr][bnc]=='#')break;
//                    bnr+=move[i][0];
//                    bnc+=move[i][1];
//                }

            }//사방탐색
        }//while

    }//main

    static void move(Point p, int type){

    }

    static class Point{
        int r;
        int c;
        int num;
        public Point(int r, int c,int num){
            this.r=r;
            this.c=c;
            this.num=num;
        }
    }
}//class