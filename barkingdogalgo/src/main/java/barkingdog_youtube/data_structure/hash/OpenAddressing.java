package barkingdog_youtube.data_structure.hash;

// OpenAddressing 해시 맵
public class OpenAddressing {

    private static final int A = 1000;
    private static final int M = 1000003;
    private static final String DELETED = "__DELETED__";

    private String[] keys;
    private Integer[] values;
    private int size;

    public OpenAddressing(){
        this.keys = new String[M];
        this.values = new Integer[M];
        this.size = 0;
    }

    private int myHash(String s){
        int h = 0;
        for(int i=0; i<s.length(); i++){
            h = (h * A + s.charAt(i)) % M;
        }
        return h < 0 ? h+M : h;
    }

    public Integer find(String key){
        int idx = myHash(key);

        for(int i=0; i<M; i++){
            int probeIdx = (idx + i) % M;

            if(keys[probeIdx] == null){
                return null;
            }

            if(keys[probeIdx].equals(DELETED)){
                continue;
            }

            if(keys[probeIdx].equals(key)){
                return values[probeIdx];
            }
        }

        return null;
    }

    public void insert(String key, int value){
        if(size >= M * 0.75) {
            throw new IllegalStateException("해시 테이블이 꽉 찼습니다.");
        }

        int idx = myHash(key);

        for(int i=0; i<M; i++){
            int probeIdx = (idx + i) % M;

            if(keys[probeIdx] == null || keys[probeIdx].equals(DELETED)){
                keys[probeIdx] = key;
                values[probeIdx] = value;
                size++;
                return;
            }

            if(keys[probeIdx].equals(key)){
                values[probeIdx] = value;
                return;
            }
        }

        throw new IllegalStateException("해시 테이블이 꽉 찼습니다.");
    }

    public boolean erase(String key){
        int idx = myHash(key);

        for (int i=0; i<M; i++){
            int probeIdx = (idx + i) % M;

            if(keys[probeIdx] == null){
                return false;
            }

            if(keys[probeIdx].equals(DELETED)){
                continue;
            }

            if(keys[probeIdx].equals(key)){
                keys[probeIdx] = DELETED;
                values[probeIdx] = null;
                size--;
                return true;
            }
        }

        return false;
    }

    public int size(){
        return size;
    }
}
