package StringBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_23304 {
    public static String input;
    public static boolean isAkaPalindrome;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        int size = input.length();

        if (size == 1) {
            System.out.println("AKARAKA");
        }
        else{
            find(size);
            if(isAkaPalindrome){
                System.out.println("AKARAKA");
            }else{
                System.out.println("IPSELENTI");
            }
        }

    }

    private static void find(int size){
        if(size ==1){
            isAkaPalindrome = true;
            return;
        }

        int middle = size / 2;
        for (int i = 0; i < middle; i++) {
            if (input.charAt(i) != input.charAt(size - 1 - i)) {
                isAkaPalindrome = false;
                return;
            }
        }

        find(middle);
    }
}
