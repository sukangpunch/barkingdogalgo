package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 마법사 상어와 비바라기
public class b_21610 {

    static class Rain {

        int y;
        int x;

        public Rain(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M;
    static int[][] map;
    static List<Rain> rains;
    static int [][] direction = {{-1, -1}, {1,1}, {-1,1},{1,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[N][N];
        rains = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        rains.add(new Rain(N - 1, 0));
        rains.add(new Rain(N - 1, 1));
        rains.add(new Rain(N - 2, 0));
        rains.add(new Rain(N - 2, 1));

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int D = Integer.parseInt(s[0]);
            int S = Integer.parseInt(s[1]);
            magic(D, S);
        }

        int result = calculate();
        System.out.println(result);
    }

    private static int calculate() {
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                count += map[i][j];
            }
        }
        return count;
    }

    private static void magic(int d, int s) {
        for (int i = 0; i < rains.size(); i++) {
            rotationRain(i, d, s);
        }

        for(int i = 0; i<rains.size(); i++) {
            int x = rains.get(i).x;
            int y = rains.get(i).y;
            map[y][x] = map[y][x] + 1;
        }

        waterCopy();

        List<Rain> tmp = new ArrayList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] >= 2 && noDuplicate(i, j)){
                    map[i][j] -= 2;
                    tmp.add(new Rain(i, j));
                }
            }
        }
        rains = tmp;
    }

    private static boolean noDuplicate(int y, int x) {
        for(int i = 0; i<rains.size(); i++) {
            if(rains.get(i).x == x && rains.get(i).y == y){
                return false;
            }
        }
        return true;
    }

    private static void waterCopy() {
        for(int i=0; i<rains.size(); i++) {
            int count = 0;
            int y = rains.get(i).y;
            int x = rains.get(i).x;
            for(int j=0; j<4; j++) {
                int dy = y + direction[j][0];
                int dx = x + direction[j][1];
                if(dy >= 0 && dy < N && dx >= 0 && dx < N && map[dy][dx] != 0) {
                    count++;
                }
            }

            map[y][x] += count;
        }
    }

    private static void rotationRain(int i, int d, int s) {
        Rain rain = rains.get(i);
        switch (d) {
            case 1:
                rain.x = rain.x < s ? N - ((s - rain.x) % N) - 1: rain.x - s;
                break;
            case 2:
                rain.x = rain.x < s ? N - ((s - rain.x) % N)-1 : rain.x - s;
                rain.y = rain.y < s ? N - ((s - rain.y) % N)-1 : rain.y - s;
                break;
            case 3:
                rain.y = rain.y < s ? N - ((s - rain.y) % N)-1 : rain.y - s;
                break;
            case 4:
                rain.x = N <= rain.x + s ? ((s + rain.x) % N) : rain.x + s;
                rain.y = rain.y < s ? N - ((s - rain.y) % N)-1 : rain.y - s;
                break;
            case 5:
                rain.x = N <= rain.x + s ? ((s + rain.x) % N) : rain.x + s;
                break;
            case 6:
                rain.x = N <= rain.x + s ? ((s + rain.x) % N) : rain.x + s;
                rain.y = N <= rain.y + s ? ((s + rain.y) % N) : rain.y + s;
                break;
            case 7:
                rain.y = N <= rain.y + s ? ((s + rain.y) % N) : rain.y + s;
                break;
            case 8:
                rain.x = rain.x < s ? N - ((s - rain.x) % N) -1 : rain.x - s;
                rain.y = N <= rain.y + s ? ((s + rain.y) % N) : rain.y + s;
                break;
        }
    }

}
