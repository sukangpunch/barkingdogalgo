package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1780_retry {

    static int N;
    static int[][] paper;
    static int [] counts = new int[3];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paperCut(0, 0, N);

        sb.append(counts[0]).append("\n").append(counts[1]).append("\n").append(counts[2]).append("\n");
        System.out.println(sb);

        br.close();
    }

    private static void paperCut(int x, int y, int n) {

        if(n == 1) {
            counts[paper[y][x]+1] += 1;
        }else{
            boolean isPaperAllSameNum = true;
            int preNum=paper[y][x];
            for(int i = y; i < y+n; i++){
                for(int j = x; j < x+n; j++){
                    if(preNum != paper[i][j]){
                        isPaperAllSameNum = false;
                        break;
                    }
                }
            }

            if(isPaperAllSameNum){
                counts[preNum+1] += 1;
                return;
            }

            int size = n / 3;
            paperCut(x, y, size);
            paperCut(x + size, y, size);
            paperCut(x + (size * 2), y, size);
            paperCut(x, y + size, size);
            paperCut(x + size, y + size, size);
            paperCut(x + (size * 2), y + size, size);
            paperCut(x, y + (size * 2), size);
            paperCut(x + size, y + (size * 2), size);
            paperCut(x + (size * 2), y + (size * 2), size);
        }
    }

}
