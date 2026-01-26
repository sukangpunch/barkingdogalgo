package stduy.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1477 {

    static int N;
    static int M;
    static int len;

    static int [] rests;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        len = Integer.parseInt(s[2]);

        s = br.readLine().split(" ");
        rests = new int[N+2];
        rests[0] = len;
        for(int i=1; i<=N; i++){
            rests[i] = Integer.parseInt(s[i-1]);
        }

        Arrays.sort(rests);

        int best = findBest();
        System.out.println(best);
    }

    private static int findBest() {
        int st = 1;
        int en = len-1;

        int mid = 0;
        int ret = 0;
        while(st <= en){
            mid = (st+en)/2;
            if(check(mid)){
                st = mid+1;
            }else{
                ret = mid;
                en = mid-1;
            }
        }
        return ret;
    }

    private static boolean check(int mid) {
        int cnt = 0;
        for(int i=1; i<rests.length; i++){
            int dist = rests[i] - rests[i-1];
            cnt += dist/mid;
            if(dist % mid == 0){
                cnt--;
            }
        }
        return cnt > M;
    }
}
