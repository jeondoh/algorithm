import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

// 2021-08-22(일)
// 코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT > [1차] 추석 트래픽

public class ThanksgivingTraffic_kakao {

    public static void main(String[] args) throws ParseException {

        String[] lines1 = {
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"
        };
        String[] lines2 = {
                "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"
        };
        String[] lines3 = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };

        String seconds = "0.351";
//        float resultSeconds =
//        System.out.println(resultSeconds);

//        System.out.println(solution(lines1));
//        System.out.println(solution(lines2));
//        System.out.println(solution(lines3));
    }

    public static int solution(String[] lines) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        int size = lines.length;
        long[] startTime = new long[size];
        long[] endTime = new long[size];

        for(int i = 0; i<size; i++){
            String[] spData = lines[i].split(" ");
            String date = spData[0] + " " + spData[1];
            String seconds = spData[2].replace("s", "");
            long resultSeconds = (long) (Long.parseLong(seconds) + 0.001f);

            endTime[i] = sdf.parse(date).getTime();
        }

//        long diff = sDate2.getTime() - sDate.getTime();

        long min = Arrays.stream(startTime).min().getAsLong();
        System.out.println(min);

        return 0;
    }

}// end class
