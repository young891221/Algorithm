package codility.D20171118;

public class Task1 {

    enum SubStitute {
        AB("AB", "A"),
        BA("BA", "A"),
        CB("CB", "C"),
        BC("BC", "C"),
        AA("AA", "A"),
        CC("CC", "C");

        String target;
        String value;

        SubStitute(String target, String value) {
            this.target = target;
            this.value = value;
        }
    }

    static String convertIfPossible(String target) {
        for(SubStitute sub : SubStitute.values()) {
            if(sub.target.equals(target)) { return sub.value; }
        }
        return target;
    }

    public static String solution(String S) {
        for(int i = 0; i < S.length(); i++) {
            if(S.length() < i+2) break;
            String preString = S.substring(0, i);
            String target = S.substring(i, i+2);
            String postString = S.substring(i+2);
            String converTarget = convertIfPossible(target);
            S = preString + converTarget + postString;

            if(!target.equals(converTarget)) i = -1;
        }
        return S;
    }

    public static void main(String[] args) {
        System.out.println(solution("ABBCC"));//AC
        System.out.println(solution("ACBAACC"));//ACAC
        System.out.println(solution("BBBCCCAA"));//CA
        System.out.println(solution("BBBCCCAAAACBCBABCBAB"));//CACACA
    }
}
