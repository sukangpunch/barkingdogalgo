import java.util.*;

public class Test {

    public static void main(String[] args) {
        int [] arr = {5,2,8,1,9};
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArr, Collections.reverseOrder());


    }
}
