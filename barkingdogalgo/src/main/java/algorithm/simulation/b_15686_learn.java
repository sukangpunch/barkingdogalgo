package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b_15686_learn {

    static class Point {

        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N;
    static int M;
    static List<Point> houses;
    static List<Point> chickens;
    static List<Point> selectChicken;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        selectChicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(s[j]);
                if (n == 1) {
                    houses.add(new Point(i, j));
                } else if (n == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        simulate(0, 0);

        System.out.println(result);
    }

    private static void simulate(int depth, int start) {
        if (depth == M) {
            int dist = 0;
            for (int i = 0; i < houses.size(); i++) {
                dist += calDistance(i);
            }
            result = Math.min(dist, result);
            return;
        }

        for (int i = start; i < chickens.size(); i++) { // 만약 i 를 depth 로 초기화 하면, 1, 2, 3.. 을 구하고 다시 2, 1, 2, 3.... 중복되는 결과를 낼 수 있어서 start 값을 두었다.
            selectChicken.add(chickens.get(i));
            simulate(depth + 1, i+1);
            selectChicken.remove(selectChicken.size() - 1);
        }
    }

    private static int calDistance(int idx) {
        Point house = houses.get(idx);
        int dist = Integer.MAX_VALUE;

        for (int i = 0; i < selectChicken.size(); i++) {
            Point chicken = selectChicken.get(i);
            int cal = Math.abs(house.y - chicken.y) + Math.abs(house.x - chicken.x);
            if (dist > cal) {
                dist = cal;
            }
        }
        return dist;
    }

}
