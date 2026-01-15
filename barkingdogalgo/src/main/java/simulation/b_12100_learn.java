package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2048(Easy)
public class b_12100_learn {
    static int N;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        simulate(0, board);

        System.out.println(result);
    }

    private static void simulate(int depth, int[][] board) {
        if (depth == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result = Math.max(result, board[i][j]);
                }
            }
            return;
        }

        for (int rotation = 0; rotation < 4; rotation++) {
            int[][] copyBoard = copyBoard(board);
            move(copyBoard, rotation);
            simulate(depth + 1, copyBoard);
        }
    }

    private static void move(int[][] board, int rotation) {
        if (rotation == 0) {
            for (int i = 0; i < N; i++) {
                int index = N - 1;
                int block = 0;
                for (int j = N - 1; j >= 0; j--) {
                    if (board[i][j] != 0) {
                        if (block == board[i][j]) {
                            board[i][index + 1] = block * 2;
                            block = 0;
                            board[i][j] = 0;
                        } else {
                            block = board[i][j];
                            board[i][j] = 0;
                            board[i][index] = block;
                            index--;
                        }
                    }
                }
            }
            return;
        }

        if (rotation == 1) {
            for (int i = 0; i < N; i++) {
                int index = 0;
                int block = 0;
                for (int j = 0; j < N; j++) {
                    if (board[j][i] != 0) {
                        if (block == board[j][i]) {
                            board[index - 1][i] = block * 2;
                            block = 0;
                            board[j][i] = 0;
                        } else {
                            block = board[j][i];
                            board[j][i] = 0;
                            board[index][i] = block;
                            index++;
                        }
                    }
                }
            }
            return;
        }

        if (rotation == 2) {
            for (int i = 0; i < N; i++) {
                int index = 0;
                int block = 0;
                for (int j = 0; j < N; j++) {
                    if (board[i][j] != 0) {
                        if (block == board[i][j]) {
                            board[i][index - 1] = block * 2;
                            block = 0;
                            board[i][j] = 0;
                        } else {
                            block = board[i][j];
                            board[i][j] = 0;
                            board[i][index] = block;
                            index++;
                        }
                    }
                }
            }
            return;
        }

        if (rotation == 3) {
            for (int i = 0; i < N; i++) {
                int index = N - 1;
                int block = 0;
                for (int j = N - 1; j >= 0; j--) {
                    if(board[j][i] != 0){
                        if(block == board[j][i]){
                            board[index+1][i] = block*2;
                            block = 0;
                            board[j][i] = 0;
                        }else{
                            block = board[j][i];
                            board[j][i] =0;
                            board[index][i] = block;
                            index--;
                        }
                    }
                }
            }
        }
    }


    private static int[][] copyBoard(int[][] oldBoard) {
        int[][] newBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            System.arraycopy(oldBoard[i], 0, newBoard[i], 0, N);
        }
        return newBoard;
    }
}
