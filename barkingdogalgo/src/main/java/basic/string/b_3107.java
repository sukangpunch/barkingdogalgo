package basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b_3107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ipv6 = br.readLine();

        String result = "";
        if(ipv6.contains("::")){
            result = makeOriginalV2(ipv6);
        }else{
            result = makeOriginalV1(ipv6);
        }
        System.out.println(result);
    }

    private static String makeOriginalV2(String ipv6) {
        List<String> parts = new ArrayList<>();
        ipv6 = ipv6.replace("::", "@").strip();

        int before = 0;
        for(int i=0; i<ipv6.length(); i++){
            if(ipv6.charAt(i) == ':'){
                parts.add(ipv6.substring(before, i));
                before = i+1;
            }
            if(ipv6.charAt(i) == '@'){
                if(i != 0){
                    parts.add(ipv6.substring(before, i));
                }
                parts.add("@");
                before = i+1;
            }

            if(i == ipv6.length()-1 && ipv6.charAt(i) != ':' && ipv6.charAt(i) != '@'){
                parts.add(ipv6.substring(before, i+1));
            }
        }

        int len = 8 - (parts.size() -1);
        for(int i=0; i<parts.size(); i++){
            if(parts.get(i).equals("@")){
                String result = "0000:".repeat(len);
                result = result.substring(0, result.length()-1);
                parts.set(i, result);
            }
            String result = String.format("%4s", parts.get(i)).replace(' ', '0');
            parts.set(i, result);
        }

        return String.join(":", parts);
    }

    private static String makeOriginalV1(String ipv6) {
        String [] parts = ipv6.split(":");
        for(int i = 0 ; i < parts.length ; i++){
            parts[i] = String.format("%4s", parts[i]).replace(' ', '0');
        }

        return String.join(":", parts);
    }

}
