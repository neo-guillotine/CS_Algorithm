package week18_2407;
import java.util.*;
public class BJ5212지구온난화_240701 {
    //updatedMap 새로 그리기. 한줄이 다 .이면 없애기
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        int[][]check = {{-1,0},{0,1},{1,0},{0,-1}};
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] map = new char[r+2][c+2];
        char[][] updated = new char[r+2][c+2];
        int minR=Integer.MAX_VALUE;
        int minC=Integer.MAX_VALUE;
        int maxR=Integer.MIN_VALUE;
        int maxC=Integer.MIN_VALUE;

        for (int i = 0; i < r+2; i++) {
            Arrays.fill(map[i],'.');
            Arrays.fill(updated[i],'.');
        }
        for(int i=0;i<r;i++){
            String line = sc.next();
            for (int j = 0; j < c; j++) {
                char tmpChar = line.charAt(j);
                map[i+1][j+1]=tmpChar;
                updated[i+1][j+1]=tmpChar;
            }
        }

        for (int i = 0; i < r+2; i++) {
            for (int j = 0; j < c+2; j++) {
                if(map[i][j]=='.')continue;
                int count=0;
                for (int k = 0; k < 4; k++) {
                    int nr = i+check[k][0];
                    int nc = j+check[k][1];
                    if(nr>=0 && nr<r+2 && nc>=0 && nc<c+2 && map[nr][nc]=='.'){
                        count++;
                    }
                }
                if(count>=3){
                    updated[i][j] = '.';
                }
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if(updated[i][j]=='X'){
                    maxR = Math.max(i,maxR);
                    minR = Math.min(i,minR);
                    maxC = Math.max(j,maxC);
                    minC = Math.min(j,minC);
                }
            }
        }

        for (int i = 0; i <maxR-minR+1; i++) {
            for (int j = 0; j <maxC-minC+1; j++) {
                sb.append(updated[i+minR][j+minC]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }//main
}//class