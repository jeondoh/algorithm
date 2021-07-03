package company;

import java.text.SimpleDateFormat;
import java.util.Date;

// 2021-07-01(목)
// 코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT > [3차] 방금그곡
public class kakao_02 {
    // 문자열 이을때 특징
    // String : 문자열 연산이 적고 멀티쓰레드 환경일 경우
    // StringBuffer : 문자열 연산이 많고 멀티쓰레드 환경일 경우
    // StringBuilder : 문자열 연산이 많고 단일쓰레드이거나 동기화를 고려하지 않아도 되는 경우
    public static void main(String[] args) {
        String m1 = "ABCDEFG";
        String m2 = "CC#BCC#BCC#BCC#B";
        String m3 = "ABC";
        String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        System.out.println(solution(m1, musicinfos1));
        System.out.println(solution(m2, musicinfos2));
        System.out.println(solution(m3, musicinfos3));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        for(String musicData : musicinfos){
            StringBuilder melodyBuilder = new StringBuilder();
            String[] data = musicData.split(",");
            int time = getTime(data[0], data[1]);

            String melody = replaceMelody(data[3], time); // #붙은 알파벳 replace

            System.out.println(melody);

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

    // 치환 > #붙은것들은 소문자로
    // Time 만큼 문자열 삽입
    private static String replaceMelody(String melody, int time){
        melody = melody.replace("A#", "a");
        melody = melody.replace("C#", "c");
        melody = melody.replace("D#", "d");
        melody = melody.replace("F#", "f");
        melody = melody.replace("G#", "g");
        // 멜로디 길이가 시간보다 길면 잘라줌
        int melodyLen = melody.length();
        if(melodyLen > time){
            return melody.substring(0, time);
        }
        // Time 만큼 멜로디 반복
        // 몫 & 나머지로 계산해서 멜로디를 이어줌
        int quotient = time / melodyLen; // 몫
        int division = time % melodyLen; // 나머지

        for(int i = 0; i<quotient; i++){

        }
        if(division>0){
            melody+=melody.substring(0, division);
        }
        return melody;
    }

}
