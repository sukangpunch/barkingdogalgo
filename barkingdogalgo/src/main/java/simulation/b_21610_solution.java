package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 마법사 상어와 비바라기
public class b_21610_solution {

    static int N, M , result;
    static int [][] arr;
    static boolean[][] cloud;
    static int [] dx = {0,-1,-1,-1,0,1,1,1};
    static int [] dy = {-1,-1,0,1,1,1,-0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N][N];
        cloud = new boolean[N][N];
        cloud[N-1][0] = cloud[N-1][1] = cloud[N-2][0] = cloud[N-2][1] = true;

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int d = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);

            simulation(d-1, s % N);
        }

        result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                result += arr[i][j];
            }
        }

        System.out.println(result);
    }

    private static void simulation(int direction, int speed) {
        boolean[][] next = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(cloud[i][j]){
                    int nx = (N + i + dx[direction] * speed) % N;
                    int ny = (N + j + dy[direction] * speed) % N;
                    next[nx][ny] = true;
                    arr[nx][ny]++;
                }
            }
        }
        cloud = next;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(cloud[i][j]){
                    for(int d = 1; d < 8; d+=2){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= N) {continue;}
                        if(arr[nx][ny] > 0){arr[i][j]++;}
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(cloud[i][j]){
                    cloud[i][j] = false;
                }
                else if(arr[i][j] >= 2){
                    arr[i][j] -=2;
                    cloud[i][j] = true;
                }
            }
        }

    }

}
