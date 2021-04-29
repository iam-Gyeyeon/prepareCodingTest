/*
총평

1. 그냥 배열 한개씩 인접한 값들만 비교하면 된거 아닌가?라고 단순하게 생각함
  (본질적인건 맞는데 섬세함이 부족했음)
2. answer의 size를 정하지 않았을때 오류가 나서 당황함
3. idx값을 따로 설정하지 않고 loop의 i의 값이 인덱스가 되지 않을까라고 단순하게 생각함
  (if 조건에 걸리지 않았을 때가 발생하기 때문에 인덱스 값이 1...3...4.. 이렇게 건너뛸수도 있겠다고 깨달음)

*/
public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        int size = 1; 
        
      //size를 알아보기 위해 arr의 i번째 값과 그 전값을 비교.
      //일치하지 않는다면 size를 증가(중복 제거한 answer배열의 size check)
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] != arr[i]) size++;
        }
        answer = new int[size];
    
        answer[0] = arr[0];
      //인덱스를 loop의 i로 놓지 않고 idx라는 변수로 설정해주어서 if조건문에 실행되지 않을때도 인덱스가 빈값 없이 잘 들어가게 처리
        int idx = 1;
        for(int i =1; i<arr.length ; i++){
            if(arr[i-1] != arr[i]){
                answer[idx] = arr[i];
                idx++;
            }
        }    
        
        return answer;
    }
}
