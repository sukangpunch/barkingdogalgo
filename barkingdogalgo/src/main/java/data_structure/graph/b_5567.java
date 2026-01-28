package data_structure.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b_5567 {
    static int [][] map;
    static boolean [] invited;
    static int n;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        invited = new boolean[n+1];
        invited[1] = true;
        for(int i = 0; i < m; i++){
            String [] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            map[a][b] = 1;
            map[b][a] = 1;
        }

        track(1);

        System.out.println(count);

    }

    private static void track(int me) {
        Queue<Integer> friends = new LinkedList<>();

        for(int i=2 ; i<=n; i++){
            if(map[me][i] == 1){
                invited[i] = true;
                count++;
                friends.add(i);
            }
        }

        for(int friend : friends){
            for(int i=1; i<=n; i++){
                if(friend == i)continue;

                if(map[friend][i] == 1 && !invited[i]){
                    count++;
                    invited[i] = true;
                }
            }
        }

    }
}
