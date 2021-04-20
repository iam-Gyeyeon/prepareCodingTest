/*총평*
- 전반적으로 요구하는것이 직관적이여서 .toLowerCase .charAt과 같은 추억의 함수를 기억해내는것이 관건이었다.
- 소스는 짧아야 된다는 고정관념(?) 때문에 이게 맞나 고민하는 시간이 오히려 길었던 문제
- 직독직해 하듯이 문제에서 요구하는 그대로 진행하는것이 키포인트였음

- 하지만 이렇게 생각하는것도 잠시 정규표현식으로 쓴 답을 보면서 정말 감탄을 금치 못했음
- 그렇지만 감탄은 감탄일뿐 정규표현식을 해야겠다(?)는 생각이 들진 않는다.
*/

class Solution {
    public String solution(String new_id) {
		// 1. 소문자로 변경
		new_id = new_id.toLowerCase();

		// 2. 소문자 숫자 -_. 제외한 모든 문자 제거 
		String id = "";
		for(int i = 0; i < new_id.length(); i++) {
			char ch = new_id.charAt(i);

			if(ch >= 'a' && ch <= 'z') {
				id += String.valueOf(ch);
			} else if(ch >= '0' && ch <= '9') {
				id += String.valueOf(ch);
			} else if(ch == '.' || ch == '-' || ch == '_') {
				id += String.valueOf(ch);
			}
		}

		// 3. .은 연속으로 찍혀도 1개로 간주
		for(int i = 0; i < id.length(); i++) {
			if(id.charAt(i) == '.') {
				int j = i+1;
				String dot = ".";

				while(j != id.length() && id.charAt(j) == '.') {
					dot += ".";
					j++;
				}

				if(dot.length() > 1)
					id = id.replace(dot, ".");
			}
		}

		// 4. 첫번째, 마지막 . 제거
		if(id.startsWith(".") ) {
			id = id.substring(1, id.length());
		} else if(id.endsWith(".")) {
			id = id.substring(0, id.length()-1);
		}

		// 5. 빈 문자열이라면 a 대입 
		if(id.length() == 0) {
			id += "a";
		}

		// 6. 16자 이상이면, 15자만 남김 
		if(id.length() >= 16) {
			id = id.substring(0, 15);
		}
        
		// 마지막 . 제거 
		if(id.endsWith(".")) {
			id = id.substring(0, id.length()-1);
		}

		// 7. 2자 이하라면, 마지막 문자 길이 3까지 반복해서 붙임 
		String last = id.charAt(id.length()-1) + "";
		if(id.length() == 2) {
			id = id + last;
		} else if(id.length() == 1) {
			id = id + last + last;
		}

		return id;
    }
}



/*내가 무릎을 탁 친 소스*/
class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase(); // 1단계

        answer = answer.replaceAll("[^-_.a-z0-9]", ""); // 2단계
        answer = answer.replaceAll("[.]{2,}", "."); // 3단계
        answer = answer.replaceAll("^[.]|[.]$", "");    // 4단계
        
        if (answer.equals("")) {    // 5단계
            answer += "a";
        }

        if (answer.length() >= 16) {     // 6단계
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$","");
        }

        if (answer.length() <= 2) {  // 7단계
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length()-1);
            }
        }

        return answer;
    }
}
