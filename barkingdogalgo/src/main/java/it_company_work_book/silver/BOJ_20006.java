package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 랭킹전 대기열
// 구현, 시뮬레이션
/**
 * 빡 구현이라는게 느껴져서, 알고리즘 효율 안따지고 구현하였다.
 * Room, User 클래스를 구현하여, Room에 들어오는 User를 관리하도록 하였다.
 * 이후로는 말 그대로 구현만 하면 됌.
 * 주의할점은, User 닉네임 기반으로 정렬해서 출력해야 하므로, Comparator 람다 식과 sort로 정렬한 결과를 출력
 */
public class BOJ_20006 {

    static class Room {

        int size;
        List<User> users;
        int min;
        int max;

        public Room(int size, int level, String nickname) {
            this.size = size;
            this.users = new ArrayList<>();
            this.users.add(new User(level, nickname));
            this.min = level - 10;
            this.max = level + 10;
        }

        void addUser(int level, String nickname) {
            users.add(new User(level, nickname));
        }

        boolean checkLevel(int level) {
            if (level >= min && level <= max) {
                return true;
            } else {
                return false;
            }
        }

        boolean isFull() {
            if (this.size == users.size()) {
                return true;
            } else {
                return false;
            }
        }
    }

    static class User {

        int level;
        String nickname;

        public User(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");
        int p = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            s = br.readLine().split(" ");
            int level = Integer.parseInt(s[0]);
            String nickname = s[1];

            if (rooms.isEmpty()) {
                rooms.add(new Room(m, level, nickname));
            } else {
                boolean notMatch = true;
                for (int j = 0; j < rooms.size(); j++) {
                    Room room = rooms.get(j);
                    if (!room.isFull() && room.checkLevel(level)) {
                        room.addUser(level, nickname);
                        notMatch = false;
                        break;
                    }
                }

                if (notMatch) {
                    rooms.add(new Room(m, level, nickname));
                }
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            sb.append(room.isFull() ? "Started!" : "Waiting!").append("\n");
            if (!room.users.isEmpty()) {
                room.users.sort((u1, u2) -> u1.nickname.compareTo(u2.nickname));
            } else {
                continue;
            }

            for (int j = 0; j < room.users.size(); j++) {
                User user = room.users.get(j);
                sb.append(user.level).append(" ").append(user.nickname).append("\n");
            }
        }

        System.out.println(sb);
    }
}
