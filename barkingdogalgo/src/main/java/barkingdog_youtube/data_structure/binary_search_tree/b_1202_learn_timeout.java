package barkingdog_youtube.data_structure.binary_search_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 보석 도둑
public class b_1202_learn_timeout {

    static class Jewel{
        int m;
        int v;
        public Jewel(int m, int v){
            this.m = m;
            this.v = v;
        }
    }

    static int [] bags;
    static List<Jewel> jewels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        bags = new int[k];
        jewels = new ArrayList<>();

        for(int i=0; i<N; i++){
            s = br.readLine().split(" ");
            int m = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            jewels.add(new Jewel(m, v));
        }

        for(int i=0; i<k; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);
        //jewels.sort(Comparator.comparingInt((Jewel j) -> j.v).reversed()); // reversed() 는 이미 생성된 Comparator 를 뒤집는 메서드이므로 타입 추론이 불가능 하기 때문에, Jewel j 로 명시한다.
        jewels.sort((j1, j2) -> j2.v - j1.v); // 더 깔끔한 방법


        int count = 0;
        for(int i=0; i<k; i++){
            int bagSize = bags[i];

            for(int j=0; j<jewels.size(); j++){
                Jewel now = jewels.get(j);

                if(bagSize >= now.m){
                    count += now.v;
                    jewels.remove(j);
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
