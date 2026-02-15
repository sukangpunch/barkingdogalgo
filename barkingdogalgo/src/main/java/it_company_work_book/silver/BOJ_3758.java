package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// KCPC
// 구현, 정렬
/**
 * 동시 순위 고려를 안해도 되서, 구현 자체는 어렵지 않은 문제.
 * 하지만 조건이 꽤 많아서 수정이 많았다.
 * 팀별 등수를 세우는데, 문제를 재풀이 할 수 있음.
 * 1. 토탈 점수 기반 내림차순.
 * 2. 점수가 같다면 제출 횟수 별 오름차순
 * 3. 제출 횟수가 같다면, 제출 시간 별 오름차순
 * + 한 문제를 여러번 제출 했을 시, 문제 풀이 count, 시간은 증가시키고 점수는 제일 높은 점수를 남긴다.
 * 이를 다 고려하면서 정렬하고 랭킹을 매기면 된다.
 */
public class BOJ_3758 {
    static class Team{
        int id;
        int totalPoint;
        int solvedCount;
        int lastSolveTime;
        int [] problemPoints;

        public Team(int id, int size){
            this.id = id;
            this.totalPoint = 0;
            this.solvedCount = 0;
            this.lastSolveTime = 0;
            problemPoints = new int[size+1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            String []s = br.readLine().split(" ");
            List<Team> teams = new ArrayList<>();

            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int myId = Integer.parseInt(s[2]);
            int m = Integer.parseInt(s[3]);

            for(int i=1; i<=n; i++){
                teams.add(new Team(i, k));
            }

            int time = 0;
            for(int i=0; i<m; i++){
                s = br.readLine().split(" ");
                int id = Integer.parseInt(s[0]);
                int problemNum = Integer.parseInt(s[1]);
                int point = Integer.parseInt(s[2]);
                time++;
                Team now = teams.get(id-1);
                if(now.problemPoints[problemNum] !=0){
                    if(now.problemPoints[problemNum] < point){
                        now.totalPoint -= now.problemPoints[problemNum];
                        now.problemPoints[problemNum] = point;
                        now.totalPoint += now.problemPoints[problemNum];
                    }
                }else{
                    now.totalPoint += point;
                    now.problemPoints[problemNum] = point;
                }

                now.solvedCount++;
                now.lastSolveTime = time;
            }

            teams.sort((t1, t2) ->{
                if(t1.totalPoint == t2.totalPoint){
                    if(t1.solvedCount == t2.solvedCount){
                        return t1.lastSolveTime - t2.lastSolveTime;
                    }else{
                        return t1.solvedCount - t2.solvedCount;
                    }
                }
                return t2.totalPoint - t1.totalPoint;
            });

            int rank = 1;
            for(int i=0; i<n; i++){
                if(teams.get(i).id == myId){
                    sb.append(rank).append("\n");
                    break;
                }
                rank++;
            }
        }

        System.out.println(sb);
    }
}
