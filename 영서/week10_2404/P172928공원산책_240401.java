package week10_2404;
import java.util.*;
public class P172928공원산책_240401 {
    class Solution {
        public int[] solution(String[] park, String[] routes) {
            //N S W E
            int[]answer = new int[2];
            // int[][]move = {{-1,0},{1,0},{0,-1},{0,1}};
            int[] op = new int[2];
            String dir = "";
            int dis = 0;
            int h = park.length;
            int w = park[0].length();
            char[][]map = new char[h][w];
            String[] tmp = new String[2];
            Point start = new Point();

            for(int i=0;i<h;i++){
                String str = park[i];
                for(int j=0;j<w;j++){
                    map[i][j] =str.charAt(j);
                    if(map[i][j]=='S'){
                        start = new Point(i,j);
                    }
                }
            }

            //방향 거리 Split
            for(String str: routes){
                tmp = str.split(" ");
                dir = tmp[0];
                dis = Integer.parseInt(tmp[1]);
                int nr =0;
                int nc=0;
                boolean flag=false;
                //이동        //N S W E
                // System.out.println(start);

                switch(dir){
                    case "N":
                        nr=start.r-dis;
                        // nc=start.c;
                        if(nr>=0 && nr<h && map[nr][start.c]!='X'){
                            //가는길에 장애물 있는지 체크
                            for(int i=0;i<dis;i++){
                                if(map[start.r-i][start.c]=='X'){
                                    flag=true;
                                    break;
                                }
                            }
                            if(!flag){
                                start = new Point(nr,start.c);
                            }
                        }
                        break;
                    case "S":
                        nr=start.r+dis;
                        // nc=start.c;
                        if(nr>=0 && nr<h && map[nr][start.c]!='X'){
                            //가는길에 장애물 있는지 체크
                            for(int i=0;i<dis;i++){
                                if(map[start.r+i][start.c]=='X'){
                                    flag=true;
                                    break;
                                }
                            }
                            if(!flag){
                                start = new Point(nr,start.c);
                            }
                        }

                        break;
                    case "W":
                        // nr=start.r;
                        nc=start.c-dis;
                        if(nc>=0 && nc<w && map[start.r][nc]!='X'){
                            //가는길에 장애물 있는지 체크
                            for(int i=0;i<dis;i++){
                                if(map[start.r][start.c-i]=='X'){
                                    flag=true;
                                    break;
                                }
                            }
                            if(!flag){
                                start = new Point(start.r,nc);
                            }
                        }
                        break;
                    case "E":
                        // nr=start.r;
                        nc=start.c+dis;
                        if(nc>=0 && nc<w && map[start.r][nc]!='X'){
                            //가는길에 장애물 있는지 체크
                            for(int i=0;i<dis;i++){
                                if(map[start.r][start.c+i]=='X'){
                                    flag=true;
                                    break;
                                }
                            }
                            if(!flag){
                                start = new Point(start.r,nc);
                            }
                        }
                        break;
                }//dir switch
            }//routes for


            answer[0]=start.r;
            answer[1]=start.c;
            return answer;
        }//solution
        class Point{
            int r;
            int c;
            public Point(){
            }
            public Point(int r, int c){
                this.r = r;
                this.c = c;
            }
            public String toString(){
                return "r="+r+" &c="+c;
            }
        }
    }//class
}
