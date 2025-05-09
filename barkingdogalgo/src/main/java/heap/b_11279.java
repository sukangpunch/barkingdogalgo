package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 답 보기 : x
// 메모리 : 23436 kb
// 시간 : 256 ms
public class b_11279 {
    static class Heap{
        private int [] heap;
        private int size;

        public Heap(int size) {
            this.heap = new int[size+1];
            this.size = 0;
        }

        private void add(int x) {
            int child, parent;
            child = ++size;
            parent = child/2;

            while((parent >= 1) && (x > heap[parent])){
                heap[child] = heap[parent];
                child /=2;
                parent = child/2;
            }
            heap[child] = x;
        }

        private int remove(){
            if(size == 0){
                return 0;
            }

            int parent, child, result, temp;
            result = heap[1];
            temp = heap[size--];
            parent = 1;
            child = 2;

            while(child <=size){
                if(child < size && heap[child] < heap[child+1])child++;
                if(temp > heap[child])break;

                heap[parent] = heap[child];
                parent = child;
                child *=2;
            }
            heap[parent] = temp;
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Heap heap = new Heap(N);

        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                sb.append(heap.remove()).append("\n");
            }else{
                heap.add(x);
            }
        }
        System.out.println(sb);
    }
}
