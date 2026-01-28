package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 계란으로 계란치기
// 재풀이 바람
public class b_16987_solution {
    static class Egg{
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }

    static int N;
    static boolean [] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Egg[] eggs = new Egg[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            String [] s = br.readLine().split(" ");
            int d = Integer.parseInt(s[0]);
            int w = Integer.parseInt(s[1]);
            eggs[i] = new Egg(d, w);
        }

        simulation(0, eggs);

        System.out.println(result);
    }

    private static void simulation(int idx, Egg[] eggs) {
        if(idx == N){ // 종료조건 : 맨 오른쪽 계란인지
            int sum = 0;
            for(int i=0; i<eggs.length; i++){
                if(eggs[i].durability <= 0){
                    sum++;
                }
            }
            result = Math.max(result, sum);
            return;
        }

        if(eggs[idx].durability > 0){ // 현재 손에 든 계란이 깨지지 않았는지
            boolean next = false; // 현재 계란으로 칠 수 있는 다른 계란이 존재하는 가를 추적한다.
            for(int i= 0; i<N; i++){

                if(idx == i)continue;  // 손에 든 계란과 같은 idx 인가?
                if(eggs[i].durability <= 0)continue;  // 다른 계란이 깨져 있는가?

                next = true;
                eggs[idx].durability -= eggs[i].weight; // 부딪히기
                eggs[i].durability -= eggs[idx].weight;
                simulation(idx+1, eggs);

                eggs[idx].durability += eggs[i].weight; // 원복
                eggs[i].durability += eggs[idx].weight;
            }

            if(!next) simulation(idx+1, eggs); // 칠 계란이 없으면 다음으로

        }else{
            simulation(idx+1, eggs);
        }
    }
}
