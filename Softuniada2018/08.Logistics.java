package Softuniada2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Logistics {

    private static List<Package> packages = new ArrayList<>();
    private static Set<Integer> delivered = new HashSet<>();
    private static Set<Integer> crashDays = new HashSet<>();
    private static int[] deliveries;
    private static int totalValue = 0;

    public static void main(String[] args) throws IOException {
        readInput();
        packages.sort(Comparator.naturalOrder());
        addSuccessfulDeliveries();
        addUnsuccessfulDeliveries();
        System.out.println(buildOutputString());
    }

    private static void readInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            int price = Integer.parseInt(tokens[0]);
            int deadline = Integer.parseInt(tokens[1]);
            if (deadline > maxDeadline) {
                maxDeadline = deadline;
            }
            packages.add(new Package(i + 1, price, deadline - 1));
        }
        deliveries = new int[maxDeadline];
        String line = reader.readLine();
        if (!line.equals("none")) {
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                int dayIndex = Integer.parseInt(token) - 1;
                crashDays.add(dayIndex);
            }
        }
    }

    private static void addUnsuccessfulDeliveries() {
        int count = 0;
        for (int i = packages.size() - 1; i >= 0; i--) {
            if (count >= crashDays.size()) {
                break;
            }
            Package pack = packages.get(i);
            if (delivered.contains(pack.getIndex())) {
                continue;
            }
            int deadline = pack.getDeadline();
            int index = Math.min(deadline, deliveries.length - 1);
            while (index > -1 && index <= deadline && (!crashDays.contains(index) || deliveries[index] != 0)) {
                index--;
            }
            if (index == -1) {
                continue;
            }
            deliveries[index] = pack.getIndex();
            totalValue -= 50 + pack.getPrice();
            count++;
        }
    }

    private static void addSuccessfulDeliveries() {
        int count = 0;
        for (Package pack : packages) {
            if (count >= deliveries.length - crashDays.size()) {
                break;
            }
            int deadline = pack.getDeadline();
            int index = Math.min(deadline, deliveries.length - 1);
            while (index > -1 && index <= deadline && (crashDays.contains(index) || deliveries[index] != 0)) {
                index--;
            }
            if (index == -1) {
                continue;
            }
            deliveries[index] = pack.getIndex();
            totalValue += pack.getPrice();
            delivered.add(pack.getIndex());
            count++;
        }
    }

    private static String buildOutputString() {
        StringBuilder sb = new StringBuilder();
        sb.append(totalValue).append(System.lineSeparator());
        for (int delivery : deliveries) {
            sb.append(delivery).append(" ");
        }
        return sb.toString();
    }

    private static class Package implements Comparable<Package> {
        private int index;
        private int price;
        private int deadline;

        Package(int index, int price, int deadline) {
            this.index = index;
            this.price = price;
            this.deadline = deadline;
        }

        public int getIndex() {
            return index;
        }

        public int getPrice() {
            return price;
        }

        public int getDeadline() {
            return deadline;
        }

        @Override
        public int compareTo(Package o) {
            return o.price - this.price;
        }
    }
}