package week20_2410;

import java.util.*;
import java.io.*;

public class BJ15686_치킨배달 {

  static int n, m, map[][], answer;
  static List<Point> house, chicken;
  static boolean[] pick;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][n];
    house = new ArrayList<>();
    chicken = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        switch (map[i][j]) {
          case 1:
            house.add(new Point(i, j));
            break;
          case 2:
            chicken.add(new Point(i, j));
            break;
        }
      }
    }
    pick = new boolean[chicken.size()];

    answer = Integer.MAX_VALUE;
    solve(0, 0);
    System.out.println(answer);
  }//main

  static void solve(int start, int cnt) {
    if (cnt == m) {
      //치킨집과 집 사이의 최단 거리구하고 return;
      int distance = 0;
      for (int i = 0; i < house.size(); i++) {
        int tmp = Integer.MAX_VALUE;
        for (int j = 0; j < chicken.size(); j++) {
          if (pick[j]) {
            tmp = Math.min(tmp, getDistance(house.get(i), chicken.get(j)));
          }
        }
        distance += tmp;
      }
      answer = Math.min(answer, distance);
      return;
    }

    for (int i = start; i < chicken.size(); i++) {
      pick[i] = true;
      solve(i + 1, cnt + 1);
      pick[i] = false;
    }
  }

  static int getDistance(Point a, Point b) {
    return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
  }

  static class Point {

    int r, c;

    public Point(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}//class
