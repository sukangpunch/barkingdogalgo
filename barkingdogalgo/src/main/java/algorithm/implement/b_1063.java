package algorithm.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 답 보기 : x(반례 확인)
// 메모리 : 16148 kb
// 시간 :  128 ms
public class b_1063 {
    static class Point{
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Point king;
    static Point rock;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        String kingFirstPoint = st.nextToken();
        String rockFirstPoint = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int kingY = kingFirstPoint.charAt(1) - '0';
        int kingX = kingFirstPoint.charAt(0) - 'A' + 1;
        king = new Point(kingY,kingX);

        int rockY = rockFirstPoint.charAt(1) - '0';
        int rockX = rockFirstPoint.charAt(0) - 'A' + 1;
        rock = new Point(rockY,rockX);

        for(int i=1;i<=N;i++){
            String input = br.readLine();
            moveKingAndRock(input);
        }

        String kingPoint = (char)('A' + king.x - 1) + "" + king.y;
        String rockPoint = (char)('A' + rock.x - 1) + "" + rock.y;
        sb.append(kingPoint).append("\n").append(rockPoint);

        System.out.println(sb);
    }
    static void moveKingAndRock(String command){
        if(command.equals("R")){
            int check = isEndPoint(0,1);
            if(check == 1){
                king.x += 1;
            }else if(check == -1){
                king.x += 1;
                rock.x += 1;
            }
        }else if(command.equals("L")){
            int check = isEndPoint(0,-1);
            if(check == 1){
                king.x -= 1;
            }else if(check == -1){
                king.x -= 1;
                rock.x -= 1;
            }
        }else if(command.equals("B")){
            int check = isEndPoint(-1,0);
            if(check == 1){
                king.y -= 1;
            }else if(check == -1){
                king.y -= 1;
                rock.y -= 1;
            }
        }else if(command.equals("T")){
            int check = isEndPoint(1,0);
            if(check == 1){
                king.y += 1;
            }else if(check == -1){
                king.y += 1;
                rock.y += 1;
            }
        }else if(command.equals("RT")){
            int check = isEndPoint(1,1);
            if(check == 1){
                king.y +=1;
                king.x +=1;
            }else if(check == -1){
                king.y += 1;
                king.x += 1;
                rock.y += 1;
                rock.x += 1;
            }
        }else if(command.equals("LT")){
            int check = isEndPoint(1,-1);
            if(check == 1){
                king.y +=1;
                king.x -=1;
            }else if(check == -1){
                king.y += 1;
                king.x -= 1;
                rock.y += 1;
                rock.x -= 1;
            }
        }else if(command.equals("RB")){
            int check = isEndPoint(-1,1);
            if(check == 1){
                king.y -= 1;
                king.x += 1;
            }else if(check == -1){
                king.y -= 1;
                king.x += 1;
                rock.y -= 1;
                rock.x += 1;
            }
        }else if(command.equals("LB")){
            int check = isEndPoint(-1,-1);
            if(check == 1){
                king.y -= 1;
                king.x -= 1;
            }else if(check == -1){
                king.y -= 1;
                king.x -= 1;
                rock.y -= 1;
                rock.x -= 1;
            }
        }
    }

    static int isEndPoint(int y, int x){
        int dy = king.y + y;
        int dx = king.x + x;

        if(dy >= 1 && dy <=8 && dx >= 1 && dx <=8){
            int ry = rock.y + y;
            int rx = rock.x + x;
            if(dy == rock.y && dx == rock.x){
                if(ry >= 1 && ry <=8 && rx >= 1 && rx <=8){
                    return -1;
                }else{
                    return 0;
                }
            }else{
                return 1;
            }
        }else{
            return 0;
        }
    }
}
