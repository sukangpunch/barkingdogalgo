package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 답 보기 : x(질문 게시판 힌트)
// 메모리 : 14428 kb
// 시간 : 116 ms
public class b_17478 {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        String answer = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
        sb.append(answer).append("\n");
        int cnt = 0;
        String dash = "";
        chatbot(cnt,dash);

        System.out.println(sb);
    }

    private static void chatbot(int cnt, String dash) {
        if(cnt == N) {
            sb.append(dash).append("\"재귀함수가 뭔가요?\"").append("\n");
            sb.append(dash).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
            sb.append(dash).append("라고 답변하였지.").append("\n");
            return;
        }

        sb.append(dash).append("\"재귀함수가 뭔가요?\"").append("\n");
        sb.append(dash).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
        sb.append(dash).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
        sb.append(dash).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");

        chatbot(cnt+1, dash + "____");
        sb.append(dash).append("라고 답변하였지.").append("\n");
    }
}
