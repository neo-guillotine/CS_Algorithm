package week19_2408;

import java.util.*;
import java.io.*;

public class PR250136석유시추_240801 {
    class Solution {
        int n, m;
        int[][] move = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        boolean[][] visited;
        char[][] charMap;
        char indexCh;
        Map<Character, Integer> map;

        public int solution(int[][] land) {
            int answer = 0;
            map = new HashMap<>();
            n = land.length;
            m = land[0].length;
            visited = new boolean[n][m];
            charMap = new char[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(charMap[i], '-');
            }
            indexCh = 'a';
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && land[i][j] == 1) {
                        bfs(i, j, land);
                    }
                }
            }
            for (int j = 0; j < m; j++) {
                Set<Character> set = new HashSet<>();
                int num = 0;
                for (int i = 0; i < n; i++) {
                    if (charMap[i][j] != '-') set.add(charMap[i][j]);
                }
                for (char a : set) {
                    num += map.get(a);
                }
                answer = Math.max(answer, num);
            }
            return answer;
        }

        // BFS 메소드
        void bfs(int i, int j, int[][] land) {
            Queue<Point> q = new ArrayDeque<>();
            q.add(new Point(i, j));
            charMap[i][j] = indexCh;
            visited[i][j] = true;
            int cnt = 1;
            while (!q.isEmpty()) {
                Point tmp = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = tmp.r + move[k][0];
                    int nc = tmp.c + move[k][1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && land[nr][nc] == 1) {
                        charMap[nr][nc] = indexCh;
                        visited[nr][nc] = true;
                        cnt++;
                        q.add(new Point(nr, nc));
                    }
                }
            }
            map.put(indexCh++, cnt);
        }

        // Point 클래스
        class Point {
            int r, c;

            Point(int r, int c) {
                this.r = r;
                this.c = c;
            }

            @Override
            public String toString() {
                return this.r + " " + this.c;
            }
        }
    }
}
