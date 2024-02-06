import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        //가장 낮은 점수 p*m
        //높은 점수부터 sort하고 m개 고르기.
        Arrays.sort(score);
        Stack <Integer>stack = new Stack();
        for(int i:score){
            stack.add(i);
        }
        ArrayList<Integer>list = new ArrayList();
        while(stack.size()>=m){
            ArrayList<Integer>tmp = new ArrayList();
            for(int i=0;i<m;i++){
                tmp.add(stack.pop());
            }
            list.add(tmp.get(m-1)*m);
        }
        for(int i:list){
            answer+=i;
        }
        return answer;
    }//solution
}//class