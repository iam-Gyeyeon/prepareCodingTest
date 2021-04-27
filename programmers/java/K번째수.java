/*
총평
1. 2차원 배열을 오랜만에 해서 살짝 당황했지만 노트에 그려가면서 금방 해결할 수 잇었음
2. 그렇게 어려운 문제는 아니었음
3. 문제상 복병이 있다면 문제에서 명시된 "K번째"는 당연하게 배열이기때문에 "K-1번째"라고 생각해야 했음
   (당연한 이야기인데 뭔가 바로 캐치하지 못한 내가 웃긴..)
*/
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        //commands의 갯수만큼 loop 
        for(int i=0; i<commands.length; i++){
            //commands[i]안의 배열 길이만큼 자르기(잘라서 복사)
            int temp[] = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            //정렬
            Arrays.sort(temp);
            //정렬 후 k번째(commands[i][2]-1)의 값을 answer에 누적
            answer[i]=temp[commands[i][2]-1];
        }
      
     
        return answer;
    }
}
