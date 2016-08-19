package codility;

class T1_Monkey {
	static int n;
	static int result;
	static int k;

	public static int solution(int[] A, int D) {
		n = A.length;
		result = 0;
		k = 0;

		while (A[k] > 0) {
			result++;
			k += D;
			if (k == n) {
				return result;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int A[] = new int[] { 1, -1, 0, 2, 3, 5 };
		System.out.println(solution(A, 3));
	}

}
