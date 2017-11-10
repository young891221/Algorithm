package beakjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class T1949_GreatVillage_Good_DP {
    static Town[] towns;
    public static void main(String[] args) throws IOException {
        FS sc = new FS();

        int numOfTown = sc.nextInt() + 1;
        int startTown = 0;
        int[] population = new int[numOfTown];
        towns = new Town[numOfTown];

        for(int i = 1 ; i < numOfTown ; ++i)
            population[i] = sc.nextInt();

        //init
        for(int i = 2 ; i < numOfTown ; ++i) {
            int from = sc.nextInt();
            if(startTown == 0)
                startTown = from;
            int to = sc.nextInt();

            if(towns[from] == null && towns[to] == null) {
                Town fromTown = new Town(population[from]);
                Town toTown = new Town(population[to]);
                towns[from] = fromTown;
                towns[to] = toTown;
                fromTown.nearTowns.add(toTown);
            } else if(towns[from] == null) {
                Town toTown = towns[to];
                Town fromTown = new Town(population[from]);
                towns[from] = fromTown;
                toTown.nearTowns.add(fromTown);
            } else {
                // to town is null
                Town fromTown = towns[from];
                Town toTown = new Town(population[to]);
                towns[to] = toTown;
                fromTown.nearTowns.add(toTown);
            }
        }

        System.out.println(Math.max(solveNoExTown(towns[startTown]), solveExTown(towns[startTown])));
    }

    private static int solveExTown(Town rootTown) {
        //cached data
        if(rootTown.maxSumExTown > -1)
            return rootTown.maxSumExTown;

        //useless code
        if(rootTown.nearTowns.isEmpty()) {
            return rootTown.maxSumExTown = rootTown.population;
        }

        int maxSum = rootTown.population;
        for(Town nearTown : rootTown.nearTowns) {
            maxSum += solveNoExTown(nearTown);
        }

        return rootTown.maxSumExTown = maxSum;
    }

    private static int solveNoExTown(Town rootTown) {
        if(rootTown.maxSumNotExTown > -1)
            return rootTown.maxSumNotExTown;

        if(rootTown.nearTowns.isEmpty()) {
            return rootTown.maxSumNotExTown = 0;
        }

        int maxSum = 0;
        int possiblity = (int) Math.pow(2.0, rootTown.nearTowns.size());

        for(int i = 1 ; i <= possiblity ; ++i) {
            String bitStr = Integer.toBinaryString(i);
            int limit = rootTown.nearTowns.size();
            int prependSize = limit - bitStr.length();
            if(prependSize > 0) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < prependSize; ++j) {
                    sb.append('0');
                }
                bitStr = sb.append(bitStr).toString();
            }
            int tempSum = 0;
            int length = bitStr.length() - 1;
            for(int j = 0 ; j < limit ; ++j) {
                if(bitStr.charAt(length - j) == '0') {
                    tempSum += solveNoExTown(rootTown.nearTowns.get(j));
                } else {
                    tempSum += solveExTown(rootTown.nearTowns.get(j));
                }
            }
            maxSum = Math.max(maxSum, tempSum);
        }
        return rootTown.maxSumNotExTown = maxSum;
    }

    static class Town {
        int population = 0;
        int maxSumExTown = -1;
        int maxSumNotExTown = -1;
        List<Town> nearTowns = new ArrayList<>();

        Town(int population) {
            this.population = population;
        }
    }
    static class FS {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int nextInt() throws IOException {
            if(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}