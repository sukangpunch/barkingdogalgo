package study.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 컨베이어 벨트 위의 로봇
// 성능 개선

/**
 * O(L * N), L은 레벨을 뜻함
 * 성능 개선한 방식이다.
 * List + class 를 활용해서 컨베이어 벨트를 구성하지 않고 프리미티브 타입 배열로 해결
 * List 를 사용했던 이유인 rotation 부분도, tmp = n, n-1 -> n, 0 = tmp 방식으로 rotation 구현을 하도록 했다.
 * rotation 과 로봇 이동 중 N-1 에 로봇이 도착하면 무조건 내리도록 하여 요구사항을 충족시켰다.
 */
public class BOJ_20055_improve {

    static int N, K;
    static int[] durability;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        // 벨트 전체의 내구도는 2N, 로봇은 윗줄(N)에만 존재하므로 크기를 다르게 할당
        durability = new int[2 * N];
        robot = new boolean[N];

        s = br.readLine().split(" ");
        for (int i = 0; i < 2 * N; i++) {
            durability[i] = Integer.parseInt(s[i]);
        }

        System.out.println(simulate());
    }

    private static int simulate() {
        int level = 0;
        int zeroCount = 0;

        // 초기에 내구도가 0인 칸이 있을 수 있으므로 미리 카운트
        for (int d : durability) {
            if (d == 0) zeroCount++;
        }

        while (zeroCount < K) {
            level++;

            // 1. 벨트 회전하기 (배열 값 밀기)
            int tempDurability = durability[2 * N - 1];
            for (int i = 2 * N - 1; i > 0; i--) {
                durability[i] = durability[i - 1];
            }
            durability[0] = tempDurability;
            
            // 로봇 회전하기
            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }

            robot[0] = false; // 첫번째 컨베이어 벨트의 값이 다음 컨베이어 벨트에 복사 된 후 0으로 초기화 해준다.
            robot[N - 1] = false; // 내리는 위치(N)에 도달한 로봇 즉시 하차

            // 2. 먼저 올라간 로봇부터 이동시키기
            for (int i = N - 2; i >= 0; i--) {
                // 현재 칸에 로봇이 있고, 다음 칸에 로봇이 없으며, 다음 칸 내구도가 1 이상일 때
                if (robot[i] && !robot[i + 1] && durability[i + 1] > 0) {
                    robot[i] = false;
                    robot[i + 1] = true;
                    durability[i + 1]--;

                    if (durability[i + 1] == 0) {
                        zeroCount++;
                    }
                }
            }
            robot[N - 1] = false; // 이동 후 내리는 위치(N)에 도달한 로봇 즉시 하차

            // 3. 1번 칸에 로봇 올리기
            if (durability[0] > 0) {
                robot[0] = true;
                durability[0]--;

                if (durability[0] == 0) {
                    zeroCount++;
                }
            }
        }

        return level;
    }
}
