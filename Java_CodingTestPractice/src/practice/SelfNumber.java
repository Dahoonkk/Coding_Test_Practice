package practice;

/*
 *  << 넥슨 입사문제 중 >>
 *  어떤 자연수 n이 있을 때, d(n)을 n의 각 자릿수 숫자들과 n 자신을 더한 숫자라고 정의하자
 *  예를 들어
 *  d(91) = 9 + 1 + 91 = 10
 *  이 때, n을 d(n)의 제네레이터(generator)라고 한다. 위의 예에서 91은 101의 제네레이터이다.
 *  어떤 숫자들은 하나 이상의 제네레이터를 가지고 있는데, 101의 제네레이터는 91 뿐 아니라 100도 있다.
 *  그런데 반대로, 제네레이터가 없는 숫자들도 있으며, 이런 숫자를 인도의 수학자 Kaprekar가 셀프 넘버(self-number)라 이름 붙였다.
 *  예를 들어 1,3,5,7,9,20,31 은 셀프 넘버들이다.
 *  1 이상이고 5000 보다 작은 모든 셀프 넘버들의 합을 구하라.
 */

public class SelfNumber {
	public static void main(String[] args) {
		int sumSelfNum = getSelfNumTotal(5000);
		System.out.println(sumSelfNum);
	}

	public static int GeneratorNum(int num) {
		int oneDigit = num % 10;
		int tenDigit = (num / 10) % 10;
		int hunDigit = (num / 100) % 10;
		int thoDigit = (num / 1000) % 10;

		int generatorNum = num + oneDigit + tenDigit + hunDigit + thoDigit;
		return generatorNum;
	}

	public static int getSelfNumTotal(int maxNum) {
		int total = 0;
		Loop1 : for (int i=1; i<maxNum; i++) {
			for(int j=1; j<i; j++) {
				if(i==GeneratorNum(j)) continue Loop1;
			}
			total += i;
		}

		return total;
	}
}
