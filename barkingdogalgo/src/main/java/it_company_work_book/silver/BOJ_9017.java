package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// 크로스 컨트리
// 구현
/**
 * 엄청 오래걸렸다..
 * 구현 문제임은 알았는데, 계속 더 효율적인 방법을 찾으려고 하다가 뇌정지가 왔다.
 * 효율적인 방법이 바로 생각나지 않으면, 브루트포스를 여러번 하더라도 일단 구현부터하자.
 * Team 클래스를 만들어서, 해당 팀의 랭킹 점수를 들고 있게 한다.
 * 또한 팀 번호가 몇번이 들어올지 모르기 때문에, Map 자료형의 key값으로 팀번호와 팀 명수를 받아 미리 경쟁상대가 아닌 것들을 잘라낸다.
 * 그 다음, 정렬하기 편하게 List<Team> 으로 만들어서 Map 에 들어있는 팀만 리스트로만든다.
 * 그 다음 정렬하고 첫번째 결과가 정답.
 */
public class BOJ_9017 {

    static class Team{
        int num;
        int [] arr;
        int size;

        public Team(int num){
            this.num = num;
            this.arr = new int[6];
            this.size = 0;
        }

        public int getFive(){
            return this.arr[4];
        }

        public int getPoint(){
            return arr[0] + arr[1] + arr[2] + arr[3];
        }

        public void push(int x){
            arr[size++] = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int [] arr = new int[N];
            Map<Integer, Integer> map = new HashMap<>();

            String []s = br.readLine().split(" ");
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(s[i]);
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            // 경쟁이 가능한 팀(6명이 들어온 팀)
            List<Team> teams = new ArrayList<>();
            for(Entry<Integer, Integer> entry: map.entrySet()){
                int team = entry.getKey();
                int cnt = entry.getValue();
                if(cnt >= 6){
                    teams.add(new Team(team));
                }
            }

            // 팀별로 랭킹 처리
            int rank = 1;
            for(int i=0; i<N; i++){
                for(int j=0; j<teams.size(); j++){
                    if(arr[i] == teams.get(j).num){
                        teams.get(j).push(rank);
                        rank += 1;
                    }
                }
            }

            // 1~4등 점수 합이 적은 순, 같으면 5번 점수가 작은 순으로 정렬
            teams.sort((t1, t2)->{
                if(t1.getPoint() == t2.getPoint()){
                    return t1.getFive() - t2.getFive();
                }
                return t1.getPoint() - t2.getPoint();
            });

            // 첫번째 팀이 우승
            sb.append(teams.get(0).num).append("\n");
        }

        System.out.println(sb);
    }
}
