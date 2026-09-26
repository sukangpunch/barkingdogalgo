package pgs.lv1;

public class PGS_250125 {

    static final int [] dh = {0, 1, -1, 0};
    static final int [] dw = {1, 0, 0, -1};

    public int solution(String[][] board, int h, int w) {
        int answer = 0;

        String target = board[h][w];

        for(int i=0; i<4; i++){
            int nh = h + dh[i];
            int nw = w + dw[i];

            if(nh >=0 && nh < board.length && nw >=0 && nw < board[0].length){
                if(board[nh][nw].equals(target)){
                    answer++;
                }
            }
        }

        return answer;
    }
}
