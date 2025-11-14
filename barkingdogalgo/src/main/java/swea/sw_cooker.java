package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 요리사
public class sw_cooker {
    static int N;
    static int [][] map;
    static int min;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testNum = Integer.parseInt(br.readLine());
        for(int test = 1; test <= testNum; test++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i=0; i<N; i++) {
                String [] temp = br.readLine().split(" ");
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }

            min = Integer.MAX_VALUE;
            visited = new boolean[N];

            comb(0,N, N/2);
            sb.append("#").append(test).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static void comb(int start, int N, int r) {
        if(r==0){
            int ret = solve();
            min = Math.min(min, ret);
            return;
        }

        for(int i=start; i<N; i++) {
            visited[i] = true;
            comb(i+1, N, r-1);
            visited[i] = false;
        }
    }

    private static int solve() {
        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            if(visited[i]){
                aList.add(i);
            }else{
                bList.add(i);
            }
        }

        int a=0;
        int b=0;

        for(int i=0; i<aList.size()-1; i++) {
            for(int j=i; j<aList.size(); j++) {
                a += map[aList.get(i)][aList.get(j)];
                a += map[aList.get(j)][aList.get(i)];
                b += map[bList.get(i)][bList.get(j)];
                b += map[bList.get(j)][bList.get(i)];
            }
        }

        return Math.abs(a-b);
    }
}
