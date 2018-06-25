package Telerik;

import java.util.*;

public class ArraySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split("[\\s+,]")).mapToInt(Integer::parseInt).toArray();
        int n = array.length;
        Boolean[] bitmap = new Boolean[n + 1];
        for (int i = 1; i <= n; i++)
        {
            bitmap[i] = false;
        }
        for (int i = 0; i < n; i++)
        {
            bitmap[array[i]] = true;
        }
        List<Integer> missingNumbers = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++)
        {
            if (!bitmap[i])
            {
                missingNumbers.add(i);
            }
        }
        System.out.print(missingNumbers.get(0));
        for (int i = 1; i < missingNumbers.size(); i++) {
            System.out.print("," + missingNumbers.get(i));
        }
    }
}
