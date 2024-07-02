package week15_2406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    static int N, K;
    static String password;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);
            password = br.readLine();

            List<Integer> list = new ArrayList<>();

            int wordLen = password.length() / 4;
            for (int k = 0; k < wordLen; k++) {
                int start = 0;
                for (int i = 0; i < 4; i++) {
                    int key = Integer.parseInt(password.substring(start, start + (wordLen)), 16);
                    if (!list.contains(key)) {
                        list.add(key);
                    }
                    start += password.length() / 4;
                }
                String front = password.substring(0, N - 1);
                String back = password.substring(N - 1);
                password = back + front;
            }

            list.sort(Collections.reverseOrder());
            sb.append("#").append(tc).append(" ").append(list.get(K - 1)).append("\n");
        }
        System.out.println(sb);
    }
}