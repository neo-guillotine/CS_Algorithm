package week15_2406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10813공바꾸기_240614 {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[]bag = new int[N+1];

        for (int i = 1; i <= N; i++) {
            bag[i]=i;
        }
        for(int j=0;j<M;j++){
            st = new StringTokenizer(br.readLine());
            int target1 = Integer.parseInt(st.nextToken());
            int target2 = Integer.parseInt(st.nextToken());
            int tmp=bag[target1];
            bag[target1]=bag[target2];
            bag[target2]=tmp;
        }
        for(int i=1;i<bag.length;i++){
            sb.append(bag[i]).append(" ");
        }
        System.out.println(sb);
    }//main
}//class