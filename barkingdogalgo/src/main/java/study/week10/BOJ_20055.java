package study.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

// 컨베이어 벨트 위의 로봇
// 구현

/**
 * 시간복잡도 : O()
 * 그냥 빡 구현 문제이다.
 * 컨베이어 벨트의 칸에 해당하는 값을 List에 저장한다.
 * 1. 컨베이어 벨트를 회전시킨다.(리스트의 마지막 컨베이어 벨트를 가장 처음으로 이동)
 *    1.1 이 때, N 위치에 로봇이 있다면 로봇을 내린다(robot 필드를 false 로 수정)
 * 2. 로봇을 이동 시킨다, 먼저 올라온 로봇부터 처리하기위해 N-1부터 1까지 탐색
 *    2.1 만약 로봇으 이동시켰는데 N 위치에 로봇이 오게 된다면 바로 내린다.(robot 필드 fasle)
 * 3. 1번 위치에 로봇을 올린다(만약 로봇이 있거나 내구도가 0이라면 안올림)
 * 위 연산을 반복하면 된다. cnt 비교 연산을 cnt >= k 로 두었는데, 어짜피 내구도가 0인 블락이 k개 일때의 "레벨" 만 알면 되기 때문이다.
 */
public class BOJ_20055 {

    static class Block {

        int durability;
        int num;
        boolean robot;

        public Block(int durability, int num) {
            this.durability = durability;
            this.num = num;
            this.robot = false;
        }
    }

    static int N;
    static int K;
    static List<Block> blocks;
    static int level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        blocks = new LinkedList<>();
        s = br.readLine().split(" ");

        for (int i = 1; i <= 2 * N; i++) {
            int durability = Integer.parseInt(s[i - 1]);
            blocks.add(new Block(durability, i));
        }

        simulate();

        System.out.println(level);
    }

    private static void simulate() {
        level = 1;
        int cnt = 0;
        while(true){
            // 1. 회전하기
            blocks.add(0, blocks.remove(2*N-1));
            if(blocks.get(N-1).robot){
                blocks.get(N-1).robot = false;
            }

            // 2. 올라가 있는 로봇 이동시키기
            for(int i=N-1; i>0; i--){
                if(blocks.get(i-1).robot && !blocks.get(i).robot && blocks.get(i).durability > 0){
                    blocks.get(i-1).robot = false;
                    blocks.get(i).robot = true;
                    blocks.get(i).durability -= 1;

                    if(blocks.get(i).durability == 0){
                        cnt++;
                    }

                    if(i==N-1){
                        blocks.get(i).robot = false;
                    }
                }
            }

            // 3. 1번에 로봇 올리기
            Block block = blocks.get(0);
            if(!block.robot && block.durability > 0){
                block.robot = true;
                block.durability -= 1;

                if(block.durability == 0){
                    cnt++;
                }
            }

            if(cnt >= K){
                return;
            }

            level += 1;
        }
    }
}
