package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_15903 {

    static long [] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        cards = new long[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        long gameResult = game(n, m);
        System.out.println(gameResult);
    }

    private static long game(int n, int m) {
        for(int i = 0; i < m; i++){
            long sum = cards[0] + cards[1];
            cards[0] = sum;
            cards[1] = sum;
            Arrays.sort(cards);
        }

        long count = 0;

        for(int i = 0; i < n; i++){
            count += cards[i];
        }

        return count;
    }
}
