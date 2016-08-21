import java.util.Scanner;
import java.util.Stack;

/*
 * 괄호쌍이 맞으면 vps(valid)
 * 괄호쌍이 맞는지 여부에 대한 체크
 * 시간제한 1초, O(N) -> 이유는 한번의 case를 스택으로 작업하는데 n만큼의 시간이 들고 T에 따라 달라지므로 T*n = n이므로...
 * ))((같은 예외처리를 하려면 ')'문자열이 들어왔을 때 바로바로 체크해줘야 한다.(완전 거꾸로인 경우에 대해서도 체크!)
 */
public class T9012_PS_Stack {
	static int T, psLength, psCount;
	static Scanner scan;
	static Stack<String> stack;
	static String ps;
	static boolean isException;
 	
	private static void init() {
		stack.clear();
		psCount = 0;
		ps = scan.next();
		psLength = ps.length();
	}
	
	private static void result() {
		if(isException == false) {
			if(stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		isException = false;
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		T = scan.nextInt();
		stack = new Stack<String>();
		while(T-- > 0) {
			init();
			for(int i = 0; i < psLength; i++) {
				if("(".equals(String.valueOf(ps.charAt(i)))) {
					stack.push("(");
				} else if(")".equals(String.valueOf(ps.charAt(i)))){
					try {
						stack.pop();
					} catch (Exception e) {
						System.out.println("NO");
						isException = true;
						break;
					}
				}
			}
			result();
		}
	}

}
