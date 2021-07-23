import java.util.Arrays;

// 2021-07-25(일)
// 코딩테스트 연습 > 찾아라 프로그래밍 마에스터 > 폰켓몬
public class Poketmon_Maester {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};
        int[] nums2 = {3, 3, 3, 2, 2, 4};
        int[] nums3 = {3, 3, 3, 2, 2, 2};
        System.out.println(solution(nums));
        System.out.println(solution(nums2));
        System.out.println(solution(nums3));
    }

    public static int solution(int[] nums) {
        int size = nums.length; // 포켓몬 초기 개수(중복포함)
        int poketmonNum = size / 2; // 선택할 수 있는 포켓몬 수
        // 배열 중복제거
        // HashSet / LinkedHashSet OR Stream / Distinct 이용
        int[] resultArr = Arrays.stream(nums).distinct().toArray(); // 포켓몬 중복제거
        int resultSize = resultArr.length; // 포켓몬 개수(중복제거)
        return Math.min(poketmonNum, resultSize);
    }

}// end class
