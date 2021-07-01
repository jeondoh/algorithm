package company;

import java.text.SimpleDateFormat;
import java.util.Date;

// 2021-07-01(목)
// 코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT > [3차] 방금그곡
public class kakao_02 {

    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        System.out.println(solution(m, musicinfos));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        for(String musicData : musicinfos){
            String[] data = musicData.split(",");
            int time = getTime(data[0], data[1]);
            System.out.println(time);
        }

        return answer;
    }

    // 시간 구하기
    private static int getTime(String startTime, String endTime){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        try{
            Date d1 = format.parse(startTime);
            Date d2 = format.parse(endTime);
            long diff = d2.getTime() - d1.getTime();
            return (int) (diff / 60000); // 1000밀리초 = 1초
        }catch(Exception e){
            System.out.println("시간변환 오류");
        }
        return 0;
    }


}
/*
치환?을 해야하나
대소문자로 해볼까
A = A
A# = a
B = B
C = C
C# = c
D = D
D# = d
E = E
F = F
F# = f
G = G
G# = g
*/
