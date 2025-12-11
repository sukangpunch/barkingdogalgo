package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class b_1431 {
    static class MyString{
        String serial;

        public MyString(String serial){
            this.serial = serial;
        }

        int sumOfNums(){
            int sum = 0;
            for(int j=0;j<serial.length();j++){
                if(serial.charAt(j) <= '9' && serial.charAt(j) > '0'){
                    int num = serial.charAt(j) - '0';
                    sum += num;
                }
            }
            return sum;
        }

        int size(){
            return serial.length();
        }

        String getString(){
            return serial;
        }
    }

    static List<MyString> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new MyString(br.readLine()));
        }

        list.sort(Comparator.comparing(MyString::size)
                          .thenComparing(MyString::sumOfNums)
                          .thenComparing(MyString::getString));

        for(MyString m : list){
            sb.append(m.getString()).append("\n");
        }

        System.out.println(sb);
    }
}
