package week21_2410;

import java.util.*;

public class PR340198_공원 {
    public static void main(String[] args) {
        int[] mats = new int[]{5, 3, 2};
        String[][] park = {{"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};
        solution(mats, park);
    }

    public static int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        for (int k = mats.length - 1; k >= 0; k--) {
            int mat = mats[k];
            //map 순회하면서 각 point별로 돗자리 둘 수 있는지 체크
            for (int i = 0; i < park.length - mat; i++) {
                for (int j = 0; j < park[0].length - mat; j++) {
                    if (checkMap(mat, park, new Point(i, j))) {
                        return mat;
                    }
                }//for_j
            }//for_i
        }//for_mats
        return -1;
    }//solution_method

    static boolean checkMap(int mat, String[][] park, Point p) {
        for (int i = 0; i < mat; i++) {
            for (int j = 0; j < mat; j++) {
                int nr = p.r + i;
                int nc = p.c + j;
                if (nr >= park.length || nc >= park[0].length || !park[nr][nc].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}//class
