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

            //왜 3회전만 하는지 모르겟다...
            ArrayList<String> list=new ArrayList();

            String str = br.readLine();
            Queue<Character> queue = new ArrayDeque<>();
            for (int j = 0; j < str.length(); j++) {
                queue.add(str.charAt(j));
            }
            //한 변에 들어가야 하는 숫자의 개수
            int num = N/4;


            //3회전 렛츠고
            for (int k = 0; k < 3; k++) {
                String s = str.substring(1,str.length());
                s+=str.charAt(0);
                str =s;

                int idx = 0;
                for (int j = 0; j < 4; j++) {
                    String splitStr=str.substring(idx,idx+=num);
                    if(!list.contains(splitStr)){
                        list.add(splitStr);
                    }
                }
                char poll = queue.poll();
                queue.add(poll);
            }
            list.sort(Collections.reverseOrder());
            answer = Integer.parseInt(list.get(K-1),16);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }//tc

        System.out.print(sb);
    }//method
}//class
