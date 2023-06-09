package programmers;

/*
 * <프래그래머스 Lv.2>
 *
 * x축과 y축으로 이루어진 2차원 직교 좌표계에 중심이 원점인 서로 다른 크기의 원이 두 개 주어집니다.
 * 반지름을 나타내는 두 정수 r1, r2가 매개변수로 주어질 때,
 * 두 원 사이의 공간에 x좌표와 y좌표가 모두 정수인 점의 개수를 return하도록 solution 함수를 완성해주세요.
 * 각 원 위의 점도 포함하여 셉니다.
 *
 */

public class twoCirclePoint {
	public static long solution(long r1, long r2) {
		long answer = 0;

		for(int i=1; i<=r2; i++) {
			long inner = getInner(r1, i);
			long outer = getOuter(r2, i);

			answer += (outer - inner + 1);
			System.out.println(i+"번째 answer : " + answer);
		}

		return answer*4;
	}

	public static long getInner(long r1, int i) {
		long inner = (int)Math.ceil(Math.sqrt(1.0*r1*r1 - 1.0*i*i));
		System.out.println(i+"번째 inner : " + inner);
		return inner;
	}

	public static long getOuter(long r2, int i) {
		long outer = (int)Math.floor(Math.sqrt(1.0*r2*r2 - 1.0*i*i));
		System.out.println(i+"번째 outer : " + outer);
		return outer;
	}

	public static void main(String[] args) {
		long a = solution(1,2);
		System.out.println(a);
	}

}
