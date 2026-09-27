package pgs.lv1;

import java.util.*;
import java.util.function.ToIntFunction;

public class PGS_250121 {

    static class Table {
        private int code;
        private int date;
        private int maximum;
        private int remain;

        public Table(int code, int date, int maximum, int remain){
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }

        public int[] toArray(){
            return new int[]{code, date, maximum, remain};
        }
    }

    // ToIntFunction<Talbe> : Table을 받아서 int를 돌려주는 함수형 인터페이스. int applyAsInt(Table t); t->t.code 는 Table을 받아서 code 값을 돌려주는 함수를 람다로 쓴 것.
    // Function<Table, Integer> 를 써도 동작은 같으나, 이 경우 반환값이 Integer로 박싱
    // 해당 맵을 통해 COLUMNS.get("date") 만으로 data를 꺼내는 함수 를 고정할 수 있음.
    private static final Map<String, ToIntFunction<Table>> COLUMNS = Map.of(
            "code", t -> t.code,
            "date", t -> t.date,
            "maximum", t -> t.maximum,
            "remain", t -> t.remain
    );

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ToIntFunction<Table> extGetter = COLUMNS.get(ext);
        ToIntFunction<Table> sortGetter = COLUMNS.get(sort_by);

        return Arrays.stream(data)
                .map(row -> new Table(row[0],row[1], row[2], row[3]))
                .filter(t -> extGetter.applyAsInt(t) < val_ext)
                .sorted(Comparator.comparingInt(sortGetter))
                .map(Table::toArray)
                .toArray(int[][]::new);
    }
}
