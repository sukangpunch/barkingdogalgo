package study.week14;


import java.util.Arrays;
import java.util.HashSet;

// 불량 사용자
// bfs

/**
 * 처음에는 visited를 ban에 두고 백트래킹 했는데, 테스트 케이스 하나가 삑남
 * 이유는 중복된 id 세트 처리 미흡, isMatch 함수에서 첫 번째로 매칭되는 인덱스만 반환
 * 그래서 한 유저가 여러 밴픽에 포함될 수 있음에도 무조건 첫번째만 리턴하는 문제
 * ai 활용 개선 이후
 * 1. resultSet을 활용하여, 다른 밴픽을 활용했지만 결과가 같은 문제를 막기 위해, user_id 세트를 string으로 저장해 놓음
 * 2. ban픽이 아닌 user기반 visited 배열 생성, 밴아이디 기반으로 유저를 매핑하는 방식으로 변경
 * 3. 즉, 밴픽을 전부 사용해야하는 것을 기저 조건으로, user를 매핑 -> 유저 조합 중, 동일한 id에 대해서는 중복 없음 처리(set)
 */
public class PGS_64064 {

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] ban_id = {"fr*d*", "*rodo", "******", "******"};

        int result = solution(user_id, ban_id);
        System.out.println(result);
    }

    static HashSet<String> resultSet = new HashSet<>();
    static boolean[] userVisited;

    static public int solution(String[] user_id, String[] banned_id) {
        userVisited = new boolean[user_id.length];
        backtrack(0, "", user_id, banned_id);
        return resultSet.size();
    }

    static void backtrack(int banIdx, String currentSet, String[] user_id, String[] banned_id){
        if(banIdx == banned_id.length){
            String[] sortedIds = currentSet.trim().split(" ");
            Arrays.sort(sortedIds);
            resultSet.add(Arrays.toString(sortedIds));
            return;
        }

        for(int i=0; i<user_id.length; i++){
            if(!userVisited[i] && isMatch(user_id[i], banned_id[banIdx])){
                userVisited[i] = true;
                backtrack(banIdx + 1, currentSet + " " + i, user_id, banned_id);
                userVisited[i] = false;
            }
        }
    }

    static boolean isMatch(String user, String ban){
        if(user.length() != ban.length()) return false;
        for(int i=0; i<user.length(); i++){
            if(ban.charAt(i) != '*' && user.charAt(i) != ban.charAt(i)) return false;
        }
        return true;
    }
}
