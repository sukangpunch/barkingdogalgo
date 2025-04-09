package StringBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b_9536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            List<String> cryings = new ArrayList<>(List.of(br.readLine().split(" ")));

            String answer = "";
            while (true) {
                answer = br.readLine();
                if(answer.equals("what does the fox say?")){break;}
                String crying = answer.split(" ")[2];
                while(cryings.contains(crying)){
                    cryings.remove(crying);
                }
            }
            for(int j = 0; j < cryings.size(); j++){
                System.out.print(cryings.get(j) + " ");
            }
        }
    }
}
