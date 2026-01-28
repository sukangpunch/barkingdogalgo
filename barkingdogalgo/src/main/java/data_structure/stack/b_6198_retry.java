package data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 옥상 정원 꾸미기
public class b_6198_retry {
    static class Building{
        int h;
        int count;

        public Building(int h, int count) {
            this.h = h;
            this.count = count;
        }
    }

    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> inputStack = new Stack<>();
        Stack<Building> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            int height = Integer.parseInt(br.readLine());
            inputStack.push(height);
        }

        int size = inputStack.size();
        for(int i = 0; i < size; i++){
            int height = inputStack.pop();
            Building now = new Building(height, 1);

            if(stack.isEmpty()){
                stack.push(now);
                continue;
            }

            if(stack.peek().h > now.h){
                stack.push(now);
                continue;
            }

            while(!stack.isEmpty() && stack.peek().h < now.h){
                if(stack.peek().h <= now.h){
                    Building pop = stack.pop();
                    now.count += pop.count;
                    result += pop.count;
                }
            }
            stack.push(now);
        }

        System.out.println(result);
    }
}
