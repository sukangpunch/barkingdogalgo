package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_15683 {
    static class CCTV{
        int x;
        int y;
        int type;

        public CCTV(int y, int x, int type){
            this.y = y;
            this.x = x;
            this.type = type;
        }

    }

    static int [] dx = {1, 0, -1, 0};
    static int [] dy = {0, 1, 0, -1};
    static int minBlindSpot = Integer.MAX_VALUE;
    static int N;
    static int M;
    static ArrayList<CCTV> cctvs;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [][] graph = new int [N][M];
        cctvs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(0 < graph[i][j] && graph[i][j] < 6){
                    cctvs.add(new CCTV(i, j, graph[i][j]));
                }
            }
        }

        dfs(0, graph);

        System.out.println(minBlindSpot);
    }

    private static void dfs(int depth, int[][] graph) {
        if(depth == cctvs.size()){
            minBlindSpot = Math.min(minBlindSpot, countBlindSpot(graph));
            return;
        }

        CCTV curr = cctvs.get(depth);

        int rotationCount = 4;

        // 타입이 2라면 좌우/상하 2종류
        if(curr.type == 2){
            rotationCount = 2;
        }
        // 타입이 5라면, 상하좌우(1종류)
        else if(curr.type == 5){
            rotationCount = 1;
        }

        for(int rotation = 0; rotation < rotationCount; rotation++){
            int[][] newGraph = copyGraph(graph);
            simulate(newGraph, curr.y, curr.x, curr.type, rotation);
            dfs(depth + 1, newGraph);
        }
    }

    private static void simulate(int[][] newGraph, int y, int x, int type, int rotation){
        switch (type){
            case 1:
                watch(newGraph, y, x, rotation);
                break;
            case 2:
                watch(newGraph, y, x, rotation);
                watch(newGraph, y, x, rotation + 2);
                break;
            case 3:
                watch(newGraph, y, x, rotation);
                watch(newGraph, y, x, (rotation+1) % 4);
                break;
            case 4:
                watch(newGraph, y, x, rotation);
                watch(newGraph, y, x, (rotation + 1) % 4);
                watch(newGraph, y, x, (rotation + 2) % 4);
                break;
            case 5:
                watch(newGraph, y, x, 0);
                watch(newGraph, y, x, 1);
                watch(newGraph, y, x, 2);
                watch(newGraph, y, x, 3);
                break;
        }
    }

    private static void watch(int[][] graph, int y, int x, int rotation){
        while(true){
            x += dx[rotation];
            y += dy[rotation];

            if(y < 0 || y >= N || x < 0 || x >= M || graph[y][x] == 6) break;

            if(graph[y][x] == 0){
                graph[y][x] = -1;
            }
        }
    }

    private static int[][] copyGraph(int[][] oldGraph){
        int [][] newGraph = new int[N][M];
        for(int i=0; i<N; i++){
            System.arraycopy(oldGraph[i], 0, newGraph[i], 0, M);
        }
        return newGraph;
    }

    private static int countBlindSpot(int[][] graph){
        int count = 0;
        for(int [] row : graph){
            for (int cell : row){
                if(cell == 0)count++;
            }
        }
        return count;
    }

}
