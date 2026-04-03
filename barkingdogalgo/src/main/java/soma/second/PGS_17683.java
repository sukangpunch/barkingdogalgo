package soma.second;

// 방금그곡
// 구현

/**
 * 해당 문제의 풀이는 다음과 같다.
 * 들었던 멜로디 m 에 대하여, 음악 실행시간, 한곡 멜로디를 기반으로 멜로디를 이었을 때, m멜로디가 포함되는지 확인하는 문제
 * 이때, 멜로디 문자 1개당 1분인데 C# 과 같이 2개인 CHAR인 멜로디가 있어서 문자열.replace("C#','c') 와 같이 문자를 소문자 1개로 바꿔준다.
 * 총 멜로디 문자열을 만들어야 하기 때문에 end - start를 하는데 end와 start를 정수로 만들어서 차이를 구했다.
 * 멜로디가 포함되었으면, 플레이타임이 max 길이인 것에 대하여 제목을 리턴해야하므로 maxPlayTime과 answer 를 최장시간 기반 업데이트
 */
public class PGS_17683 {
    class Solution {
        public String solution(String m, String[] musicinfos) {
            String answer = "(None)";
            int maxPlayTime = -1;
            m = replace(m);

            for(int i=0; i<musicinfos.length; i++){
                String []s = musicinfos[i].split(",");
                int start = makeTimeToInt(s[0]);
                int end = makeTimeToInt(s[1]);
                String title = s[2];
                String melody = replace(s[3]);

                int playTime = end - start;
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<playTime; j++){
                    sb.append(melody.charAt(j % melody.length()));
                }
                String fullMelody = sb.toString();

                if(fullMelody.contains(m)){
                    if(playTime > maxPlayTime){
                        maxPlayTime = playTime;
                        answer = title;
                    }
                }
            }

            return answer;
        }

        static int makeTimeToInt(String time) {
            String[] s = time.split(":");
            int hour = Integer.parseInt(s[0]);
            int miniute = Integer.parseInt(s[1]);

            int transferTime = hour * 60 + miniute;
            return transferTime;
        }

        static String replace(String melody){
            return melody.replace("C#", "c")
                    .replace("D#", "d")
                    .replace("F#", "f")
                    .replace("G#", "g")
                    .replace("A#", "a");
        }
    }
}
