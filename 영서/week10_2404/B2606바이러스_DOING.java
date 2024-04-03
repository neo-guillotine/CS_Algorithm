package week10_2404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class B2606바이러스_DOING {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       //HashSet에 Contains로 체크해서 넣기 없으면 새로운 set만들기
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<HashSet>list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        list.add(set);
    }
}
