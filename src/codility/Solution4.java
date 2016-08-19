package codility;

public class Solution4 {

	public long factorial(int num) {
		long result = 1;
		for (int i = num; i >= 1; i--)
			result *= i;

		return result;
	}

	public int solution(int N) {

		String number = String.valueOf(N);
		int[] num = new int[10];

		for (int i = 0; i <number.length(); i++) {
			int tmp = Integer.parseInt(String.valueOf(number.charAt(i)));
			num[tmp]++;
		}
		long n1 = factorial(number.length());
		long n2 = 1;

		for (int i = 0; i <num.length; i++) {
			n2 *= factorial(num[i]);
		}

		return (int) (n1 / n2); // ���� ���� n1 C n2
	}

	public static void main(String[] args) {

		Solution4 sl = new Solution4();
		System.out.println(sl.solution(1213));
	}
}
