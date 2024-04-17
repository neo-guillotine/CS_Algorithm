package week11_2404;

public class P250125이웃한칸_240417 {
    class Solution {
        public int solution(String[][] board, int h, int w) {
            int answer = 0;
            int[][]move= {{0,1},{1,0},{0,-1},{-1,0}};
            int l = board.length;
            String target=board[h][w];
            for(int i=0;i<4;i++){
                int nr = h+move[i][0];
                int nc = w+move[i][1];
                if(nr>=0 && nr<l && nc>=0 && nc<l && board[nr][nc].equals(target)){
                    answer++;
                }//if
            }//for
            return answer;
        }
    }
}
