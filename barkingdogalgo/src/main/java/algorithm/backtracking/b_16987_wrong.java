package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b_16987_wrong {

    static class Egg{
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }

    static int N;
    static List<Egg> eggs;
    static List<Egg> tmp;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        eggs = new ArrayList<>();
        tmp = new ArrayList<>();

        if(N == 1){
            System.out.println(0);
            return;
        }

        for(int i=0; i<N; i++){
            String [] s = br.readLine().split(" ");
            int durability = Integer.parseInt(s[0]);
            int weight = Integer.parseInt(s[1]);
            eggs.add(new Egg(durability, weight));
        }

        simulationEgg(0, 0);

        System.out.println(result);
    }

    private static void simulationEgg(int depth, int count) {
        if(depth == N-1 || count >1 && tmp.size() == 1){
            int size = tmp.size();
            result = Math.max(eggs.size() - size, result);
        }

        for(int i=depth; i<N; i++){
            if(tmp.isEmpty()){
                tmp.add(eggs.get(i));
            }else{
                crackEgg(i);
            }
            simulationEgg(depth+1, count++);

        }
    }

    private static void crackEgg(int idx) {
        int size = tmp.size();
        Egg target = tmp.get(0);
        Egg nowEgg = eggs.get(idx);
        if(size == 1){
            int targetDurability = target.durability;
            int nowDurability = nowEgg.durability;

            targetDurability -= nowEgg.weight;
            nowDurability -= target.durability;

            if(nowDurability > 0){
                tmp.add(new Egg(nowDurability, nowEgg.weight));
            }

            if(targetDurability <= 0){
                tmp.remove(0);
            }

        }else{
            int temIdx = 0;
            for(int i=1; i<size; i++){
                if(target.durability > eggs.get(i).durability){
                    target = eggs.get(i);
                    temIdx = i;
                }
            }

            int targetDurability = target.durability;
            int nowDurability = nowEgg.durability;

            targetDurability -= nowEgg.weight;
            nowDurability -= target.durability;

            if(nowDurability > 0){
                tmp.add(new Egg(nowDurability, nowEgg.weight));
            }

            if(targetDurability <= 0){
                tmp.remove(temIdx);
            }
        }
    }

}
