package basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class b_2941_solution {
    private static List<String> croatia = List.of("c=","c-","dz=","d-","lj","nj","s=","z=");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        for(int i=0; i<croatia.size(); i++){
            if(input.contains(croatia.get(i))){
                input = input.replace(croatia.get(i), "@");
            }
        }

        System.out.println(input.length());
    }
}
