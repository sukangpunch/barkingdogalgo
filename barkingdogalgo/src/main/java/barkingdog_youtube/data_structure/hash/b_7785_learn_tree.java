package barkingdog_youtube.data_structure.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeMap;

// 회사에 있는 사람
public class b_7785_learn_tree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        TreeMap<String, String> map = new TreeMap<>(Collections.reverseOrder());

        for(int i=0; i<N; i++){
            String [] s = br.readLine().split(" ");
            if(s[1].equals("enter")){
                map.put(s[0], s[1]);
            }else if(s[1].equals("leave")){
                map.remove(s[0]);
            }
        }

        map.forEach((key,value) -> sb.append(key).append("\n"));
        System.out.println(sb);
    }

}
