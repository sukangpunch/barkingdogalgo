package barkingdog_youtube.data_structure.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 절댓값 힙
public class b_11286_learn {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) ->{ // Comparator<Integer> 를 람다식으로 전달, Comparable 은 클래스에 구현한다.
                    int absA = Math.abs(a);
                    int absB = Math.abs(b);

                    if(absA == absB){ // 절대값이 같으면 더 작은 수로
                        return a-b;
                    }

                    return absA - absB;
                }
        );

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    Integer poll = pq.poll();
                    sb.append(poll).append("\n");
                }
            }else{
                pq.offer(num);
            }
        }

        System.out.println(sb);
    }

}
