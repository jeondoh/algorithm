import java.util.Arrays;
import java.util.HashMap;

// 2021-08-15(일)
// 코딩테스트 연습 > 2019 KAKAO BLIND RECRUITMENT > 오픈 채팅방
public class OpenChat_kakao {

    public static void main(String[] args) {
        String[] recode = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(recode)));
    }

    public static String[] solution(String[] record) {
        HashMap<String, String> dataMap = new HashMap<String, String>();
        int arrSize = castToHashMap(record, dataMap);
        String[] answer = new String[arrSize];

        int i = 0;
        for(String data : record){
            String[] sp = data.split(" ");
            String stat = sp[0];
            String userName = dataMap.get(sp[1]);
            String result = "";

            switch (stat) {
                case "Change":
                    continue;
                case "Enter":
                    result = userName + "님이 들어왔습니다.";
                    break;
                case "Leave":
                    result = userName + "님이 나갔습니다.";
                    break;
            }
            answer[i++] = result;
        }
        return answer;
    }
    // 배열 크기 반환
    public static int castToHashMap(String[] record, HashMap<String, String> dataMap){
        int size = 0; // 배열 사이즈 반환
        for(String data : record){
            String[] sp = data.split(" ");
            String stat = sp[0];

            if(stat.equals("Enter")){
                dataMap.put(sp[1], sp[2]);
                size++;
            }else if(stat.equals("Change")){
                dataMap.put(sp[1], sp[2]);
            }else {
                size++;
            }
        }
        return size;
    }


}// end class
