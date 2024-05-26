package week14_2405;

public class P12945피보나치수_240407 {
    class Solution {
        int[] arr;
        public int solution(int n) {
            int answer = 0;
            arr =new int[100001];
            int fivNum = fiv(n);
            answer = fivNum%1234567;
            return answer;
        }

        int fiv(int n){
            arr[0]=0;
            arr[1]=1;
            if(n==0){
                return arr[0];
            }else if(n==1){
                return arr[1];
            }else{
                for(int i=2;i<=n;i++){
                    // overflow
                    // arr[i]= arr[i-2]+arr[i-1];
                    arr[i]= arr[i-2]%1234567+arr[i-1]%1234567;
                }//for
                return arr[n];
            }//if
        }
    }
}
