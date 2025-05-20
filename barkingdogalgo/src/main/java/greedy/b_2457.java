package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


// 답 보기 : x(힌트 확인)
// 메모리 :  kb
// 시간 :  ms
public class b_2457 {
    static class Flower{
        private int start;
        private int end;
        private int max;

        public Flower(int start ,int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
        }
    }

    private static List<Flower> flowers;
    private static List<Flower> finds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        flowers = new ArrayList<>();
        finds = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start  = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            flowers.add(new Flower(start, end, end-start));
        }

        flowers.sort((f1, f2) -> {
            if(f1.start != f2.start){
                return Integer.compare(f1.start, f2.start);
            }
            return Integer.compare(f2.end, f1.end);
        });

        findFlower();

        if(flowers.isEmpty()){
            System.out.println("0");
        }else{
            System.out.println(finds.size());
        }
    }

    private static void findFlower() {
        finds.add(flowers.get(0));
        int startDay = 301, endDay = 1201;

        for(int i= 1; i < flowers.size(); i++){
            Flower nowFlower = flowers.get(i);

            if(startDay < nowFlower.start){
                continue;
            }

            for(int j = 0; j < finds.size(); j++){
                Flower preFlower = finds.get(j);
                if(preFlower.end >= nowFlower.start){
                    if(preFlower.end < nowFlower.end){
                        if(finds.size() == 1){
                            finds.add(nowFlower);
                        }else{
                            for(int k = j+1; k < finds.size(); k++){
                                finds.remove(k);
                            }
                            finds.add(nowFlower);
                        }
                    }
                }
            }
        }
    }
}
