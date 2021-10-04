import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Declaration {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        System.out.println(Arrays.toString(solution(id_list, report, 2)));

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        System.out.println(Arrays.toString(solution(id_list2, report2, 3)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        LinkedHashMap<String, Integer> idMap = new LinkedHashMap<String, Integer>(); // key : ID value : 메일받은 횟수
        HashMap<String, Integer> dcMap = new HashMap<String, Integer>(); // key : 신고받은자 ID, value : 신고받은 횟수

        // 배열 중복 제거 > 각 유저는 한번에 한명의 유저만 신고가능
        String[] newReport = Arrays.stream(report).distinct().toArray(String[]::new);
        int newReportSize = newReport.length;
        // idMap 초기화
        for(String id : id_list){
            idMap.put(id, 0);
        }
        for (String data : newReport) {
            String[] spReport = data.split(" ");
            int getCount = dcMap.getOrDefault(spReport[1], 0);
            dcMap.put(spReport[1], ++getCount);
        }
        // 신고횟수가 k 이상인 ID
        for (String data : id_list){
            int count = dcMap.getOrDefault(data, 0);
            if(count >= k){
                for (String reportData : newReport) {
                    String[] spReport = reportData.split(" ");
                    if (spReport[1].equals(data)) {
                        int getCount = idMap.getOrDefault(spReport[0], 0);
                        idMap.put(spReport[0], ++getCount);
                    }
                }
            }
        }

        int size = 0;
        Collection<Integer> values = idMap.values();
        for (Integer value : values) {
            answer[size++] = value;
        }
        return answer;
    }

}// end class
