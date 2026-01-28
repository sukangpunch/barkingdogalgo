package barkingdog_youtube.data_structure.hash;

// 체이닝 해쉬 구현
public class ChainingHash {

    static final int M = 1000003;
    static final int A = 1000;

    static class Node{
        String key;
        int value;
        Node next;

        Node(String key, int value){
            this.key = key;
            this.value =value;
        }
    }

    private Node[] table;

    public ChainingHash(){
        this.table = new Node[M];
    }

    public boolean isHashSame(String key1, String key2){
        return myHash(key1) == myHash(key2);
    }

    private int myHash(String s){
        int h = 0;
        for(int i=0; i<s.length(); i++){
            h = (h * A + s.charAt(i)) % M;
        }
        return h < 0 ? h + M : h;
    }

    public Integer find(String key){
        int idx = myHash(key);
        Node curr = table[idx];

        while(curr != null){
            if(curr.key.equals(key)){
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    public void insert(String key, int value){
        int idx = myHash(key); // 60
        Node curr = table[idx];

        while(curr != null){
            if(curr.key.equals(key)){
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = table[idx]; // 연결리스트 마지막 노드
        table[idx] = newNode; //
    }

    public boolean erase(String key){
        int idx = myHash(key);
        Node curr = table[idx];
        Node prev = null;

        while(curr != null){
            if(curr.key.equals(key)){
                if(prev == null){
                    table[idx] = curr.next;
                } else{
                    prev.next = curr.next;
                }
                return true;
            }
            prev = curr;
            curr = curr.next;
        }

        return false;
    }
}
