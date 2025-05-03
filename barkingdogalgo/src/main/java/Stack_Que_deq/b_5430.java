package Stack_Que_deq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class b_5430 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int k=0; k<N; k++){
            boolean isError = false;

            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            char[] chars = func.toCharArray();

            Deque<Integer> deque = new LinkedList<>();

            if(arr.length()>2){
                String[] split = arr.substring(1, arr.length()-1).split(",");
                for(int i=0; i<split.length; i++){
                    deque.addLast(Integer.parseInt(split[i]));
                }
            }

            boolean isReserve = false;
            for(int i=0; i<chars.length;i++){
                char ch = chars[i];
                if(ch == 'R'){
                    if(isReserve){
                        isReserve = false;
                    }else{
                        isReserve = true;
                    }
                }else if(ch == 'D'){
                    if(deque.isEmpty()){
                        isError = true;
                        break;
                    }else if(isReserve){
                        deque.pollLast();
                    }else{
                        deque.pollFirst();
                    }
                }else{
                    isError = true;
                    break;
                }
            }
            if(isError){
                sb.append("error\n");
            }else{
                print(deque, isReserve);
            }
        }
        System.out.println(sb);
    }

    static void print(Deque<Integer> deque, boolean isReverse){

        if(deque.size() == 0){
            sb.append("[]\n");
            return;
        }
        sb.append("[");
        int size = deque.size();
        if(isReverse){
            for(int i=0;i<size-1;i++){
                sb.append(deque.pollLast()).append(",");
            }
        }else{
            for(int i=0;i<size-1;i++){
                sb.append(deque.pollFirst()).append(",");
            }
        }
        sb.append(deque.poll()+"]\n");
    }
}
