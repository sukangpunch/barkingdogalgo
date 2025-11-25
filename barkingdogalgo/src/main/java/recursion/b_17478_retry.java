package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀함수가 뭔가요?
public class b_17478_retry {

    static int N;
    static String first = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    static String second = "\"재귀함수가 뭔가요?\"";
    static String third = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static String forth = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지." ;
    static String fifth = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";

    static String answer1 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String answer2 = "라고 답변하였지.";

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String prefix = "";

        sb.append(prefix).append(first).append("\n");

        chatBot(0, prefix);

        System.out.println(sb);
    }

    private static void chatBot(int n, String prefix) {
        if(n == N){
            sb.append(prefix).append(second).append("\n")
                    .append(prefix).append(answer1).append("\n")
                    .append(prefix).append(answer2).append("\n");
            return;
        }

        sb.append(prefix).append(second).append("\n")
                .append(prefix).append(third).append("\n")
                .append(prefix).append(forth).append("\n")
                .append(prefix).append(fifth).append("\n");

        chatBot(n + 1, prefix + "____");

        sb.append(prefix).append(answer2).append("\n");
    }
}
