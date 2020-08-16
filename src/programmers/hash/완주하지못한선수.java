package programmers.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * ������ ������ �������� �����濡 �����Ͽ����ϴ�. �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.
 * �����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��, �������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
      ���ѻ���
	������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�.
	completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�.
	�������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
	������ �߿��� ���������� ���� �� �ֽ��ϴ�.
	
	����� ��
		participant	completion	return
		[leo, kiki, eden]	[eden, kiki]	leo
		[marina, josipa, nikola, vinko, filipa]	[josipa, filipa, marina, nikola]	vinko
		[mislav, stanko, mislav, ana]	[stanko, ana, mislav]	mislav
	
	����� �� ����
		���� #1
			leo�� ������ ��ܿ��� ������, ������ ��ܿ��� ���� ������ �������� ���߽��ϴ�.
		
		���� #2
			vinko�� ������ ��ܿ��� ������, ������ ��ܿ��� ���� ������ �������� ���߽��ϴ�.
		
		���� #3
			mislav�� ������ ��ܿ��� �� ���� ������, ������ ��ܿ��� �� ��ۿ� ���� ������ �Ѹ��� �������� ���߽��ϴ�.
 * @author mgpc
 *
 */
public class �����������Ѽ��� {
	public static void main(String[] args) {
		String[] participant1 = new String[]{"leo", "kiki", "eden"};
		String[] completion1 = new String[]{"eden", "kiki"};
		
		String[] participant2 = new String[]{ "marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion2 = new String[]{ "josipa", "filipa", "marina", "nikola"};
		
		String[] participant3 = new String[]{ "mislav", "stanko", "mislav", "ana"};
		String[] completion3 = new String[]{ "stanko", "ana", "mislav"};
		
		Solution sol = new Solution();
		String answer1 = sol.solution(participant1, completion1);
		String answer2 = sol.solution(participant2, completion2);
		String answer3 = sol.solution(participant3, completion3);
		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);
	}
	
	static class Solution {
	    public String solution(String[] participant, String[] completion) {
	        String answer = "";
	        Map<String, Integer> map = new HashMap<>();
	        for (String string : participant) {
	        	map.put(string, map.getOrDefault(string, 0)+1);
			}
	        for (String str : completion) {
	        	map.put(str, map.get(str)-1);
			}
	        for (String str : map.keySet()) {
				if(map.get(str) == 1) {
					answer = str;
					break;
				}
			}
	        return answer;
	    }
	}
}
