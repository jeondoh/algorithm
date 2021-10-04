import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Parking {

    public static void main(String[] args) throws ParseException {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(Arrays.toString(solution(fees, records)));
    }

    public static int[] solution(int[] fees, String[] records) throws ParseException {
        HashMap<String, Integer> carMap = new HashMap<String, Integer>(); // key : 차량번호 value : 돈
        HashMap<String, Object> dataMap = new HashMap<String, Object>(); // key : 차량번호 value : 시간(String)

        for(String data : records){
            String[] record = data.split(" ");
            String getData = dataMap.getOrDefault(record[1], "").toString();
            if(getData.equals("")){
                getData = record[0];
            }else{
                getData+= "," + record[0];
            }
            dataMap.put(record[1], getData);
            carMap.put(record[1], 0);
        }

        for(String key : carMap.keySet()){
            String timeData = dataMap.get(key).toString();
            String[] spTime = timeData.split(",");
            if(spTime.length%2 != 0){
                timeData += ",23:59";
                spTime = timeData.split(",");
            }

            int minutes = 0;
            int size = spTime.length;
            for(int i = 0; i<size; i++){
                if(i%2==0){
                    minutes += getTime(spTime[i], spTime[i+1]);
                }
            }
            carMap.put(key, resultMoney(fees, minutes));
        }

        HashMap<Integer, Integer> sorMap = sortMapByKey(carMap);
        int[] answer = new int[sorMap.size()];
        int size = 0;
        Collection<Integer> values = sorMap.values();
        for (Integer value : values) {
            answer[size++] = value;
        }
        return answer;
    }

    private static int getTime(String startTime, String endTime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date d1 = format.parse(startTime);
        Date d2 = format.parse(endTime);
        long diff = d2.getTime() - d1.getTime();
        return (int) (diff / 60000); // 1000밀리초 = 1초
    }

    private static int resultMoney(int[] fees, int minutes){
        int basicMinutes = fees[0];
        int basicMoney = fees[1];
        int countMinutes = fees[2];
        int countMoney = fees[3];

        if(basicMinutes >= minutes){
            return basicMoney;
        }
        double div = Math.ceil((double)(minutes - basicMinutes) / countMinutes) * countMoney;
        return (int) (basicMoney + div);
    }

    public static LinkedHashMap<Integer, Integer> sortMapByKey(HashMap<String, Integer> map) {
        List<HashMap.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByKey());

        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();
        for (HashMap.Entry<String, Integer> entry : entries) {
            result.put(Integer.valueOf(entry.getKey()), entry.getValue());
        }
        return result;
    }

}// end class
