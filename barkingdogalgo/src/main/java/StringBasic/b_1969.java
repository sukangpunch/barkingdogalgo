package StringBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b_1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        String [] list = new String[N];
        String result = "";
        int hd = 0;

        for(int i=0; i<N; i++){
            String input = br.readLine();
            list[i] = input;
        }

        for(int i=0; i<M; i++){
            Map<Character, Integer> map = new HashMap<>();
            for(int j=0; j<N; j++){
                char ch = list[j].charAt(i);
                if(map.containsKey(ch)){
                    int cnt = map.get(ch);
                    cnt++;
                    map.put(ch, cnt);
                }else{
                    map.put(ch, 1);
                }
            }

            List<Character> keySetList = new ArrayList<>(map.keySet());
            Collections.sort(keySetList, (c1, c2) -> {
                int cmp = map.get(c2).compareTo(map.get(c1));
                if(cmp == 0){
                    return Character.compare(c1, c2);
                }
                return cmp;
            });
            result += keySetList.get(0);

            for(int k=1; k<keySetList.size(); k++){
                hd += map.get(keySetList.get(k));
            }
        }
        System.out.println(result);
        System.out.println(hd);
    }

}
