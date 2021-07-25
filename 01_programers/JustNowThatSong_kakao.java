import java.text.SimpleDateFormat;
import java.util.Date;

// 2021-07-04(일)
// 코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT > [3차] 방금그곡
public class JustNowThatSong_kakao {
    // String : 문자열 연산이 적고 멀티쓰레드 환경일 경우
    // StringBuffer : 문자열 연산이 많고 멀티쓰레드 환경일 경우
    // StringBuilder : 문자열 연산이 많고 단일쓰레드이거나 동기화를 고려하지 않아도 되는 경우 > buffer보다 좀 더 빠름
    public static final String answer = "(None)";

    public static void main(String[] args) {
        String m1 = "ABCDEFG";
        String m2 = "CC#BCC#BCC#BCC#B";
        String m3 = "ABC";
        String m4 = "ABC";
        String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String[] musicinfos4 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:14,WORLD,ABCDEF"};

        System.out.println(solution(m1, musicinfos1));
        System.out.println(solution(m2, musicinfos2));
        System.out.println(solution(m3, musicinfos3));
        System.out.println(solution(m4, musicinfos4));
    }

    public static String solution(String melody, String[] musicinfos) {
        // 조건이 일치하는 음악이 없을 때에는 “(None)”을 반환한다.
        String result = answer;
        // 시간비교
        int timeCompare = 0;
        // # > 소문자 변환
        melody = replaceSharpToLower(melody);

        for(String musicData : musicinfos){
            StringBuilder musicBuilder = new StringBuilder();
            String[] data = musicData.split(",");
            int time = getTime(data[0], data[1]);
            // 멜로디 구성
            appendMusic(musicBuilder, data[3], time);
            // music 정보가 멜로디에 있는지 확인
            int chk = musicBuilder.indexOf(melody);
            if(chk>=0){
                // 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다.
                // 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
                if(time > timeCompare){
                    timeCompare = time;
                    result = data[2];
                }
            }
        }
        return result;
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
    private static String replaceSharpToLower(String music){
        music = music.replace("A#", "a");
        music = music.replace("C#", "c");
        music = music.replace("D#", "d");
        music = music.replace("F#", "f");
        music = music.replace("G#", "g");
        return music;
    }
    // Time 만큼 문자열 삽입
    private static void appendMusic(StringBuilder musicBuilder, String music, int time){
        // #붙은것들 소문자로
        music = replaceSharpToLower(music);
        // 멜로디 길이가 시간보다 길면 잘라줌
        int musicLen = music.length();
        if(musicLen > time){
            musicBuilder.append(music.substring(0, time));
            return;
        }
        // Time 만큼 멜로디 반복
        // 몫 & 나머지로 계산해서 멜로디를 이어줌
        int quotient = time / musicLen; // 몫
        int division = time % musicLen; // 나머지

        for(int i = 0; i<quotient; i++){
            musicBuilder.append(music);
        }
        // 나머지가 있으면 멜로디 이어줌
        if(division>0){
            music+=music.substring(0, division);
            musicBuilder.append(music);
        }
    }

}// end class
