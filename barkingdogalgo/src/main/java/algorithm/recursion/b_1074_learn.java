package algorithm.recursion;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Z
public class b_1074_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);

        int orderNumber = findOrderNumber(N, r, c);
        System.out.println(orderNumber);
    }

    // 최소 조건까지 내려가서(2x2 부분에서의 좌표 순서 - 0~3)
    // 건너 뛴 사분면의 총 count 들을 더해가는 식으로 처리
    private static int findOrderNumber(int n, int r, int c) {
        if(n == 0) return 0;

        int half = (int) Math.pow(2, n-1);

        if(r < n && c < n) return findOrderNumber(n-1, r, c); // 현재 N 값에서 1사분면 일 때 
        if(r < half && c >= half) return half*half + findOrderNumber(n-1, r, c-half); // 2사분면 일 때
        if(r >= half && c < half) return 2*half*half + findOrderNumber(n-1, r-half, c); // 3 사분면 일 떄
        return 3*half*half + findOrderNumber(n-1, r-half, c-half); // 4사분면 일 떄
    }
}
