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
    static List<Village> villageList;

    static class Village {
        int id;
        int userCount;
        boolean isGreat;
        List<Village> prevVillage = new ArrayList<>();
        List<Village> nextVillage = new ArrayList<>();

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

        public List<Village> getPrevVillage() {
            return prevVillage;
        }

        public void setPrevVillage(Village prevVillage) {
            this.prevVillage.add(prevVillage);
        }

        public List<Village> getNextVillage() {
            return nextVillage;
        }

        public void setNextVillage(Village nextVillage) {
            this.nextVillage.add(nextVillage);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        init();

        int result = 0;
        for(Village village : villageList) {
            if(village.isGreat()) continue;
            village.setGreat(true);
            result += village.getUserCount();
        }

        System.out.println(result);
    }

    private static void init() throws FileNotFoundException {
        InputStream in = new FileInputStream("C:/Users/Kim YJ/Desktop/1949.txt");
        Scanner scanner = new Scanner(new InputStreamReader(in));
        n = scanner.nextInt();
        villageList = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            villageList.add(new Village(i, scanner.nextInt()));
        }
        for(int i = 1; i < n; i++) {
            int prevNumber = scanner.nextInt();
            int nextNumber = scanner.nextInt();
            Village prevVillage = villageList.get(prevNumber-1);
            Village nextVillage = villageList.get(nextNumber-1);
            prevVillage.setNextVillage(nextVillage);
            nextVillage.setPrevVillage(prevVillage);
            villageList.set(prevNumber-1, prevVillage);
            villageList.set(nextNumber-1, nextVillage);
        }
    }
}
