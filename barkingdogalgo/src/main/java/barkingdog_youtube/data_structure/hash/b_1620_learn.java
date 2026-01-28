package barkingdog_youtube.data_structure.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 나는야 포켓몬 마스터 이다솜
public class b_1620_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String []s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();

        for(int i=1; i<=N; i++){
            String pocketMon = br.readLine();
            map1.put(pocketMon,String.valueOf(i));
            map2.put(String.valueOf(i), pocketMon);
        }

        for(int i=0; i<M; i++){
            String input = br.readLine();
            if(map1.get(input) != null){
                sb.append(map1.get(input)).append("\n");
            }else{
                sb.append(map2.get(input)).append("\n");
            }
        }

        System.out.println(sb);
    }

}
