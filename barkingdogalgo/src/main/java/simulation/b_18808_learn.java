package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 스티커 붙이기
// 배열 돌리기 문제는 직접 그려서 돌려본 다음 규칙 찾아보기
public class b_18808_learn {

    static int [][] note;
    static int N;
    static int M;
    static int R;
    static int C;
    static int [][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        int K = Integer.parseInt(s[2]);
        note = new int[N][M];

        for(int k=0; k<K; k++){
            paper = new int[11][11];
            s = br.readLine().split(" ");

            R = Integer.parseInt(s[0]);
            C = Integer.parseInt(s[1]);
            for(int i=0; i<R; i++){
                s = br.readLine().split(" ");
                for(int j=0; j<C; j++){
                    paper[i][j] = Integer.parseInt(s[j]);
                }
            }

            checkAvailable();
        }

        int cnt = 0;
        for(int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                cnt += note[i][j];
            }
        }
        System.out.println(cnt);
    }

    private static void checkAvailable() {
        for(int rotation = 0; rotation < 4; rotation++){
            boolean isPaste = false;
            for(int y = 0; y <= N-R; y++){
                if(isPaste) break;

                for (int x = 0; x<=M-C; x++){
                    if(pastAble(y,x)){
                        isPaste = true;
                        break;
                    }
                }
            }
            if(isPaste) break;
            rotate();
        }
    }

    private static boolean pastAble(int y, int x){
        // y, x 좌표를 기준으로 노트에 스티커를 붙일 수 있는지 파악
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(note[y+i][x+j] == 1 && paper[i][j] == 1){
                    return false;
                }
            }
        }

        // 노트에 스티커를 붙일 수 있다면, 값을 채운다.
        for(int i=0; i<R; i++){
            for (int j= 0; j<C; j++){
                if(paper[i][j] == 1){
                    note[y+i][x+j] = 1;
                }
            }
        }

        return true;
    }

    private static void rotate(){
        int [][]tmp = new int[11][11];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                tmp[i][j] = paper[i][j];
            }
        }

        paper = new int[11][11];

        for(int i=0; i<C; i++){
            for (int j=0; j<R; j++){
                paper[i][j] = tmp[R-1-j][i];
            }
        }

        int temp = R;
        R = C;
        C = temp;
    }
}
