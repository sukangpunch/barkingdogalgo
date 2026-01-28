package algorithm.simulation;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b_13335 {

    static int count;
    static int n;
    static int w;
    static int L;
    static int [] trucks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");

        n =  Integer.parseInt(input[0]);
        w = Integer.parseInt(input[1]);
        L = Integer.parseInt(input[2]);

        input = br.readLine().split(" ");

        trucks = Arrays.stream(input)
                .mapToInt(Integer::parseInt).toArray();

        count = 0;
        truckOnBridge();

        System.out.println(count);
    }

    private static void truckOnBridge() {
        List<Integer> nowTrucks = new ArrayList<>();

        int i=0;
        int nowWeight = 0;
        int clearTruck = 0;
        int targetIdx = 0;

        while(true){
            count++;
            if(nowWeight != 0){
                for(int j=0;j<nowTrucks.size();j++){
                    int nextStep = nowTrucks.get(j) + 1;
                    if(nextStep > w){
                        nowTrucks.remove(j);
                        nowWeight -= trucks[targetIdx];
                        targetIdx++;
                        clearTruck += 1;
                        j--;
                    }else{
                        nowTrucks.set(j, nextStep);
                    }
                }
            }

            if(i < n && nowWeight + trucks[i] <= L){
                nowWeight += trucks[i];
                nowTrucks.add(1);
                i++;
            }

            if(clearTruck == n){
                break;
            }
        }
    }
}
