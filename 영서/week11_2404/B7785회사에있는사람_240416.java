package week11_2404;

import java.io.*;
import java.util.*;

public class B7785회사에있는사람_240416 {
    public static void main(String[] args) throws Exception{
        //로그가 주어졌을 때 회사에 있는구하기 -> 사전의 역순으로 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        HashMap<String,String>list = new HashMap<>();
        String name="";
        String el="";
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            name=st.nextToken();
            el= st.nextToken();
            if(el.equals("enter")){
                list.put(name,"enter");
            }else{
                list.remove(name);
            }
        }
//        String[]names = list.toArray(new String[list.size()]);
//        Arrays.sort(names,Comparator.reverseOrder());
        ArrayList<String>keySet = new ArrayList<>(list.keySet());
        Collections.sort(keySet,Collections.reverseOrder());
        for(String str:keySet){
            sb.append(str).append("\n");
        }
        sb.trimToSize();
        System.out.print(sb);
    }//main
}//class

/*
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[]args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N= Integer.parseInt(st.nextToken());
        String name="";
        String eol="";
        ArrayList<String>names = new ArrayList();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            eol= st.nextToken();
            if(eol.equals("enter")){
                names.add(name);
            }else{
                names.remove(name);
            }
        }//for
        //남은 애들 정렬하기
        String[] sortName = names.toArray(new String[names.size()]);
        Arrays.sort(sortName,Comparator.reverseOrder());
        for(String str:sortName){
            System.out.println(str);
        }
    }//main
}//class
 */