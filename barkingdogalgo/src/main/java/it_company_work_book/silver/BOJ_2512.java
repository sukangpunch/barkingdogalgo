package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 예산
public class BOJ_2512 {

    static int N;
    static int[] requestBudget;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        requestBudget = new int[N];
        String[] s = br.readLine().split(" ");

        int max = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            requestBudget[i] = Integer.parseInt(s[i]);
            if(max < requestBudget[i]){
                max = requestBudget[i];
            }
            count += requestBudget[i];
        }

        M = Integer.parseInt(br.readLine());

        if(count <= M){
            System.out.println(max);
            return;
        }

        int result = binary(0, M);
        System.out.println(result);
    }

    private static int binary(int start, int end) {
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (check(mid)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    private static boolean check(int mid) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (requestBudget[i] <= mid) {
                count += requestBudget[i];
            } else {
                count += mid;
            }
        }

        return M >= count;
    }
}
