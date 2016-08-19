package codility;

public class T2_Ticket {
	static int oneDayTicket = 2;
	static int sevenDayTicket = 7;
	static int thirtyDayTicket = 25;
	static int days;
	static int m;
	static int n;
	
	public static int solution(int[] A) {
		days = A.length;
		m = days/30;
		n = days%30;
		
		if (days > 0) {
			for(int i = 0; i < days; i++) {
				
			}
		}

		return A.length;
	}
	
	static boolean checkDay(int a, int b) {
		if((b-a) > 1) {
			
		}
		
		return false;
	}

	public static void main(String[] args) {
		int A[] = new int[] { 1, 2, 4, 5, 7, 29, 30 };
		System.out.println(solution(A));
	}

}
