import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        boolean flag = true;
        ArrayList<Integer>tmp = new ArrayList();
        for(int i:ingredient){
            tmp.add(i);
        }
        while(flag){
            flag=false;
            for(int i=0;i<tmp.size();i++){
                if(i+3<tmp.size() && tmp.get(i)==1 && tmp.get(i+1)==2
                        && tmp.get(i+2)==3 && tmp.get(i+3)==1){
                    tmp.remove(i+3);
                    tmp.remove(i+2);
                    tmp.remove(i+1);
                    tmp.remove(i);
                    flag=true;
                    if(i>=2){
                        i-=3;
                    }else{
                        i=-1;
                    }
                    answer++;
                }
            }//for
        }//while
        return answer;
    }//solution
}//class