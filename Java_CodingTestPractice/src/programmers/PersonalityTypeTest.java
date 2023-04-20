package programmers;

/* [an, cf, mj, rt, na] [5, 3, 2, 7, 5] tcma
 * [tr, rt, tr] [7, 1, 3] rcja
 *
 * 1 2 3 4 5 6 7
 * 3 2 1 0 1 2 3
 *
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PersonalityTypeTest {
	static Map<String, Integer> score = new HashMap<String, Integer>();

	public static String solution(String[] typeArr, int[] choice) {
		String answer = "";

		for(int i=0; i<typeArr.length; i++) {
			int val = choice[i];
			String chFirst = typeArr[i].substring(0,1);
			String chSecond = typeArr[i].substring(1,2);

			if (val > 0 && val < 4) {
				score.put(chFirst, getScore(val));
			} else if (val > 4) {
				score.put(chSecond, getScore(val));
			}
		}

		return scoreComparison("R", "T") + scoreComparison("C", "F") + scoreComparison("J", "M") + scoreComparison("A", "N");
	}

	public static int getScore(int val) {
		int score = 0;

		if(val == 1 || val == 7) {
			score = 3;
		} else if(val == 2 || val == 6) {
			score = 2;
		} else if(val == 3 || val == 5) {
			score = 1;
		} else {
			score = 0;
		}

		return score;
	}

	public static String scoreComparison(String ch1, String ch2) {
		String characterType = "";
		Integer sc1 = score.get(ch1);
		Integer sc2 = score.get(ch2);

		if(sc1 == null) {
			sc1 = 0;
		}
		if(sc2 == null) {
			sc2 = 0;
		}

		if(sc1 > sc2) {
			characterType = ch1;
		} else if(sc1 < sc2) {
			characterType = ch2;
		} else {
			int compareResult = ch1.compareTo(ch2);
			if(compareResult > 0) {
				characterType = ch2;
			} else if(compareResult < 0) {
				characterType = ch1;
			}
		}

		return characterType;
	}

	public static void main(String[] args) {
		String[] type = new String[]{"AN", "CF", "MJ", "RT", "NA"};
		int[] score = new int[]{5, 3, 2, 7, 5};
		// TCMA

		String[] type2 = new String[] {"TR", "RT", "TR"};
		int[] score2 = new int[]{7, 1, 3};
		// RCJA

		String answer = solution(type, score);
		System.out.println(answer);

		String answer2 = solution(type2, score2);
		System.out.println(answer2);
	}
}
