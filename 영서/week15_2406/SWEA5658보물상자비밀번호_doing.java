package week15_2406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA5658보물상자비밀번호_doing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= tc; i++) {
            int answer=0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            ArrayList<String> list=new ArrayList();

            String str = br.readLine();

            //한 변에 들어가야 하는 숫자의 개수
            int num = N/4;

            for (int k = 0; k < num; k++) {

                int idx = 0;
                for (int j = 0; j < 4; j++) {
                    String splitStr=str.substring(idx,idx+=num);
                    if(!list.contains(splitStr)){
                        list.add(splitStr);
                    }
                }
                String s = str.substring(1,str.length());
                s+=str.charAt(0);
                str =s;

            }
            list.sort(Collections.reverseOrder());

//            System.out.println(list);

            answer = Integer.parseInt(list.get(K-1),16);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }//tc

        System.out.print(sb);
    }//method
}//class
