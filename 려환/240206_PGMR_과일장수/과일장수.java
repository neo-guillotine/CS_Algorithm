import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        // 가격 계산은 최저가인 사과 곱하기 갯수 곱하기 상자의 갯수
        // 한 상자의 가격은 최저가 * 갯수인 것이다.
        // k 는 score 안에 있는 최고점 사과
        int kCount = 0;
        List<Integer> list = new ArrayList<>();
        for(int a : score){
            list.add(a);
        }
        Collections.sort(list);
        int count = 0;
        int [] box = new int [m];
        for(int i = list.size()-1; i >= 0; i --){
            box[count] = list.get(i);
            count ++;
            if(count == m){
                count = 0;
                answer += (box[m-1] * m);
                box = new int[m];
            }
        }
        return answer;
    }
}