package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 답 보기 : x(반례 확인)
// 메모리 : 50424 kb
// 시간 : 720 ms
public class b_1931 {
    static class Node{
        private long start;
        private long end;

        public Node(long start, long end){
            this.start = start;
            this.end = end;
        }

        public long getStart() {
            return start;
        }
        public long getEnd() {
            return end;
        }
    }
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> meeting = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long start = Integer.parseInt(st.nextToken());
            long end = Integer.parseInt(st.nextToken());

            meeting.add(new Node(start, end));
        }

        meeting.sort((a, b) -> Long.compare(a.getStart(), b.getStart()));
        meeting.sort((a,b) -> Long.compare(a.getEnd(), b.getEnd()));

        long preEnd = 0;
        for(Node node: meeting){
            if(preEnd == 0){
                preEnd = node.getEnd();
                cnt++;
                continue;
            }

            if(node.getStart() >= preEnd){
                preEnd = node.getEnd();
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
