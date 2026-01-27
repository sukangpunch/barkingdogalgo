package study.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 신입사원
public class BOJ_1946 {

    static class Candidate {
        int document;
        int interview;
        boolean check;

        public Candidate(int document, int interview){
            this.document = document;
            this.interview = interview;
            this.check = true;
        }

        public static final Comparator<Candidate> BY_DOCUMENT =
                Comparator.comparingInt(c -> c.document);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            List<Candidate> candidates = new ArrayList<>();

            for(int i=0; i<N; i++){
                String []s = br.readLine().split(" ");
                int score1 = Integer.parseInt(s[0]);
                int score2 = Integer.parseInt(s[1]);
                candidates.add(new Candidate(score1, score2));
            }

            candidates.sort(Candidate.BY_DOCUMENT);
            int bestInterview = candidates.get(0).interview;

            for(int i=1; i<N; i++){
                Candidate candidate = candidates.get(i);
                if(candidate.interview < bestInterview){
                    bestInterview = candidate.interview;
                }else{
                    candidate.check = false;
                }
            }

            int cnt = 0;
            for(int i=0; i<N; i++){
                Candidate candidate = candidates.get(i);
                if(candidate.check){
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
