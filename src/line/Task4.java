import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

//stamp값이 필요. add or get된지 오래된 것을 찾기 위해
public class Task4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CustomMap customMap = new CustomMap();

        while (true) {
            String input[] = br.readLine().split(" ");
            switch (input[0]) {
                case "evict":
                    customMap.evict();
                    break;
                case "add":
                    customMap.add(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                    break;
                case "get":
                    System.out.println(customMap.get(Integer.parseInt(input[1])));
                    break;
                case "remove":
                    System.out.println(customMap.remove(Integer.parseInt(input[1])));
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("올바르지 않은 명령어입니다.");
                    System.exit(0);
            }
        }
    }

    private static class CustomMap {
        private LinkedHashMap<Integer, Cache> linkedHashMap;

        public CustomMap() {
            this.linkedHashMap = new LinkedHashMap<>();
        }

        public void evict() {
            TreeMap<Integer, Cache> sortedMap = new TreeMap<>(new CompareCount(this.linkedHashMap));
            sortedMap.putAll(this.linkedHashMap);
            this.linkedHashMap.remove(sortedMap.lastEntry().getKey());
        }

        public void add(int key, int value) {
            linkedHashMap.put(key, new Cache(value));
        }

        public int get(int key) {
            int result;

            try {
                result = linkedHashMap.get(key).getValue();
            } catch (NullPointerException e) {
                return -1;
            }

            return result;
        }

        public int remove(int key) {
            int result;

            try {
                result = linkedHashMap.remove(key).getValue();
            } catch (NullPointerException e) {
                return -1;
            }

            return result;
        }
    }

    private static class Cache {
        private int count;
        private int value;

        public Cache(int value) {
            addCount();
            this.value = value;
        }

        private void addCount() {
            this.count++;
        }

        public int getCount() {
            return count;
        }

        public int getValue() {
            addCount();
            return value;
        }
    }

    private static class CompareCount implements Comparator<Integer> {
        LinkedHashMap<Integer, Cache> linkedHashMap;

        public CompareCount(LinkedHashMap<Integer, Cache> linkedHashMap) {
            this.linkedHashMap = linkedHashMap;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(this.linkedHashMap.get(o2).getCount(), this.linkedHashMap.get(o1).getCount());
        }
    }

}
