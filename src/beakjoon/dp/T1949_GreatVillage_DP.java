package beakjoon.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T1949_GreatVillage_DP {
    static int n;
    static List<Village> villageList = new ArrayList<>();
    static class Village {
        int id;
        int userCount;
        int maxSumGreat = -1;
        int maxSumNotGreat = -1;
        boolean isGreat;
        List<Village> childVillage = new ArrayList<>();

        public Village(int id, int userCount) {
            this.id = id;
            this.userCount = userCount;
        }

        public int getUserCount() {
            return userCount;
        }

        public boolean isGreat() {
            return isGreat;
        }

        public void setGreat(boolean great) {
            isGreat = great;
        }

        public List<Village> getChildVillage() {
            return childVillage;
        }

        public void setChildVillage(List<Village> childVillage) {
            this.childVillage = childVillage;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        init();
        isGreate(villageList.get(0));
        isNotGreate(villageList.get(0));
        //System.out.println(result);
    }

    private static void isGreate(Village village) {
        if(village.maxSumGreat > -1 || village.maxSumNotGreat > -1) {
            return;
        }
        village.setGreat(true);
        List<Village> childVillage = village.getChildVillage();
        childVillage.stream().forEach(notGreatevillage -> isNotGreate(notGreatevillage));
    }

    private static void isNotGreate(Village village) {
        if(village.maxSumGreat > -1 || village.maxSumNotGreat > -1) {
            return;
        }
        int count = (int) Math.pow(2.0, village.getChildVillage().size());
        for(int i = 0; i < count; i++) {

        }
    }

    private static void init() throws FileNotFoundException {
        InputStream in = new FileInputStream("C:/Users/Kim YJ/Desktop/1949.txt");
        Scanner scanner = new Scanner(new InputStreamReader(in));
        //Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 1; i <= n; i++) {
            villageList.add(new Village(i, scanner.nextInt()));
        }
        for(int i = 1; i < n; i++) {
            int prevNumber = scanner.nextInt();
            int nextNumber = scanner.nextInt();
            Village village = villageList.get(prevNumber-1);
            Village childVillage = villageList.get(nextNumber-1);
            List<Village> villageList = village.getChildVillage();
            villageList.add(childVillage);
            village.setChildVillage(villageList);
        }
    }
}
