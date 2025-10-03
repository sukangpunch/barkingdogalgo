package stack_que_deq;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class b_5430_solution {
    static Deque<String> dq;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        dq = new ArrayDeque<>();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String func = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String input = br.readLine();
            makeDq(input);
            boolean reverse = false;
            boolean flag = false;

            for (int j = 0; j < func.length(); j++) {
                if (func.charAt(j) == 'R') {
                    reverse = !reverse;
                } else {
                    if (dq.isEmpty()) {
                        sb.append("error" + "\n");
                        flag = true;
                        break;
                    } else if (reverse) {
                        dq.pollLast();
                    } else {
                        dq.pollFirst();
                    }
                }
            }
            if (flag) continue;
            makeStr(reverse);
        }
        bw.write(sb + "");
        bw.flush();
        br.close();
    }

    static void makeStr(boolean reverse) {
        int size = dq.size();
        if (size < 1) {
            sb.append("[]");
        } else if (reverse) {
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(dq.pollLast());
                if (i != size - 1) sb.append(",");
            }
            sb.append("]");
        } else {
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(dq.pollFirst());
                if (i != size - 1) sb.append(",");
            }
            sb.append("]");
        }
        sb.append("\n");
    }

    static void makeDq(String input) {
        String[] str = input.replace("[", "").replace("]", "").split(",");
        if (str[0].equals("")) return;
        for (int i = 0; i < str.length; i++) {
            dq.add(str[i]);
        }
    }
}