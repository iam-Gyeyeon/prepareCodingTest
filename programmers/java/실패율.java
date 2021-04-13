/*
접근 방법
1. 주어진 N과 stages의 의미 파악
2. 실패율 공식에 필요한 값 도출
  - noClearPlayer (못 깨고 있는 Player) 
  - cuurentStagePlayer (현재 stage의 Player)
3. 요구조건에 맞는 정리
   (실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return)
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
 
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        //state와 FailureRate를 저장할 map
        Map<Integer,Double> infoMap = new HashMap<>();
       
        //Stage의 개수만큼 반복 loop
        for(int i=1; i<=N; i++) {
            int stage = i;
            int noClearPlayer = 0;
            int currentStagePlayer = 0;
            
	        //stages.length == 사람의 인원수 만큼 반복 loop
            for(int j=0; j < stages.length; j++) {
                int player = stages[j];
                
                //못 깨고 있는 player는 stages의 배열의 값과 같음
                if(stage == player) {	
                    noClearPlayer++;
                }
                //현재 스테이지 도전자
                if(stage<=player) {
                    currentStagePlayer++;
                }
            }
            
            //스테이지에 도달한 유저가 없는 경우 실패율 = 0
            //실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수 (도전자수)

            double failureRate = 0;
            if(noClearPlayer!=0 && currentStagePlayer!=0) {
                failureRate = (double)noClearPlayer / (double)currentStagePlayer;
            }
            
            infoMap.put(stage, failureRate);
            
        }
        
        //value순 정렬하여 요구하는 조건에 맞게 answer 배열에 넣어주기
        for(int i=0; i<N; i++) {
            double max = -1;
            int maxKey = 0;
            for(Integer key : infoMap.keySet()) {
                if(max < infoMap.get(key)) {
                    max = infoMap.get(key);
                    maxKey = key;
                }
            }
            answer[i] = maxKey;
            infoMap.remove(maxKey);
        }
 
        return answer;
    }
}
