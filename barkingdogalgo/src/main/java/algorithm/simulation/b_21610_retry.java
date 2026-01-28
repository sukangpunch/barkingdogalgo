package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 마법사 상어와 비바라기
public class b_21610_retry {

    static boolean [][]cloud;
    static int [][] map;
    static int N, M;

    static int []dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int []dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        cloud = new boolean[N][N];
        map = new int[N][N];

        cloud[N-1][0] = true;
        cloud[N-1][1] = true;
        cloud[N-2][0] = true;
        cloud[N-2][1] = true;

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int d = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);

            simulationMagic(d-1, s % N);
        }

        int result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                result += map[i][j];
            }
        }

        System.out.println(result);
    }

    private static void simulationMagic(int direction, int size) {
        boolean [][] tmp = new boolean[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(cloud[i][j]){
                    int y = (N + i + dy[direction] * size) % N;
                    int x = (N + j + dx[direction] * size) % N;
                    tmp[y][x] = true;
                    map[y][x] += 1;
                }
            }
        }

        cloud = tmp;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(tmp[i][j]){
                    for(int k = 1; k < 8; k += 2){
                        int y = i + dy[k];
                        int x = j + dx[k];

                        if(y>=0 && y<N && x>=0 && x<N && map[y][x] > 0){
                            map[i][j] +=1;
                        }
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(cloud[i][j]){
                    cloud[i][j] = false;
                }else if(map[i][j] >= 2){
                    cloud[i][j] = true;
                    map[i][j] -= 2;
                }
            }
        }
    }

}
