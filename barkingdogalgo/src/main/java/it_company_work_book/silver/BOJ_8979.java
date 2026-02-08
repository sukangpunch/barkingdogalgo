package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 올림픽
// 구현, 정렬

/**
 * 정렬 후 랭크 문제이다.
 * 자기보다 더 높은 점수의 나라 개수만큼 등수가 정해진다 보면 된다.
 * 즉, 1, 2, 2 다음에 동점이 아니라면 4등이 다음 등수이다.
 * 2중 포문을 돌지 않기 위해, Comparable로 올바르게 정렬을 한 다음
 * 1중 포문 속에서 이전 값과 현재 값만 비교하도록 한다.
 * 이전 값보다 같으면 공동 등수, 이전 값보다 작으면 다음등수
 * 만약 공동 등수가 나왔다면 그 뒷 나라는 자기보다 크거나 같은 나라가 최소 1개 이상인 것이 자명하니 bias 값을 증가시켜서 활용한다.
 */
public class BOJ_8979 {

    static class Country implements Comparable<Country> {

        int num;
        int gold;
        int silver;
        int bronze;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.bronze - this.bronze;
                } else {
                    return o.silver - this.silver;
                }
            } else {
                return o.gold - this.gold;
            }
        }
    }

    static List<Country> countries;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        countries = new ArrayList<>();
        int[] ranks = new int[N + 1];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            int num = Integer.parseInt(s[0]);
            int gold = Integer.parseInt(s[1]);
            int silver = Integer.parseInt(s[2]);
            int bronze = Integer.parseInt(s[3]);
            countries.add(new Country(num, gold, silver, bronze));
        }

        countries.sort(Country::compareTo);

        int rank = 1;
        int bias = 1;
        Country pre = countries.get(0);
        ranks[pre.num] = rank;

        for (int i = 1; i < N; i++) {
            Country now = countries.get(i);
            if (now.gold == pre.gold &&
                    now.silver == pre.silver &&
                    now.bronze == pre.bronze) {
                ranks[now.num] = rank;
                bias += 1;
            }else{
                rank += bias;
                ranks[now.num] = rank;
                bias = 1;
            }
            pre = now;
        }
        System.out.println(ranks[K]);
    }
}
