package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class b_10799 {
    static class Pair{
        char sym;
        int index;

        public Pair(char sym, int index){
            this.sym = sym;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> laser = new ArrayList<>();
        Stack<int[]> stick = new Stack<>();

        String line = br.readLine();
        Stack<Pair> sym = new Stack<>();

        for(int j=0; j<line.length(); j++){
            char index = line.charAt(j);
            Pair curSym = new Pair(index, j);

            if(sym.isEmpty()){
                sym.push(curSym);
            }else if(index == ')'){
                Pair compare = sym.pop();
                if(j - compare.index == 1){
                    laser.add(compare.index);
                }else{
                    stick.push(new int[]{compare.index, j});
                }
            }else{
                sym.push(new Pair(index, j));
            }
        }

        Collections.sort(laser);

        int partStick = 0;

        while(!stick.isEmpty()){
            int[] curr = stick.pop();
            int startIndex = curr[0];
            int entIndex = curr[1];

            partStick++;

            int start = lowerBound(laser, startIndex);
            int end = lowerBound(laser, entIndex);
            partStick += end - start;
        }
        System.out.println(partStick);
        br.close();
    }

    public static int lowerBound(List<Integer> laser, int target){
        int start = 0;
        int end = laser.size();

        while(start < end){
            int mid = (start + end)/2;
            if(laser.get(mid) >= target){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}
