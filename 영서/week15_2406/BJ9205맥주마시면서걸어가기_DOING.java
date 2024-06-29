package week15_2406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ9205맥주마시면서걸어가기_DOING {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            int n =  Integer.parseInt(br.readLine());

            List<Point> road = new ArrayList();
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            Point start = new Point(sr,sc);

            Queue<Point> q = new ArrayDeque();
            q.add(start);

            for (int i = 0; i < n; i++) {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                road.add(new Point(r,c));
            }

            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());
            Point end = new Point(er,ec);

            //bfs
            while(!q.isEmpty()){

            }

        }//tc

    }//main
    static class Point{
        int r,c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
        String toString(int r, int c){
            return "r="+r+"&c="+c;
        }
    }


}//class
