package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 하노이 탑 이동 순서
public class b_11729_learn {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = (int) Math.pow(2, N) - 1;
        sb.append(count).append("\n");
        hanoi(1,3, N);

        System.out.println(sb);
    }

    private static void hanoi(int a, int b, int n) {
        if(n == 1){
            sb.append(a).append(" ").append(b).append("\n"); //a -> b로 1개 보내기
            return;
        }

        hanoi(a, 6-a-b, n-1); // 1 -> 2로 n-1개 보내기
        sb.append(a).append(" ").append(b).append("\n"); // 1->3 으로 1개 보내기
        hanoi(6-a-b, b, n-1); // 2 -> 3 으로 n-1개 보내기
    }

//    기저 조건이 0 면, depth 가 1 깊어지고 오버헤드가 약간 커지는데, 코드는 더 깔끔해진다.
//    private static void hanoiBaseZero(int a, int b, int n) {
//        if(n == 0){
//            return;
//        }
//
//        hanoi(a, 6-a-b, n-1); // 1 -> 2로 n-1개 보내기
//        sb.append(a).append(" ").append(b).append("\n"); // 1->3 으로 1개 보내기
//        hanoi(6-a-b, b, n-1); // 2 -> 3 으로 n-1개 보내기
//    }
}
