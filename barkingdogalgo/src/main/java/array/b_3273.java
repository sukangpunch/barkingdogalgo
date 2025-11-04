package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 두 수의 합
public class b_3273 {

    static int [] sequence;
    static int n, x;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sequence = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());

        Arrays.sort(sequence);
        findPairOfNum();

        System.out.println(count);
    }

    private static void findPairOfNum() {
        int i=0;
        int j=n-1;

        while(i<j) {
            int nowNum = sequence[i] + sequence[j];
            if(nowNum == x) {
                count++;
                i++;
                j--;
            }else if(nowNum < x){
                i++;
            }else{
                j--;
            }
        }
    }
}
