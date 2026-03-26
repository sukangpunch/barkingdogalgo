package it_company_work_book.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 숫자 고르기
// dfs, 그래프 탐색

/**
 * 시간복잡도: O(N^2)
 * "1부터 N까지 각각의 숫자에 대해 DFS를 돌렸을 때, 자기 자신으로 다시 돌아올 수 있는가?" 이것만 확인
 * 각 인덱스를 기준잡고, 해당 index 부터 자기 자신으로 다시 돌아오는지 확인.
 * 만약 돌아올 수 있다면 resultList에 해당 인덱스의 값 추가.
 * 즉, 1 기준 1 - 3 - 1 로 돌아오게 되고, 3기준 3 - 1 - 3 으로 사이클이 되니 1일때 1 추가, 3일때 3 추가가 된다.
 * 또한 (5,5) 라면, 5 - 5 가 되모르 resultList 에 추가된다.
 */
public class BOJ_2668 {

    static int[] arr;
    static int N;
    static boolean[] visited;
    static List<Integer> resultList; // 정답을 담을 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        resultList = new ArrayList<>();

        // 1번부터 N번까지 각각 "자기 자신으로 돌아오는지" 확인
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i, arr[i]);
        }

        // 결과 출력 (오름차순 정렬)
        Collections.sort(resultList);
        sb.append(resultList.size()).append("\n");
        for (int num : resultList) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }

    // start: 맨 처음 시작한 숫자, now: 현재 방문 중인 숫자
    private static void dfs(int start, int now) {
        // 현재 숫자가 시작 숫자와 같다면 사이클이 완성된 것!
        if (now == start) {
            resultList.add(start); // 정답 리스트에 추가
            return;
        }

        // 아직 방문하지 않은 곳이라면 계속 탐색
        if (!visited[now]) {
            visited[now] = true;
            dfs(start, arr[now]);
        }
    }
}
