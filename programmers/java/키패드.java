/*
판별 해야 될 것
1. 현재 내 손가락의 위치
2. 목표 숫자(배열 값)에 왼손이 가까운지 오른손이 가까운지 판별(좌표 이용?)
- 이 부분에서 무식하게 패턴 찾아서 공식을 세웠는데, 다른 방법이 있는지
- 거리 공식 생각 안나서 검색해봄.. 
3. 그 판별한 값과 배열 안의 값이 일치하면 ? 
*/


class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int left = 10;
        int right = 12;
        
        for (int i=0; i<numbers.length; i++) {
            int num = numbers[i];
            
            if (num == 1 || num == 4 || num == 7) {
                //왼손 범위에 도달했을 때 
                answer += "L";           //답에 L을 붙이기
                left = num;             //현재 손가락 위치에 번호 저장하기
            } else if (num == 3 || num == 6 || num == 9) {
                //오른손 범위
                answer += "R";
                right = num;
            } else {
                //가운데일 경우 
                int leftFinger = calculate(left, num);
                int rightFinger = calculate(right, num);
                
                if (leftFinger > rightFinger) {
                    //왼손이 거리가 더 멀면 오른손
                    answer += "R";
                    right = num;
                } else if (leftFinger < rightFinger) {
                    //오른손이 거리가 더 멀면 왼손
                    answer += "L";
                    left = num;
                } else {
                    if (hand.equals("right")) {
                        answer += "R";
                        right = num;
                    } else {
                        answer += "L";
                        left = num;
                    }
                }
                
            }
        }
        
        return answer;
    }

    //가운데 손가락일 경우 목적지(?)까지 가까운 손가락 좌표의 거리를 계산
    public static int calculate(int location, int num) {
        
        //왼손 or 오른손 위치가 0일때 11 대입
        if (location == 0) {
            location = 11;
        }
        
        //다음 숫자 위치가 0일때 11 대입
        if (num == 0) {
            num = 11;
        }
        
        //왼손 or 오른손의 X좌표, Y좌표 구하기
        int locationX = (location - 1)/3;
        int locationY = (location - 1)%3;
        
        //다음 숫자의 X좌표, Y좌표 구하기
        int numX = (num - 1)/3;
        int numY = (num - 1)%3;
        
        //절대값으로 거리 구하기
        int result = Math.abs(locationX - numX) + Math.abs(locationY - numY);
        
        return result;
    }
}
