package algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 답 보기 : x(유클리드 호제법 개념 확인)
// 메모리 : 14124 kb
// 시간 : 100 ms
public class b_3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int [] rings = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            rings[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<N; i++){
            int child = rings[0];
            int parent = rings[i];

            int euclid = euclid(child, parent);
            sb.append(child/euclid).append("/").append(parent/euclid).append("\n");
        }

        System.out.println(sb);
    }

    static int euclid(int a , int b){
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        if(a%b==0){
            return b;
        }else{
            return euclid(b, a%b);
        }
    }
}
