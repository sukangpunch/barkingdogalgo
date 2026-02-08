package it_company_work_book.silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 덩치
// 구현, 브루트포스

/**
 * 처음에는 compareTo 정렬로 구현 하려 했지만,
 * 대칭성, 추이성 등등 전체 순서 관계가 맞아 떨어져야 하는데 문제의 조건은 그렇지 않다.
 * 수치적으로 차이가 나도, 키와 몸무게 둘다 대상보다 커야 우선 순위이고, 나머지는 동일 순서로 본다.
 * 그래서 브루트포스로 구현하니 통과
 */
public class BOJ_7568 {
    static class People{
        int weight;
        int height;

        public People(int weight, int height){
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<People> peoples = new ArrayList<>();
        for(int i=0; i<N; i++){
            String []s = br.readLine().split(" ");
            int weight = Integer.parseInt(s[0]);
            int height = Integer.parseInt(s[1]);

            peoples.add(new People(weight, height));
        }

        for(int i=0; i<N; i++){
            People people = peoples.get(i);
            int rank = 1;
            for(int j=0; j<N; j++){
                if(i==j) continue;
                People compare = peoples.get(j);
                if(people.height < compare.height && people.weight < compare.weight){
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }

        System.out.println(sb);
    }
}
