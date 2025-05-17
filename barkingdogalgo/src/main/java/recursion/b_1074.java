package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 답 보기 : x(질문게시판 추가 테스트 케이스 확인)
// 메모리 : 14216 kb
// 시간 : 104 ms
public class b_1074 {
    static long count = 0;
    static int r;
    static int c;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        if (r == 0 && c == 0) {
            System.out.println(result);
            return;
        }

        int powN = (int) Math.pow(2, N);
        find(powN, 0, 0);

        System.out.println(result);
    }

    static void find(int N, int nowX, int nowY) {
        if (N == 2) {
            for (int y = nowY; y < nowY + 2; y++) {
                for (int x = nowX; x < nowX + 2; x++) {
                    count++;
                    if (x == c && y == r) {
                        result = count - 1;
                        return;
                    }
                }
            }
        } else {
            int size = N / 2;
            if (r >= nowY && r < nowY + size && c >= nowX && c < nowX + size) {
                find(size, nowX, nowY);
            } else if (r >= nowY && r < nowY + size && c >= nowX + size) {
                count += (long) size * size;
                find(size, nowX+size, nowY);
            } else if (r >= nowY + size && c >= nowX && c<nowX+size) {
                count += 2L * size * size;
                find(size, nowX, nowY+size);
            } else {
                count += 3L * size * size;
                find(size, nowX + size, nowY + size);
            }
        }
    }
}
