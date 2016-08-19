package codility;

public class T2_Ticket2 {
	static int oneDayTicket = 2;
	static int sevenDayTicket = 7;
	static int thirtyDayTicket = 25;
	static int result = 0;
	static int days;
	static int m;
	static int n;

	public static int solution(int[] A) {
		days = A.length;
		m = days / 30;
		n = days % 30;

		if (m > 0) {
			for (int m = 0; m < m; m++) {
				if (days > 23) {
					result += thirtyDayTicket;
				} else {
					int check = 0;
					int minus = 0;
					boolean flag = true;
					for (int i = 0; i < days; i++) {
						int endWeek = A[i] + 6;
						if (days - i < 3) {
							flag = false;
						}

						if (flag) {
							for (int j = i + 1; j < days; j++) {
								if (A[j] <= endWeek) {
									check++;
									minus++;
								} else {
									break;
								}
							}
						}
						if (check > 3) {
							result += sevenDayTicket;
							i += (check + 1);
							check = 0;
						}
					}
					days -= (minus + 1);
					result = result + (days * oneDayTicket);
				}
			}
			result = result + (n * oneDayTicket);
		} else {
			if (days > 23) {
				result += thirtyDayTicket;
			} else {
				int check = 0;
				int minus = 0;
				boolean flag = true;
				for (int i = 0; i < days; i++) {
					int endWeek = A[i] + 6;
					if (days - i < 3) {
						flag = false;
					}

					if (flag) {
						for (int j = i + 1; j < days; j++) {
							if (A[j] <= endWeek) {
								check++;
								minus++;
							} else {
								break;
							}
						}
					}
					if (check > 3) {
						result += sevenDayTicket;
						i += (check + 1);
						check = 0;
					}
				}
				days -= (minus + 1);
				result = result + (days * oneDayTicket);
			}

		}

		return result;
	}

	public static void main(String[] args) {
		// 1, 2, 4, 5, 7, 29, 30
		int A[] = new int[] {};
		System.out.println(solution(A));
	}

}
