package StringBasic;

import java.io.*;

public class b_9996_solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String patternString = br.readLine();
        String[] pattern = patternString.split("\\*");
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int i1 = input.indexOf(pattern[0]);
            int i2 = input.lastIndexOf(pattern[1]);

            bw.write(patternString.length()-1 <= input.length() && i1 == 0 && i2 == input.length() - pattern[1].length() ? "DA" : "NE");
            bw.write("\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
