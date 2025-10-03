package stack_parentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b_2504 {

    static class Pair{
        private char parentheses;
        private int index;

        public Pair(char parentheses, int index){
            this.parentheses = parentheses;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Stack<Pair> pairs = new Stack<>();
        Stack<int[]> counts = new Stack<>();

        for(int i=0; i<input.length(); i++){
            char parentheses = input.charAt(i);
            if(parentheses == '(' || parentheses == '['){
                pairs.push(new Pair(parentheses, i));
            }
            else if(parentheses == ')'){
                if(pairs.isEmpty() || pairs.peek().parentheses != '('){
                    System.out.println(0);
                    return;
                }
                else if(i - pairs.peek().index == 1){
                    counts.push(new int[]{pairs.pop().index, 2});
                }else{
                    int tmp = 0;
                    int size = counts.size();
                    for(int j=0; j<size; j++){
                        if(pairs.peek().index < counts.peek()[0]){
                            tmp += counts.pop()[1];
                        }
                    }
                    counts.push(new int[]{pairs.pop().index, tmp*2});
                }
            }else if(parentheses == ']'){
                if(pairs.isEmpty() || pairs.peek().parentheses != '['){
                    System.out.println(0);
                    return;
                }
                else if(i - pairs.peek().index == 1){
                    counts.push(new int[]{pairs.pop().index, 3});
                }else{
                    int tmp = 0;
                    int size = counts.size();
                    for(int j=0 ; j<size; j++){
                        if(pairs.peek().index < counts.peek()[0]){
                            tmp += counts.pop()[1];
                        }
                    }
                    counts.push(new int[]{pairs.pop().index, tmp*3});
                }
            }
        }

        if(!pairs.isEmpty()){
            System.out.println(0);
            return;
        }

        int result = 0;

        while(!counts.isEmpty()){
            result += counts.pop()[1];
        }
        System.out.println(result);
    }
}