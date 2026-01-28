package algorithm.math;

import java.util.Scanner;


// 답 보기 : o
// 메모리 : 18160 kb
// 시간 : 192 ms
public class b_1256_solution {
    // dp[a][z] 에는 남은 a개의 문자와 z개의 문자로 만들 수 있는 모든 문자열의 개수
    static double[][] dp= new double[101][101];
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);

        //N은 a개수, M은 z개수, K번째 문자열을 구해야함.
        //N, M은 100이하, K는 10억 이하의 수
        int N= scan.nextInt();
        int M= scan.nextInt();
        double K= scan.nextDouble();

        if(check(N, M)<K) {
            System.out.println("-1");
        }else {
            makeS(N, M, K);
            System.out.println(sb.toString());
        }
    }//main

    //개수 구하는 함수
    public static double check(int a, int z) {
        if(a==0||z==0) return 1; // 남은 문자가 한종류면
        if(dp[a][z]!=0) return dp[a][z]; // 이미 계산된 부분이면 반환

        // 조합 공식
        return dp[a][z]= Double.min(check(a-1, z)+check(a, z-1), 1000000001);
    }

    //문자열 만드는 함수
    public static void makeS(int a, int z, double k) {
        // a 또는 z가 바닥났을 때 남은 문자 모두 붙이기
        if(a==0) {
            for(int i=0; i<z; i++)
                sb.append("z");
            return;
        }
        if(z==0) {
            for(int i=0; i<a; i++)
                sb.append("a");
            return;
        }

        // 남은 x개의 a와 y개의 z를 조합하여 만들 수 있는 모든 문자열의 개수
        // 첫 글자를 a로 고정했을 때, 뒤에 (a-1) 개와 z개 를 조합해서 만든 문자열의 수
        double check= check(a-1, z);
        if(k>check) { // k가 a블록을 넘어섰는지 확인  해당 조건이 true면 문자열이 a로 시자갛는 모든 문자열을 건너뛴 뒤에 온다.
            sb.append("z");
            makeS(a, z-1, k-check); // 즉 첫 글자는 z가 되어야하기에 z-1 로 처리한다. 그리고 남은 순번은 k - cntAFirst 로 건너뛴 만큼 차감
        }else { // k 번째 문자열은 처음에 a가 붙은 구간 안에 있다. 따라서 a를 append하고  남은 순서는 (a-1,z) 상태에서 같은 k번째를 찾기 위해 재귀 호출
            sb.append("a");
            makeS(a-1, z, k);
        }
    }
}
