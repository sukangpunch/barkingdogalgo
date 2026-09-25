package pgs.lv1;

public class PGS_250137 {

    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int lastTime = attacks[attacks.length-1][0];
        int myHealth = health;
        int consecutive = 0;

        while(time < lastTime){
            boolean isOver = false;
            boolean isAttack = false;
            time++;

            for(int i=0; i<attacks.length; i++){
                if(attacks[i][0] == time){
                    isAttack = true;
                    consecutive = 0;

                    myHealth -= attacks[i][1];
                    if(myHealth <= 0) {
                        isOver = true;
                        break;
                    }
                }else if(attacks[i][0] < time){
                    continue;
                }else{
                    break;
                }
            }

            if(isOver){
                break;
            }

            if(!isAttack){
                if(myHealth != health){
                    myHealth = Math.min(health, myHealth + bandage[1]);
                    consecutive++;

                    if(consecutive == bandage[0]){
                        myHealth = Math.min(health, myHealth + bandage[2]);
                        consecutive = 0;
                    }
                }else{
                    consecutive++;
                }
            }
        }

        if(myHealth <= 0){
            return -1;
        }else{
            return myHealth;
        }
    }
}
