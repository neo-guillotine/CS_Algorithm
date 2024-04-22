package week11_2404;

public class P161989덧칠하기_240417 {
    class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 0;
            //가장 앞에서부터 일단 1번 칠하고 빈 공간부터 다시 칠하기
            boolean[]wall = new boolean[n+1];
            for(int i:section){
                wall[i]=true;
            }

            for(int i=1;i<n+1;i++){
                if(!wall[i])continue;//칠해져있으면 넘어가기
                for(int j=i;j<i+m;j++){
                    if(j>n)break;
                    wall[j]=false;
                }
                answer++;
            }
            return answer;
        }
    }
}
