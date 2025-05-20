package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_2457_solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            int start = startMonth * 100 + startDay;
            int end = endMonth * 100 + endDay;
            flowers[i] = new Flower(start, end);
        }

        Arrays.sort(flowers, (f1, f2) -> {
            if (f1.start == f2.start) return f2.end - f1.end; // 시작일이 같다면 종료일을 기준으로 내림차순 정렬
            return f1.start - f2.start; // 시작일을 기준으로 오름차순 정렬
        });

        int startDay = 301, endDay = 1201;
        int idx = 0, max = 0, answer = 0;
        while (startDay < endDay) {
            boolean isFind = false; // 꽃을 찾았는지 확인하기 위해
            for (int i = idx; i < N; i++) {
                // 시작일보다 늦게 시작하면 의미없음
                if (flowers[i].start > startDay) break;

                // 가장 오래 피어있는 꽃 찾기
                if (flowers[i].end > max) {
                    max = flowers[i].end; // 가장 늦게 끝나는 종료일 찾기
                    isFind = true;
                    idx = i + 1; // 다음 탐색 시, 현재 인덱스의 다음부터 탐색하도록 (=가지치기)
                }
            }

            if (isFind) { // 사용할 꽃을 찾은 경우
                answer++;
                startDay = max; // 시작일 갱신하기
            } else break;
        }
        if (max < endDay) System.out.println(0);
        else System.out.println(answer);
    }

    static class Flower {
        int start, end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
