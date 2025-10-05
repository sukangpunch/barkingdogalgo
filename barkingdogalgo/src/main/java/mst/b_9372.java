package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_9372 {

    static int [] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int resultCount = visitedCountries(br, 0);
            sb.append(resultCount).append("\n");
        }

        System.out.println(sb);
    }

    private static int visitedCountries(BufferedReader br, int count) throws IOException {
        String [] input = br.readLine().split(" ");

        int countries = Integer.parseInt(input[0]);
        int planes = Integer.parseInt(input[1]);

        parents = new int[countries+1];

        for(int i=1; i <= countries; i++){
            parents[i] = i;
        }

        for(int j = 0; j < planes; j++){
            input = br.readLine().split(" ");
            int startCountry = Integer.parseInt(input[0]);
            int endCountry = Integer.parseInt(input[1]);

            if(find(startCountry) != find(endCountry)){
                count++;
                union(startCountry, endCountry);
            }
        }

        return count;
    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        parents[Math.max(rootA, rootB)] = Math.min(rootA, rootB);
    }

    static int find(int x){
        if(parents[x] != x){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
}
