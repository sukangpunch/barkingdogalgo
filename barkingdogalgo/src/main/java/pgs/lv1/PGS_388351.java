package pgs.lv1;

// 유연 근무제

/**
 *  시간 변환 문제
 *  유저 별 schedule 시간과, 실제 출근 시간에 대해, 출근 시간 <= schedule + 10 이면 된다.
 *  그래서 시간을 분단위로 변환하여 계산하면 쉬움.
 *  또한 startday가 무조건 월요일부터 시작하지 않기 때문에, realDay = day % 7 으로 4, 5, 6, 0, 1, 2, 3 으로 돌수 있도록
 */
public class PGS_388351 {

    public static void main(String[] args) {
        int [] schedules = {700, 800, 1100};
        int [][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
        int startday = 5;

        int solution = solution(schedules, timelogs, startday);
        System.out.println(solution);
    }

    static public int solution(int[] schedules, int[][] timelogs, int startday) {

        int result = 0;

        for(int i=0; i<schedules.length; i++){
            int schedule = schedules[i];

            int day = startday-1;
            int cnt = -1;
            boolean isCheck = true;
            while(cnt<6){
                int realDay = day % 7;
                day++;
                cnt++;
                if(realDay == 5 || realDay == 6){
                    continue;
                }

                if(!check(schedule, timelogs[i][cnt])){
                    isCheck = false;
                    break;
                }
            }

            if(isCheck){
                result++;
            }

        }

        return result;
    }

    static boolean check(int schedule, int time){
        int sHour = schedule/100;
        int sMinute = schedule % 100;
        int sResult = sHour * 60 + sMinute;
        int tHour = time/100;
        int tMinute = time % 100;
        int tResult = tHour * 60 + tMinute;

        if(tResult <= sResult + 10){
            return true;
        }else{
            return false;
        }
    }
}
