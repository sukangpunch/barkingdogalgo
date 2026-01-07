package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 스타트와 링크
public class b_14889 {

    static int N;
    static int result;
    static int [][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            String [] s = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        result = Integer.MAX_VALUE;

        makeTeam(0, N/2);

        System.out.println(result);
    }

    private static void makeTeam(int start, int r) {
        if(r == 0){
            int calSynergy = calculateSynergy();
            result = Math.min(result, calSynergy);
            return;
        }

        for(int i=start; i<N; i++){
            visited[i] = true;
            makeTeam(i+1, r-1);
            visited[i] = false;
        }
    }

    private static int calculateSynergy() {
        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();

        for(int i=0; i<N; i++){
            if(visited[i]){
                aList.add(i);
            }else{
                bList.add(i);
            }
        }

        int a = 0;
        int b = 0;

        for(int i=0; i<aList.size()-1; i++){
            for(int j=i; j<aList.size(); j++){
                a += map[aList.get(i)][aList.get(j)];
                a += map[aList.get(j)][aList.get(i)];
                b += map[bList.get(i)][bList.get(j)];
                b += map[bList.get(j)][bList.get(i)];
            }
        }
        return Math.abs(a-b);
    }
}
