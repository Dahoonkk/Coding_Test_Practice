package practice;

/*
 *   << 문제 >>
 *   10미만의 자연수에서 3과 5의 배수를 구하면 3,5,6,9이다. 이들의 총합은 23이다.
 *   1000미만의 자연수에서 3,5의 배수의 총합을 구하라.
 */

public class MultiplesOf3and5 {
	public static void main(String[] args) {
		int result = getTotal(3, 5, 1000);
		System.out.println(result);
	}

	public static int getTotal(int a, int b, int maxNum) {
		int total = 0;
		for(int i=1; i<maxNum; i++) {
			if(i%a==0 || i%b==0) total += i;
		}

		return total;
	}
}
