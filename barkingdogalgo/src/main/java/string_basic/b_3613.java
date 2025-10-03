package string_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int type = checkJavaOrCpp(input);

        String result = "";

        if(type == 1){
            result = convertCppToJava(input);
        }
        else{
            result = convertJavaToCpp(input);
        }

        System.out.println(result);
    }

    private static String convertJavaToCpp(String input) {
        if(Character.isUpperCase(input.charAt(0))){
            return "Error!";
        }
        for(int i=1; i<input.length(); i++){
            if(Character.isUpperCase(input.charAt(i))){
                input = input.substring(0, i) + "_" + Character.toLowerCase(input.charAt(i)) + input.substring(i+1, input.length());
                i++;
            }
        }
        return input;
    }

    private static String convertCppToJava(String input) {
        if(input.charAt(0) == '_' || input.charAt(input.length()-1) == '_'){
            return "Error!";
        }

        for(int i=0; i<input.length();i++){
            if(Character.isUpperCase(input.charAt(i))){
                return "Error!";
            }
            if(i != 0 && i != input.length()-1 && input.charAt(i) == '_' && input.charAt(i+1) == '_'){
                return "Error!";
            }
        }

        for(int i=1; i < input.length()-1; i++){
            if(input.charAt(i) == '_'){
                input = input.substring(0,i) + Character.toUpperCase(input.charAt(i+1)) + input.substring(i+2, input.length());
            }
        }

        return input;
    }

    private static int checkJavaOrCpp(String input) {
        if(input.contains("_")){
            return 1;
        }
        return 0;
    }
}
