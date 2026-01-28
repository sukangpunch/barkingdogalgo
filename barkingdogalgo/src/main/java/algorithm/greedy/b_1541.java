package algorithm.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 답 보기 : x
// 메모리 : 16308 kb
// 시간 :  168 ms
public class b_1541 {
    private static List<String> formula;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        formula = new ArrayList<>();
        makeList(input);


        while(true) {
            if(formula.contains("+")){
                int idx = formula.indexOf("+");
                int sum = Integer.parseInt(formula.get(idx-1)) + Integer.parseInt(formula.get(idx+1));
                formula.remove(idx);
                formula.remove(idx);
                formula.set(idx-1, sum+"");
            }else if(formula.contains("-")){
                int idx = formula.indexOf("-");
                int sum = Integer.parseInt(formula.get(idx-1)) - Integer.parseInt(formula.get(idx+1));
                formula.remove(idx);
                formula.remove(idx);
                formula.set(idx-1, sum+"");
            }else{
                break;
            }
        }

        System.out.println(formula.get(0));
    }

    private static void makeList(String input) {
        String str = "";
        for(int i = 0; i< input.length(); i++) {
            if(input.charAt(i)=='+' || input.charAt(i)=='-') {
                formula.add(str);
                str = "";
                formula.add(String.valueOf(input.charAt(i)));
            }else{
                if(input.charAt(i) != '0'){
                    if(!str.isEmpty()){
                        if(str.charAt(0) == '0'){
                            str = "" + input.charAt(i);
                        }else{
                            str = str + input.charAt(i);
                        }
                    }else{
                        str = str + input.charAt(i);
                    }
                }else{
                    if(!str.isEmpty()){
                        if(str.charAt(0) == '0'){
                            str = "";
                        }else{
                            str = str + input.charAt(i);
                        }
                    }else{
                        str = str + input.charAt(i);
                    }
                }
            }
        }
        if(!str.isEmpty()){
            formula.add(str);
        }
    }
}
