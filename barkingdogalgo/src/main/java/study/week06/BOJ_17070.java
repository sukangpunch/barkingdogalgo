package study.week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 파이프 옮기기
// dp
/**
 * 방금 전에 해당 문제와 거의 동일한 17484 문제를 풀었어서 바로 풀 수 있었다.
 * 3차원 dp 배열을 두고 0-가로, 1-세로, 2-대각선 인 경우의 수들을 관리하였다.
 * 가로부터 시작하므로, 시작점 가로 상황에서 가능한 경우의 수로 dp 값을 초기화
 * 모든 좌표를 확인하되, 반복문 안에서, 가로, 세로, 대각선인 상황 모두를 고려하는 반복문 하나를 더 활용
 * 가로 일때는 오른쪽, 대각선 이동이 가능하므로, 바뀌는 상태에 따라서 값을 더해준다.
 * 위처럼 각 파이프 상태별로 가능한 연산을 해주면 마지막에 상태별로 가능한 경우의 수들이 남고, 이를 더해주면 된다.
 */
public class BOJ_17070 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [][] map = new int[N][N];
        int [][][] dp = new int[N][N][3];

        for(int i=0; i<N; i++){
            String [] s = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        if(map[0][2] == 1){
            System.out.println(0);
            return;
        }else if(map[1][1] == 1 || map[1][2] == 1){
            dp[0][2][0] = 1;
        }else{
            dp[0][2][0] = 1;
            dp[1][2][2] = 1;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<3; k++){
                    if(dp[i][j][k] == 0){
                        continue;
                    }else{
                        if(k==0){
                            if(j+1 < N && map[i][j+1] !=1){
                                dp[i][j+1][0] = dp[i][j+1][0] + dp[i][j][0];
                            }

                            if(j+1 < N && i+1 < N &&
                                    map[i][j+1] != 1 && map[i+1][j+1] != 1 && map[i+1][j] !=1){
                                dp[i+1][j+1][2] = dp[i+1][j+1][2] + dp[i][j][0];
                            }
                        }else if(k==1){
                            if(i+1 < N && map[i+1][j] != 1){
                                dp[i+1][j][1] = dp[i+1][j][1] + dp[i][j][1] ;
                            }

                            if(i+1 < N && j+1 < N &&
                                    map[i+1][j] != 1 && map[i+1][j+1] !=1 && map[i][j+1] != 1){
                                dp[i+1][j+1][2] = dp[i+1][j+1][2] + dp[i][j][1];
                            }
                        }else{
                            if(j+1 < N && map[i][j+1] != 1){
                                dp[i][j+1][0] = dp[i][j+1][0] + dp[i][j][2];
                            }

                            if(i+1 < N && map[i+1][j] != 1){
                                dp[i+1][j][1] = dp[i+1][j][1] + dp[i][j][2];
                            }

                            if(i+1 < N && j+1 < N &&
                                    map[i+1][j] != 1 && map[i+1][j+1] !=1 && map[i][j+1] != 1){
                                dp[i+1][j+1][2] = dp[i+1][j+1][2] + dp[i][j][2];
                            }
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<3; i++){
            cnt += dp[N-1][N-1][i];
        }
        System.out.println(cnt);
    }
}
