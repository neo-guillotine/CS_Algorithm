package week10_2404;

import java.io.*;
import java.util.*;

public class S1949등산로조성_240401 {
    //가장 높은 곳을 MaxHeightList에 넣고... 각각 DFS로 이동해보기?
    //근데 그러면 VISITED배열도 이동하는 방향마다 가야되나
    static ArrayList<Point>maxList;
    static int n,k,answer,map[][];
    static int[][] move={{-1,0},{0,1},{1,0},{0,-1}};
    static boolean visited[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= r; i++) {
            answer=1;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());   //지도 길이
            k = Integer.parseInt(st.nextToken());   //공사 가능 깊이

            map=new int[n][n];
            visited=new boolean[n][n];
            maxList= new ArrayList<>();
            int max=Integer.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < n; l++) {
                    map[j][l]=Integer.parseInt(st.nextToken());
                    if(max>map[j][l]){
                        continue;
                    }else if(max<map[j][l]){
                        max = map[j][l];
                        maxList= new ArrayList<>();
                    }
                    maxList.add(new Point(j,l));
                }
            }

            for(Point p:maxList){
                visited[p.r][p.c]=true;
                dfs(p.r,p.c,1,false);
                visited[p.r][p.c]=false;

            }
            System.out.println("#"+i+" "+answer);
        }
    }
    static void dfs(int r, int c, int num, boolean flag){
//        System.out.println("num: "+num+" r:"+r+" c:"+c);

        answer=Math.max(num,answer);
        //4방으로 이동하기. 갈 곳이 없으면 return. num이랑 answer랑 비교해서 최대 값 넣기?
        for (int i = 0; i < 4; i++) {
            int nr = r+move[i][0];
            int nc = c+move[i][1];
            if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]){//범위 내에 있을 때.
                if(map[nr][nc]<map[r][c]){//작으면 그냥 이동 가능
                    visited[nr][nc]=true;
                    dfs(nr,nc,num+1,flag);
                    visited[nr][nc]=false;
                }else{
                    if(flag)continue;   //마이너스 했으면 건너 뛰기
                    for(int j=1;j<=k;j++){
//                        System.out.println("-");
                        if(map[nr][nc]-j<map[r][c]) {//높이 줄여서 이동 가능
                            visited[nr][nc]=true;
                            map[nr][nc] -= j;
                            dfs(nr, nc, num + 1,true);
                            //맵 다시 복구
                            map[nr][nc] += j;
                            visited[nr][nc]=false;
                        }
                    }
                }
            }
        }//사방으로 이동
    }
    static class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r=r;
            this.c=c;
        }
        public String toString(){
        return "r="+r+" &c="+c;
        }
    }//point
}//class
