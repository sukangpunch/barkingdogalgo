package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 먹을 것인가 먹힐 것인가
public class b_7795 {

    static int [] arrA;
    static int [] arrB;
    static int cnt;
    static int A;
    static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            String [] s = br.readLine().split(" ");
            A = Integer.parseInt(s[0]);
            B = Integer.parseInt(s[1]);
            arrA = new int[A];
            arrB = new int[B];

            String [] inputA = br.readLine().split(" ");
            String [] inputB = br.readLine().split(" ");

            for(int a = 0; a<A; a++){
                int n = Integer.parseInt(inputA[a]);
                arrA[a] = n;
            }

            for(int b = 0; b<B; b++){
                int n = Integer.parseInt(inputB[b]);
                arrB[b] = n;
            }

            Arrays.sort(arrB);
            findCount();
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void findCount() {
        cnt = 0;

        for(int a = 0; a<A; a++){
            int start = 0;
            int end = B-1;
            int idx = 0;

            while(start <= end){
                int mid = (start + end)/2;
                if(arrB[mid] < arrA[a]){
                    start = mid + 1;
                    idx = mid + 1;
                } else{
                    end = mid - 1;
                }
            }
            cnt += idx;
        }


    }
}
