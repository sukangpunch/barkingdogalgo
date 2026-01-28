package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 계란으로 계란치기
public class b_16987_retry {

    static class Egg{
        int durability;
        int weight;
        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }

    static int N;
    static Egg[] eggs;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for(int i=0;i<N;i++){
            String []s = br.readLine().split(" ");
            eggs[i] = new Egg(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        simulationEggs(0);
        System.out.println(result);
    }

    private static void simulationEggs(int idx) {
        if(idx == N){
            int count = 0;
            for(int i=0;i<N;i++){
                if(eggs[i].durability <=0){
                    count++;
                }
            }
            result = Math.max(result, count);
            return;
        }

        if(eggs[idx].durability > 0){
            boolean canBreak  = false;
            for(int i=0; i<N; i++){
                if(idx == i)continue;
                if(eggs[i].durability <=0)continue;

                canBreak = true;
                eggs[idx].durability -= eggs[i].weight;
                eggs[i].durability -= eggs[idx].weight;

                simulationEggs(idx+1);

                eggs[idx].durability += eggs[i].weight;
                eggs[i].durability += eggs[idx].weight;
            }

            if(!canBreak) simulationEggs(idx+1);

        }else{
            simulationEggs(idx+1);
        }
    }
}
