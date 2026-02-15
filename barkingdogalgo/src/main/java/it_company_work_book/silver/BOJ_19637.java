package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// IF문 좀 대신 써줘
// 이분탐색
/**
 * 이분탐색인지 몰랐는데 알고리즘 보고 해결
 * 예시로, WEAK 라는 칭호는 10000과 같거나 작은 경우에만 해당하는 칭호
 * 그러므로, powers[i] < point 일 때는 무조건 start = mid+1  로 업데이트
 * powers[i] >= point 인 경우는 result를 업데이트 하고 end = mid-1 로 업데이트
 */
public class BOJ_19637 {

    static String [] names;
    static int [] powers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String [] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        names = new String[N];
        powers = new int[N];

        for(int i=0; i<N; i++){
            s = br.readLine().split(" ");
            String name = s[0];
            int power = Integer.parseInt(s[1]);
            names[i] = name;
            powers[i] = power;
        }

        for(int i=0; i<M; i++){
            int userPower = Integer.parseInt(br.readLine());
            String result = binary(0, N-1, userPower);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static String binary(int start, int end, int target) {
        String result = "";
        while(start<=end){
            int mid = (start+end)/2;

            if(powers[mid] < target){
                start = mid+1;
            }else if(powers[mid] >= target){
                end = mid-1;
                result = names[mid];
            }
        }

        return result;
    }
}
